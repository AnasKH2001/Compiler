package com.compiler.app;

import com.compiler.ast.MiniFlaskAstBuilder;
import com.compiler.ast.ProgramNode;
import com.compiler.grammar.MiniFlaskLexer;
import com.compiler.grammar.MiniFlaskParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Path sourcePath = Path.of("samples/products.miniflask");
        String sourceText = Files.readString(sourcePath);

        System.out.println("=== SOURCE ===");
        System.out.println(sourceText);

        MiniFlaskLexer lexer = new MiniFlaskLexer(CharStreams.fromString(sourceText));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniFlaskParser parser = new MiniFlaskParser(tokens);

        MiniFlaskParser.ProgramContext parseTree = parser.program();

        MiniFlaskAstBuilder builder = new MiniFlaskAstBuilder();
        ProgramNode ast = builder.build(parseTree);

        System.out.println("\n=== OUR AST ===");
        ast.print();
    }
}