package com.compiler.app;

import com.compiler.ast.MiniFlaskAstBuilder;
import com.compiler.ast.ProgramNode;
import com.compiler.ast.jinja.MiniJinjaAstBuilder;
import com.compiler.ast.jinja.TemplateNode;
import com.compiler.generator.PythonEvaluator;
import com.compiler.generator.SiteBuilder;
import com.compiler.grammar.MiniFlaskLexer;
import com.compiler.grammar.MiniFlaskParser;
import com.compiler.grammar.MiniJinjaLexer;
import com.compiler.grammar.MiniJinjaParser;
import com.compiler.semantic.SemanticAnalyzer;
import com.compiler.semantic.SemanticError;
import com.google.gson.GsonBuilder;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Map;

public class RegenerateMain {

    private static final StringBuilder log = new StringBuilder();

    public static void main(String[] args) throws IOException {
        log("Regeneration started at " + LocalDateTime.now());

        String flaskSource = Files.readString(Path.of("samples/products.miniflask"));
        MiniFlaskLexer flaskLexer = new MiniFlaskLexer(CharStreams.fromString(flaskSource));
        MiniFlaskParser flaskParser = new MiniFlaskParser(new CommonTokenStream(flaskLexer));
        MiniFlaskParser.ProgramContext flaskParseTree = flaskParser.program();

        if (flaskParser.getNumberOfSyntaxErrors() > 0) {
            log("ABORTED: products.miniflask has a syntax error.");
            writeLog();
            System.err.println("Regeneration aborted - products.miniflask has a syntax error (see above).");
            System.exit(1);
        }
        ProgramNode flaskAst = new MiniFlaskAstBuilder().build(flaskParseTree);
        log("Parsed products.miniflask -> Python AST (" + flaskAst.getStatements().size() + " top-level statements)");

        String jinjaSource = Files.readString(Path.of("samples/index.minijinja"));
        MiniJinjaLexer jinjaLexer = new MiniJinjaLexer(CharStreams.fromString(jinjaSource));
        MiniJinjaParser jinjaParser = new MiniJinjaParser(new CommonTokenStream(jinjaLexer));
        TemplateNode jinjaAst = new MiniJinjaAstBuilder().build(jinjaParser.template());
        log("Parsed index.minijinja -> Jinja AST");

        Files.createDirectories(Path.of("compiler_output"));
        var gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        Files.writeString(Path.of("compiler_output/ast_python.json"), gson.toJson(flaskAst.toJson()));
        String jinjaJson = gson.toJson(jinjaAst.toJson()).replace("\\\\n", "\\n");
        Files.writeString(Path.of("compiler_output/ast_jinja.json"), jinjaJson);
        log("Wrote compiler_output/ast_python.json and ast_jinja.json");

        SemanticAnalyzer analyzer = new SemanticAnalyzer();
        analyzer.analyze(flaskAst, jinjaAst);

        StringBuilder report = new StringBuilder();
        report.append("SEMANTIC ANALYSIS REPORT\n=========================\n\n");
        report.append("SYMBOL TABLE\n").append(analyzer.getSymbolTable().toReportString());
        report.append("\nSEMANTIC ERRORS (").append(analyzer.getErrors().size()).append(" found)\n");
        report.append("-".repeat(40)).append("\n");
        for (SemanticError e : analyzer.getErrors()) report.append(e).append("\n");
        Files.writeString(Path.of("compiler_output/semantic_report.txt"), report.toString());
        log("Wrote compiler_output/semantic_report.txt (" + analyzer.getErrors().size() + " errors found)");

        if (!analyzer.getErrors().isEmpty()) {
            log("ABORTED: semantic errors found, output/ was NOT regenerated.");
            writeLog();
            System.err.println("Regeneration aborted - semantic errors found:");
            for (SemanticError e : analyzer.getErrors()) System.err.println("  " + e);
            System.exit(1);
        }

        Map<String, Object> contextData = new PythonEvaluator().evaluateProgram(flaskAst);
        log("Evaluated Python data: " + contextData.keySet());

        new SiteBuilder().buildSite(contextData, Path.of("output"));
        log("Generated HTML site into output/");

        copyIfExists(Path.of("app.py"), Path.of("output/app.py"));
        copyIfExists(Path.of("style.css"), Path.of("output/style.css"));
        copyIfExists(Path.of("script.js"), Path.of("output/script.js"));
        log("Copied companion files (app.py, style.css, script.js) into output/ unchanged");

        log("Regeneration successful at " + LocalDateTime.now());
        writeLog();
        System.out.println("Regeneration successful.");
        System.exit(0);
    }

    private static void copyIfExists(Path source, Path dest) throws IOException {
        if (Files.exists(source)) {
            Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    private static void log(String message) {
        log.append(message).append("\n");
    }

    private static void writeLog() throws IOException {
        Files.createDirectories(Path.of("compiler_output"));
        Files.writeString(Path.of("compiler_output/generation_log.txt"), log.toString());
    }
}