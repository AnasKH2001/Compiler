package com.compiler.semantic;

/**
 * One detected semantic error. errorType is always one of the 5 categories
 * required by the official clarification:
 *   "Undefined variable", "Type error", "Scope error", "Type mismatch",
 *   "Missing flask variable"
 */
public record SemanticError(String errorType, String message, int line) {
    @Override
    public String toString() {
        return "[" + errorType + "] line " + line + ": " + message;
    }
}