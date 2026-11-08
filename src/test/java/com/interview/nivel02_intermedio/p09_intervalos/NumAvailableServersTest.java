package com.interview.nivel02_intermedio.p09_intervalos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumAvailableServersTest {
  @Test
  void reusesServerAcrossGapsAndTouchingIntervals() {
    assertEquals(1, NumAvailableServers.minServers(new int[] {1, 5, 9}, new int[] {2, 6, 10}));
    assertEquals(1, NumAvailableServers.minServers(new int[] {1, 4, 7}, new int[] {4, 7, 10}));
  }

  @Test
  void countsPeakOverlapRatherThanAdjacentPairs() {
    assertEquals(2, NumAvailableServers.minServers(new int[] {1, 2, 3}, new int[] {3, 4, 5}));
    assertEquals(3, NumAvailableServers.minServers(new int[] {1, 1, 2}, new int[] {4, 3, 5}));
  }

  @Test
  void handlesUnsortedNestedIntervalsWithoutMutatingInput() {
    int[] starts = {5, 1, 2};
    int[] ends = {6, 10, 3};
    assertEquals(2, NumAvailableServers.minServers(starts, ends));
    assertArrayEquals(new int[] {5, 1, 2}, starts);
    assertArrayEquals(new int[] {6, 10, 3}, ends);
  }

  @Test
  void handlesEmptyAndSingleInputs() {
    assertEquals(0, NumAvailableServers.minServers(new int[0], new int[0]));
    assertEquals(1, NumAvailableServers.minServers(new int[] {1}, new int[] {2}));
  }

  @Test
  void rejectsMismatchedOrNonPositiveIntervals() {
    assertThrows(IllegalArgumentException.class,
        () -> NumAvailableServers.minServers(new int[] {1}, new int[0]));
    assertThrows(IllegalArgumentException.class,
        () -> NumAvailableServers.minServers(new int[] {2}, new int[] {2}));
    assertThrows(IllegalArgumentException.class,
        () -> NumAvailableServers.minServers(new int[] {3}, new int[] {1}));
  }
}
