package com.interview.nivel01_basico.p03_conjuntos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CountUniqueNumbersTest {
  @Test
  void countsDistinctValuesRatherThanSingleOccurrences() {
    assertEquals(3, CountUniqueNumbers.countUnique(new int[] {4, 2, 4, 7, 2}));
    assertEquals(1, CountUniqueNumbers.countUnique(new int[] {5, 5, 5}));
  }

  @Test
  void handlesEmptyAndNegativeValues() {
    assertEquals(0, CountUniqueNumbers.countUnique(new int[0]));
    assertEquals(3, CountUniqueNumbers.countUnique(new int[] {-2, 0, -2, 4}));
  }
}
