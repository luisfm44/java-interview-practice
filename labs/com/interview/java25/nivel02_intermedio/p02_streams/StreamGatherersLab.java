package com.interview.java25.nivel02_intermedio.p02_streams;

import java.util.List;
import java.util.stream.Gatherers;

// JEP 485: definitivo desde Java 24, disponible en 25; NO es novedad de 25.
class StreamGatherersLab {
    List<Double> movingAverage(List<Integer> input, int size) {
        if (size <= 0) throw new IllegalArgumentException("Ventana positiva");
        return input.stream().gather(Gatherers.windowSliding(size))
            // windowSliding puede emitir una ventana corta si no alcanza el tamaño.
            .filter(window -> window.size() == size)
            .map(window -> window.stream().mapToDouble(Integer::doubleValue).average().orElseThrow())
            .toList();
    }

    void main() {
        if (!movingAverage(List.of(1, 2, 3, 4), 3).equals(List.of(2.0, 3.0))) {
            throw new AssertionError("Promedios incorrectos");
        }
        if (!movingAverage(List.of(1, 2), 3).isEmpty()) throw new AssertionError("Ventana incompleta");
        if (!movingAverage(List.of(), 2).isEmpty()) throw new AssertionError("Entrada vacía");
        if (!movingAverage(List.of(4), 1).equals(List.of(4.0))) throw new AssertionError("Ventana unitaria");
        try {
            movingAverage(List.of(), 0);
            throw new AssertionError("Debe rechazar tamaño cero");
        } catch (IllegalArgumentException expected) { /* contrato */ }
        System.out.println("OK: ventanas completas con Stream.gather");
    }
}
