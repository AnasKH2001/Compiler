package com.compiler.semantic;

/**
 * One declared name in the program: a variable, function, or loop variable.
 * "scope" is either "global" or a function's name (our language only has
 * two levels of scoping: global, and inside one specific function).
 */
public record Symbol(String name, String scope, String type, int line) {}