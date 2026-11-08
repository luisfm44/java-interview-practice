package com.interview.nivel04_experto.p03_heaps;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Evaluación del reto; activa con -Pretos -Dtest=MedianFinderTest. */
@Tag("reto")
class MedianFinderTest {
    @Test void handlesAlternatingSidesDuplicatesAndOverflow() {
        var challenge = new MedianFinder();
        challenge.add(Integer.MAX_VALUE);
        assertEquals((double) Integer.MAX_VALUE, challenge.median());
        challenge.add(Integer.MAX_VALUE);
        assertEquals((double) Integer.MAX_VALUE, challenge.median());
        challenge.add(Integer.MIN_VALUE);
        assertEquals((double) Integer.MAX_VALUE, challenge.median());
        challenge.add(Integer.MIN_VALUE);
        assertEquals(-0.5, challenge.median());
    }

    @Test void matchesSortedOracleAfterEveryInsertion() {
        var challenge = new MedianFinder();
        var values = new java.util.ArrayList<Integer>();
        var random = new java.util.Random(25);
        for (int i = 0; i < 200; i++) {
            int value = random.nextInt();
            challenge.add(value);
            values.add(value);
            values.sort(Integer::compare);
            int middle = values.size() / 2;
            double expected = values.size() % 2 == 1 ? values.get(middle)
                : ((long) values.get(middle - 1) + values.get(middle)) / 2.0;
            assertEquals(expected, challenge.median());
        }
    }

    @Test void rejectsQueriesWithoutData() {
        assertThrows(java.util.NoSuchElementException.class, () -> new MedianFinder().median());
    }
}
