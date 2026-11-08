package com.interview.java25.nivel01_basico.p02_modulos;

// JEP 511: importación de paquetes exportados por java.base, definitiva en Java 25.
import module java.base;

class ModuleImportsLab {
    void main() {
        // List, Map, BigDecimal y Collectors sin imports de cada paquete.
        List<String> words = List.of("java", "jdk", "java");
        Map<String, Long> counts = words.stream()
            .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        if (!counts.equals(Map.of("java", 2L, "jdk", 1L))) throw new AssertionError(counts);
        var sum = new BigDecimal("0.10").add(new BigDecimal("0.20"));
        if (sum.compareTo(new BigDecimal("0.30")) != 0) throw new AssertionError(sum);
        System.out.println("OK: tipos de java.util, java.util.stream y java.math disponibles");
    }
}
