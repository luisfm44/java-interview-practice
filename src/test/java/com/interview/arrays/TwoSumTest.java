package com.interview.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {

  private final TwoSum twoSum = new TwoSum();

  @Test
  void returnsIndicesForClassicExample() {
    assertArrayEquals(new int[] { 0, 1 }, twoSum.twoSum(new int[] { 2, 7, 11, 15 }, 9));
  }

  @Test
  void returnsIndicesWhenSolutionIsNotAdjacent() {
    assertArrayEquals(new int[] { 1, 2 }, twoSum.twoSum(new int[] { 3, 2, 4 }, 6));
  }

  @Test
  void handlesDuplicateValues() {
    assertArrayEquals(new int[] { 0, 1 }, twoSum.twoSum(new int[] { 3, 3 }, 6));
  }
}
