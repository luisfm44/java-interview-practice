package com.interview.nivel03_avanzado.p03_grafos;

/**
 * R05 · Avanzado · Dijkstra sobre un grafo dirigido.
 * Objetivo con PriorityQueue y descarte de entradas obsoletas: O((V + E) log(V + E)).
 * Con decrease-key se puede alcanzar O((V + E) log V).
 * Cada arista es [origen, destino, peso]. Pesos int >= 0, índices válidos,
 * vertexCount > 0, source válido. Se permiten aristas paralelas y bucles.
 * Devuelve distancias long; usa Long.MAX_VALUE para vértices inalcanzables.
 * No modifiques edges. Evita overflow al sumar pesos grandes.
 */
public class ShortestPaths {
    public long[] distances(int vertexCount, int[][] edges, int source) {
        throw new UnsupportedOperationException("TODO R05: implementar Dijkstra");
    }
}
