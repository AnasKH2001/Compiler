package com.compiler.generator;

/**
 * Represents an attribute-access-that-hasn't-been-called-yet, e.g. the
 * "products.append" part of "products.append({...})", before the "(...)"
 * turns it into an actual call. Only exists as an intermediate value during
 * evaluation - never appears in the final rendered output.
 */
public record BoundMethod(Object receiver, String methodName) {}