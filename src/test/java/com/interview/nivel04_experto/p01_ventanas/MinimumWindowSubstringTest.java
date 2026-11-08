package com.interview.nivel04_experto.p01_ventanas;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Evaluación del reto; activa con -Pretos -Dtest=MinimumWindowSubstringTest. */
@Tag("reto")
class MinimumWindowSubstringTest {
    private final MinimumWindowSubstring challenge = new MinimumWindowSubstring();

    @Test void findsMinimumAndCountsRepeatedCharacters() {
        assertEquals("BANC", challenge.minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("AAB", challenge.minWindow("AAAB", "AAB"));
        assertEquals("aa", challenge.minWindow("aa", "aa"));
    }

    @Test void handlesMissingEmptyAndTiedWindows() {
        assertEquals("", challenge.minWindow("a", "aa"));
        assertEquals("", challenge.minWindow("", "a"));
        assertEquals("", challenge.minWindow("abc", ""));
        assertEquals("ab", challenge.minWindow("abxba", "ab"));
        assertEquals("aA", challenge.minWindow("aAb", "Aa"));
    }
}
