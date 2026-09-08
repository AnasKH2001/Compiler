package com.compiler.app;

import com.compiler.ast.MiniFlaskAstBuilder;
import com.compiler.ast.ProgramNode;
import com.compiler.ast.jinja.MiniJinjaAstBuilder;
import com.compiler.ast.jinja.TemplateNode;
import com.compiler.grammar.MiniFlaskLexer;
import com.compiler.grammar.MiniFlaskParser;
import com.compiler.grammar.MiniJinjaLexer;
import com.compiler.grammar.MiniJinjaParser;
import com.compiler.semantic.SemanticAnalyzer;
import com.compiler.semantic.SemanticError;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Console-only demo/test harness - shows off the AST printing, symbol
 * table, and semantic error detection on both the clean sample and the
 * deliberately-broken demo files. Touches no files on disk.
 *
 * For the REAL compiler pipeline (the one Flask actually calls to
 * regenerate the live site), see RegenerateMain.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("########## CLEAN SAMPLE (expect 0 errors) ##########\n");
        runDemo("samples/products.miniflask", "samples/index.minijinja");

        System.out.println("\n\n########## ERROR DEMO (expect 5 errors, one per category) ##########\n");
        runDemo("samples/errors_demo.miniflask", "samples/errors_demo.minijinja");
    }

    private static void runDemo(String flaskPath, String jinjaPath) throws IOException {
        String flaskSource = Files.readString(Path.of(flaskPath));
        MiniFlaskLexer flaskLexer = new MiniFlaskLexer(CharStreams.fromString(flaskSource));
        MiniFlaskParser flaskParser = new MiniFlaskParser(new CommonTokenStream(flaskLexer));
        ProgramNode flaskAst = new MiniFlaskAstBuilder().build(flaskParser.program());

        String jinjaSource = Files.readString(Path.of(jinjaPath));
        MiniJinjaLexer jinjaLexer = new MiniJinjaLexer(CharStreams.fromString(jinjaSource));
        MiniJinjaParser jinjaParser = new MiniJinjaParser(new CommonTokenStream(jinjaLexer));
        TemplateNode jinjaAst = new MiniJinjaAstBuilder().build(jinjaParser.template());

        System.out.println("=== MINIFLASK AST ===");
        flaskAst.print();

        System.out.println("\n=== MINIJINJA AST ===");
        jinjaAst.print();

        SemanticAnalyzer analyzer = new SemanticAnalyzer();
        analyzer.analyze(flaskAst, jinjaAst);

        System.out.println("\n=== SYMBOL TABLE ===");
        analyzer.getSymbolTable().print();

        System.out.println("\n=== SEMANTIC ERRORS (" + analyzer.getErrors().size() + " found) ===");
        for (SemanticError e : analyzer.getErrors()) {
            System.out.println(e);
        }
    }
}