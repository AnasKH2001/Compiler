# miniFlask/miniJinja Compiler — 2025/2026

Java + ANTLR compiler for the miniFlask (Python-subset) and miniJinja (Jinja2-subset)
languages, matching the course's official Phase-2 clarification.

## Two-phase project

- **Phase A (reference app)**: `reference_flask_app/` — a small, real, working Flask +
  Jinja2 CRUD app (products list/add/edit/delete). This is the ground-truth spec for
  correct output; it is NOT compiled by our compiler, it's what our compiler's output
  should resemble.
- **Phase B (the actual compiler)**: everything under `src/` — a Java/ANTLR compiler
  that reads its own `.miniflask` / `.jinja`-style source files and independently
  generates the same kind of HTML output, via lexer -> parser -> AST -> semantic
  analysis -> generator.

## Structure

```
miniflask-compiler/
├── pom.xml
├── src/main/antlr4/com/compiler/grammar/
│   ├── MiniFlask.g4      # grammar for the Python-subset language
│   └── MiniJinja.g4      # grammar for the Jinja2-subset language
├── src/main/java/com/compiler/
│   ├── ast/              # AST node classes (inheritance/polymorphism hierarchy)
│   ├── semantic/         # semantic analysis (5 required error types)
│   ├── generator/        # AST -> HTML generation
│   └── app/              # main entry point wiring it all together
├── reference_flask_app/  # Phase A: the real Flask+Jinja app
├── output/                # generated: index.html, add_product.html, edit_product.html
└── compiler_output/       # generated: ast_python.json, ast_jinja.json, semantic_report.txt, generation_log.txt
```

## Required semantic errors (per official clarification)

1. Undefined variable
2. Type error
3. Scope error
4. Type mismatch
5. Missing flask variable

## Build

Requires JDK 21+ and Maven. In IntelliJ: open this folder, let Maven auto-import,
then run `mvn generate-sources` (or just build) to trigger ANTLR code generation
from the `.g4` files before writing Java code that depends on the generated
Lexer/Parser classes.
