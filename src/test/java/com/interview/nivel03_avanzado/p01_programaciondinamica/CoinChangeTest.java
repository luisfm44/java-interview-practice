package com.interview.nivel03_avanzado.p01_programaciondinamica;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Evaluación del reto; activa con -Pretos -Dtest=CoinChangeTest. */
@Tag("reto")
class CoinChangeTest {
    private final CoinChange challenge = new CoinChange();

    @Test void findsOptimumWhenGreedyWouldFailWithoutMutatingInput() {
        int[] coins = {4, 1, 3};
        assertEquals(2, challenge.minimumCoins(coins, 6));
        assertArrayEquals(new int[] {4, 1, 3}, coins);
        assertEquals(3, challenge.minimumCoins(new int[] {1, 2, 5}, 11));
        assertEquals(2, challenge.minimumCoins(new int[] {2, 2, 3}, 4));
    }

    @Test void handlesImpossibleAndZeroAmounts() {
        assertEquals(-1, challenge.minimumCoins(new int[] {2}, 3));
        assertEquals(-1, challenge.minimumCoins(new int[0], 7));
        assertEquals(0, challenge.minimumCoins(new int[0], 0));
        assertEquals(0, challenge.minimumCoins(new int[] {1}, 0));
    }

    @Test void rejectsInvalidInputsEvenWhenAmountIsZero() {
        assertThrows(IllegalArgumentException.class, () -> challenge.minimumCoins(new int[] {1}, -1));
        assertThrows(IllegalArgumentException.class, () -> challenge.minimumCoins(new int[] {0, 1}, 0));
        assertThrows(IllegalArgumentException.class, () -> challenge.minimumCoins(new int[] {-2, 1}, 5));
    }
}
