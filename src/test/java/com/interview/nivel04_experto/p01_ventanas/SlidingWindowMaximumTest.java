package com.interview.nivel04_experto.p01_ventanas;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Evaluación del reto; activa con -Pretos -Dtest=SlidingWindowMaximumTest. */
@Tag("reto")
class SlidingWindowMaximumTest {
    private final SlidingWindowMaximum challenge = new SlidingWindowMaximum();

    @Test void handlesMixedValuesWithoutMutation() {
        int[] values = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] original = values.clone();
        assertArrayEquals(new int[] {3, 3, 5, 5, 6, 7}, challenge.maxSlidingWindow(values, 3));
        assertArrayEquals(original, values);
    }

    @Test void handlesBoundariesDuplicatesAndDescendingValues() {
        assertArrayEquals(new int[] {4, 3, 2}, challenge.maxSlidingWindow(new int[] {4, 3, 2}, 1));
        assertArrayEquals(new int[] {4}, challenge.maxSlidingWindow(new int[] {4, 3, 2}, 3));
        assertArrayEquals(new int[] {4, 3}, challenge.maxSlidingWindow(new int[] {4, 3, 2}, 2));
        assertArrayEquals(new int[] {2, 2}, challenge.maxSlidingWindow(new int[] {2, 2, 2}, 2));
        assertArrayEquals(new int[] {-1, -2}, challenge.maxSlidingWindow(new int[] {-1, -2, -3}, 2));
        assertArrayEquals(new int[] {Integer.MAX_VALUE},
            challenge.maxSlidingWindow(new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE}, 2));
    }

    @Test void rejectsInvalidWindowSizes() {
        assertThrows(IllegalArgumentException.class, () -> challenge.maxSlidingWindow(new int[] {1}, 0));
        assertThrows(IllegalArgumentException.class, () -> challenge.maxSlidingWindow(new int[] {1}, 2));
        assertThrows(IllegalArgumentException.class, () -> challenge.maxSlidingWindow(new int[] {1}, -1));
    }
}
