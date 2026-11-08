package com.interview.nivel03_avanzado.p03_grafos;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Evaluación del reto; activa con -Pretos -Dtest=ShortestPathsTest. */
@Tag("reto")
class ShortestPathsTest {
    private final ShortestPaths challenge = new ShortestPaths();

    @Test void findsIndirectPathsAndUnreachableVertices() {
        int[][] edges = {{0, 1, 10}, {0, 2, 2}, {2, 1, 3}, {1, 3, 1}, {2, 3, 20}};
        int[][] original = java.util.Arrays.stream(edges).map(int[]::clone).toArray(int[][]::new);
        assertArrayEquals(new long[] {0, 5, 2, 6, Long.MAX_VALUE}, challenge.distances(5, edges, 0));
        for (int i = 0; i < edges.length; i++) assertArrayEquals(original[i], edges[i]);
    }

    @Test void supportsZeroWeightsParallelEdgesAndDirectedPaths() {
        int[][] edges = {{0, 1, 9}, {0, 1, 0}, {1, 1, 0}, {1, 2, 2}, {2, 0, 8}};
        assertArrayEquals(new long[] {0, 0, 2}, challenge.distances(3, edges, 0));
        assertArrayEquals(new long[] {8, 8, 0}, challenge.distances(3, edges, 2));
        assertArrayEquals(new long[] {Long.MAX_VALUE, 0}, challenge.distances(2, new int[][] {{0, 1, 1}}, 1));
    }

    @Test void avoidsIntOverflowAndHandlesSingleVertex() {
        assertArrayEquals(new long[] {0, Integer.MAX_VALUE, 2L * Integer.MAX_VALUE},
            challenge.distances(3, new int[][] {{0, 1, Integer.MAX_VALUE}, {1, 2, Integer.MAX_VALUE}}, 0));
        assertArrayEquals(new long[] {0}, challenge.distances(1, new int[0][], 0));
    }
}
