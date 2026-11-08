package com.interview.java25.nivel03_avanzado.p01_patrones;

// JEP 507: tercera preview en Java 25; requiere --enable-preview --source 25.
class PrimitivePatternsLab {
    String classify(int value) {
        return switch (value) {
            case byte b -> "byte:" + b;
            case short s -> "short:" + s;
            case int i -> "int:" + i;
        };
    }

    boolean exactlyFloat(int value) { return value instanceof float; }

    void main() {
        if (!classify(127).equals("byte:127")) throw new AssertionError("Límite byte");
        if (!classify(128).equals("short:128")) throw new AssertionError("Límite short");
        if (!classify(-129).equals("short:-129")) throw new AssertionError("Negativo");
        if (!classify(32_768).equals("int:32768")) throw new AssertionError("Límite int");
        if (!exactlyFloat(16_777_216) || exactlyFloat(16_777_217)) {
            throw new AssertionError("El patrón exige conversión exacta, no truncamiento");
        }
        System.out.println("OK: patrones primitivos y conversión exacta a float");
    }
}
