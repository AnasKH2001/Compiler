package com.compiler.app;

import com.compiler.ast.MiniFlaskAstBuilder;
import com.compiler.ast.ProgramNode;
import com.compiler.ast.jinja.MiniJinjaAstBuilder;
import com.compiler.ast.jinja.TemplateNode;
import com.compiler.grammar.MiniFlaskLexer;
import com.compiler.grammar.MiniFlaskParser;
import com.compiler.grammar.MiniJinjaLexer;
import com.compiler.grammar.MiniJinjaParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("########## MINIFLASK ##########\n");
        testMiniFlask();

        System.out.println("\n\n########## MINIJINJA ##########\n");
        testMiniJinja();
    }

    private static void testMiniFlask() throws IOException {
        String sourceText = Files.readString(Path.of("samples/products.miniflask"));

        MiniFlaskLexer lexer = new MiniFlaskLexer(CharStreams.fromString(sourceText));
        MiniFlaskParser parser = new MiniFlaskParser(new CommonTokenStream(lexer));
        MiniFlaskParser.ProgramContext parseTree = parser.program();

        ProgramNode ast = new MiniFlaskAstBuilder().build(parseTree);

        System.out.println("=== MINIFLASK AST ===");
        ast.print();
    }

    private static void testMiniJinja() throws IOException {
        String sourceText = Files.readString(Path.of("samples/products.minijinja"));

        MiniJinjaLexer lexer = new MiniJinjaLexer(CharStreams.fromString(sourceText));
        MiniJinjaParser parser = new MiniJinjaParser(new CommonTokenStream(lexer));
        MiniJinjaParser.TemplateContext parseTree = parser.template();

        TemplateNode ast = new MiniJinjaAstBuilder().build(parseTree);

        System.out.println("=== MINIJINJA AST ===");
        ast.print();
    }
}