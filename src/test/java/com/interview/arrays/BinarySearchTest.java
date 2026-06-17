package com.interview.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

  private final BinarySearch binarySearch = new BinarySearch();

  @Test
  void findsExistingTarget() {
    assertEquals(4, binarySearch.search(new int[] { -1, 0, 3, 5, 9, 12 }, 9));
  }

  @Test
  void returnsMinusOneWhenTargetMissing() {
    assertEquals(-1, binarySearch.search(new int[] { -1, 0, 3, 5, 9, 12 }, 2));
  }

  @Test
  void findsTargetAtBoundaries() {
    assertEquals(0, binarySearch.search(new int[] { 1, 2, 3 }, 1));
    assertEquals(2, binarySearch.search(new int[] { 1, 2, 3 }, 3));
  }
}
