package com.compiler.semantic;

import java.util.ArrayList;
import java.util.List;

public class SymbolTable {
    private final List<Symbol> symbols = new ArrayList<>();

    public void declare(String name, String scope, String type, int line) {
        symbols.add(new Symbol(name, scope, type, line));
    }

    /** Is this name visible from the given scope? Global names are visible
     *  everywhere; a function-scoped name is only visible inside that same function. */
    public boolean isVisible(String name, String currentScope) {
        for (Symbol s : symbols) {
            if (s.name().equals(name) && (s.scope().equals("global") || s.scope().equals(currentScope))) {
                return true;
            }
        }
        return false;
    }

    /** Is this name declared ANYWHERE at all, regardless of scope?
     *  Used to distinguish "Scope error" (declared, but not here) from
     *  "Undefined variable" (never declared anywhere). */
    public boolean existsAnywhere(String name) {
        for (Symbol s : symbols) {
            if (s.name().equals(name)) return true;
        }
        return false;
    }

    /** Best-effort inferred type of a name, preferring a match in the
     *  current scope over a global one. Returns "unknown" if not found. */
    public String inferredType(String name, String currentScope) {
        for (Symbol s : symbols) {
            if (s.name().equals(name) && s.scope().equals(currentScope)) return s.type();
        }
        for (Symbol s : symbols) {
            if (s.name().equals(name) && s.scope().equals("global")) return s.type();
        }
        return "unknown";
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    /** Requirement 7: print the whole symbol table in a readable format. */
    public void print() {
        System.out.printf("%-20s %-12s %-10s %s%n", "NAME", "SCOPE", "TYPE", "LINE");
        System.out.println("-".repeat(55));
        for (Symbol s : symbols) {
            System.out.printf("%-20s %-12s %-10s %d%n", s.name(), s.scope(), s.type(), s.line());
        }
    }

    public String toReportString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-20s %-12s %-10s %s%n", "NAME", "SCOPE", "TYPE", "LINE"));
        sb.append("-".repeat(55)).append("\n");
        for (Symbol s : symbols) {
            sb.append(String.format("%-20s %-12s %-10s %d%n", s.name(), s.scope(), s.type(), s.line()));
        }
        return sb.toString();
    }
}