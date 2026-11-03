package com.interview.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstDuplicateTest {
  @Test
  void respectsEncounterOrderAndPreservesInput() {
    int[] nums = {4, 2, 4, 2};
    assertEquals(4, FirstDuplicate.findFirstRepeatedNumber(nums));
    assertArrayEquals(new int[] {4, 2, 4, 2}, nums);
  }

  @Test
  void returnsMinusOneWhenNoDuplicateExists() {
    assertEquals(-1, FirstDuplicate.findFirstRepeatedNumber(new int[] {3, 2, 1}));
    assertEquals(-1, FirstDuplicate.findFirstRepeatedNumber(new int[0]));
  }

  @Test
  void handlesZeroAndNegativeDuplicates() {
    assertEquals(0, FirstDuplicate.findFirstRepeatedNumber(new int[] {0, 0}));
    assertEquals(-2, FirstDuplicate.findFirstRepeatedNumber(new int[] {-2, 3, -2}));
  }
}
