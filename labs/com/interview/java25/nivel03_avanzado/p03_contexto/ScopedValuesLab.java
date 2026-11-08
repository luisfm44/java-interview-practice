package com.interview.java25.nivel03_avanzado.p03_contexto;

// JEP 506: API definitiva en Java 25. Reto y extensiones: docs/JAVA25_LABS.md.
class ScopedValuesLab {
    private static final ScopedValue<String> REQUEST = ScopedValue.newInstance();

    static String currentRequest() { return REQUEST.get(); }

    void main() throws Exception {
        if (REQUEST.isBound()) throw new AssertionError("Contexto inicial contaminado");
        String result = ScopedValue.where(REQUEST, "outer").call(() -> {
            String nested = ScopedValue.where(REQUEST, "inner").call(ScopedValuesLab::currentRequest);
            if (!nested.equals("inner") || !currentRequest().equals("outer")) {
                throw new AssertionError("El contexto exterior debe restaurarse");
            }
            return currentRequest();
        });
        if (!result.equals("outer") || REQUEST.isBound()) throw new AssertionError("Fuga de contexto");
        try {
            ScopedValue.where(REQUEST, "failing").run(() -> { throw new IllegalStateException("demo"); });
            throw new AssertionError("Se esperaba la excepción de la tarea");
        } catch (IllegalStateException expected) {
            if (REQUEST.isBound()) throw new AssertionError("Fuga después de excepción");
        }
        try {
            currentRequest();
            throw new AssertionError("No debe existir valor fuera del ámbito");
        } catch (java.util.NoSuchElementException expected) { /* contrato */ }
        System.out.println("OK: binding, rebinding y limpieza incluso con excepciones");
    }
}
