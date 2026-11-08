package com.interview.nivel03_avanzado.p03_grafos;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Evaluación del reto; activa con -Pretos -Dtest=CourseScheduleTest. */
@Tag("reto")
class CourseScheduleTest {
    private final CourseSchedule challenge = new CourseSchedule();

    @Test void ordersDependenciesAndIncludesIsolatedCoursesWithoutMutation() {
        int[][] edges = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        assertValidOrder(5, edges, challenge.order(5, edges));
        assertArrayEquals(new int[] {1, 0}, edges[0]);
        assertArrayEquals(new int[] {2, 0}, edges[1]);
        assertArrayEquals(new int[] {3, 1}, edges[2]);
        assertArrayEquals(new int[] {3, 2}, edges[3]);
    }

    @Test void detectsCyclesIncludingSelfDependency() {
        assertTrue(challenge.order(2, new int[][] {{0, 1}, {1, 0}}).isEmpty());
        assertTrue(challenge.order(1, new int[][] {{0, 0}}).isEmpty());
        assertTrue(challenge.order(4, new int[][] {{0, 1}, {1, 0}, {3, 2}}).isEmpty());
    }

    @Test void handlesNoEdgesAndNoCourses() {
        assertValidOrder(3, new int[0][], challenge.order(3, new int[0][]));
        assertEquals(java.util.List.of(), challenge.order(0, new int[0][]));
    }

    private void assertValidOrder(int count, int[][] edges, java.util.List<Integer> order) {
        assertEquals(count, order.size());
        assertEquals(count, new java.util.HashSet<>(order).size());
        for (int course = 0; course < count; course++) assertTrue(order.contains(course));
        for (int[] edge : edges) assertTrue(order.indexOf(edge[1]) < order.indexOf(edge[0]));
    }
}
