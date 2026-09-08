"""
Real Flask app - the "live" layer on top of our Java compiler.

Architecture (matches the official course clarification):
    Browser submits a form
        -> Flask edits samples/products.miniflask (the actual source text)
        -> Flask runs our Java compiler as a subprocess to regenerate output/
        -> Flask redirects back to the freshly-regenerated page

This file does NOT understand miniFlask syntax deeply - it does simple,
line-based text editing, relying on the convention that each product dict
lives on its own single line. The real parsing/understanding of the
language is entirely the Java compiler's job; Flask just triggers it.
"""

import os
import re
import subprocess
from flask import Flask, request, redirect, send_from_directory

app = Flask(__name__)

PROJECT_ROOT = os.path.dirname(os.path.abspath(__file__))
OUTPUT_DIR = os.path.join(PROJECT_ROOT, "output")
SOURCE_FILE = os.path.join(PROJECT_ROOT, "samples", "products.miniflask")

HOME = os.path.expanduser("~")
M2_REPO = os.path.join(HOME, ".m2", "repository")
CLASSPATH = os.pathsep.join([
    os.path.join(PROJECT_ROOT, "target", "classes"),
    os.path.join(M2_REPO, "org", "antlr", "antlr4-runtime", "4.13.1", "antlr4-runtime-4.13.1.jar"),
    os.path.join(M2_REPO, "com", "google", "code", "gson", "gson", "2.11.0", "gson-2.11.0.jar"),
])


@app.route("/")
def index():
    return send_from_directory(OUTPUT_DIR, "index.html")


@app.route("/<path:filename>")
def static_page(filename):
    return send_from_directory(OUTPUT_DIR, filename)


@app.route("/add", methods=["POST"])
def add_product():
    name = request.form["name"]
    price = request.form["price"]
    qty = request.form["qty"]
    _add_product_to_source(name, price, qty)
    if not _regenerate():
        return "Regeneration failed - check the terminal running app.py for the error.", 500
    return redirect("/")


@app.route("/edit/<id>", methods=["POST"])
def edit_product(id):
    name = request.form["name"]
    price = request.form["price"]
    qty = request.form["qty"]
    _edit_product_in_source(id, name, price, qty)
    if not _regenerate():
        return "Regeneration failed - check the terminal running app.py for the error.", 500
    return redirect("/")


@app.route("/delete/<id>", methods=["POST"])
def delete_product(id):
    _delete_product_from_source(id)
    if not _regenerate():
        return "Regeneration failed - check the terminal running app.py for the error.", 500
    return redirect("/")


def _read_source():
    with open(SOURCE_FILE, "r", encoding="utf-8") as f:
        return f.read()


def _write_source(content):
    with open(SOURCE_FILE, "w", encoding="utf-8") as f:
        f.write(content)


LIST_BLOCK_RE = re.compile(r'(products\s*=\s*\[\s*\n)(.*?)(\n?\s*\])', re.DOTALL)


def _rewrite_products_block(content, transform):
    """transform receives a list of dict-line strings (no trailing commas/
    whitespace) and returns the new list of dict-line strings. This is the
    single place that decides comma formatting, so add/delete/edit can
    never produce a malformed (missing- or trailing-comma) list."""
    match = LIST_BLOCK_RE.search(content)
    if not match:
        raise RuntimeError("Could not find products list in source file")
    prefix, body, suffix = match.group(1), match.group(2), match.group(3)
    lines = [ln.strip().rstrip(',') for ln in body.split('\n') if ln.strip()]
    new_lines = transform(lines)
    new_body = ',\n'.join('    ' + ln for ln in new_lines)
    return content[:match.start()] + prefix + new_body + suffix + content[match.end():]


def _next_id(content):
    ids = [int(m) for m in re.findall(r'"id":\s*(\d+)', content)]
    return max(ids, default=0) + 1


def _add_product_to_source(name, price, qty):

    price = 0 if price == '' or price is None else int(price)
    qty = 0 if qty == '' or qty is None else int(qty)

    content = _read_source()
    new_id = _next_id(content)
    new_entry = '{"id": %d, "name": "%s", "price": %s, "qty": %s, "discount": False}' % (
        new_id, name, price, qty
    )
    content = _rewrite_products_block(content, lambda lines: lines + [new_entry])
    _write_source(content)

def _delete_product_from_source(id):
    content = _read_source()
    id_pattern = re.compile(r'"id":\s*' + re.escape(str(id)) + r'\b')
    content = _rewrite_products_block(content, lambda lines: [ln for ln in lines if not id_pattern.search(ln)])
    _write_source(content)


def _edit_product_in_source(id, name, price, qty):
    content = _read_source()
    id_pattern = re.compile(r'"id":\s*' + re.escape(str(id)) + r'\b')

    def transform(lines):
        result = []
        for ln in lines:
            if id_pattern.search(ln):
                ln = re.sub(r'"name":\s*"[^"]*"', '"name": "%s"' % name, ln)
                ln = re.sub(r'"price":\s*[0-9.]+', '"price": %s' % price, ln)
                ln = re.sub(r'"qty":\s*[0-9.]+', '"qty": %s' % qty, ln)
            result.append(ln)
        return result

    content = _rewrite_products_block(content, transform)
    _write_source(content)


def _regenerate():
    result = subprocess.run(
        ["java", "-cp", CLASSPATH, "com.compiler.app.RegenerateMain"],
        cwd=PROJECT_ROOT,
        capture_output=True,
        text=True,
    )
    print("--- regenerate stdout ---")
    print(result.stdout)
    if result.returncode != 0:
        print("--- regenerate stderr (FAILED) ---")
        print(result.stderr)
    return result.returncode == 0


if __name__ == "__main__":
    app.run(debug=True, port=5000)