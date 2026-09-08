package com.compiler.generator;

import com.compiler.ast.jinja.MiniJinjaAstBuilder;
import com.compiler.ast.jinja.TemplateNode;
import com.compiler.grammar.MiniJinjaLexer;
import com.compiler.grammar.MiniJinjaParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Orchestrates requirement 6: builds the full set of CRUD web pages.
 *
 * Key idea: a template's AST only needs to be built ONCE (parsing is
 * expensive-ish, rendering is cheap) - so product_detail.minijinja and
 * edit_product.minijinja are each parsed a single time, then RENDERED
 * once per product with different context data, producing a separate
 * static HTML file per product (product_detail_1.html, _2.html, ...).
 * This is exactly the same Generator machinery from before, just called
 * in a loop.
 */
public class SiteBuilder {

    public void buildSite(Map<String, Object> globalContext, Path outputDir) throws IOException {
        Files.createDirectories(outputDir);
        JinjaGenerator generator = new JinjaGenerator();

        renderOnce("samples/index.minijinja", globalContext, outputDir.resolve("index.html"), generator);
        renderOnce("samples/add_product.minijinja", globalContext, outputDir.resolve("add_product.html"), generator);

        TemplateNode detailAst = parseTemplate("samples/product_detail.minijinja");
        TemplateNode editAst = parseTemplate("samples/edit_product.minijinja");

        Object productsObj = globalContext.get("products");
        if (productsObj instanceof List<?> products) {
            for (Object productObj : products) {
                if (!(productObj instanceof Map<?, ?> product)) continue;
                Object idObj = product.get("id");
                if (idObj == null) continue;

                Map<String, Object> childContext = new HashMap<>(globalContext);
                childContext.put("product", product);

                String detailHtml = generator.render(detailAst, childContext);
                Files.writeString(outputDir.resolve("product_detail_" + idObj + ".html"), detailHtml);

                String editHtml = generator.render(editAst, childContext);
                Files.writeString(outputDir.resolve("edit_product_" + idObj + ".html"), editHtml);
            }
        }
    }

    private void renderOnce(String templatePath, Map<String, Object> context, Path outputFile, JinjaGenerator generator) throws IOException {
        TemplateNode ast = parseTemplate(templatePath);
        String html = generator.render(ast, context);
        Files.writeString(outputFile, html);
    }

    private TemplateNode parseTemplate(String path) throws IOException {
        String source = Files.readString(Path.of(path));
        MiniJinjaLexer lexer = new MiniJinjaLexer(CharStreams.fromString(source));
        MiniJinjaParser parser = new MiniJinjaParser(new CommonTokenStream(lexer));
        MiniJinjaParser.TemplateContext parseTree = parser.template();
        return new MiniJinjaAstBuilder().build(parseTree);
    }
}