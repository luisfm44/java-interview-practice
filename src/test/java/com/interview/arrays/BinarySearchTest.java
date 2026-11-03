package com.interview.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

  @Test
  void functionalFindsTargetsAndRejectsMissingValues() {
    int[] nums = {-1, 0, 3, 5, 9, 12};
    assertEquals(0, binarySearch.searchFunctional(nums, -1));
    assertEquals(4, binarySearch.searchFunctional(nums, 9));
    assertEquals(5, binarySearch.searchFunctional(nums, 12));
    assertEquals(-1, binarySearch.searchFunctional(nums, 2));
    assertEquals(-1, binarySearch.searchFunctional(nums, -2));
    assertEquals(-1, binarySearch.searchFunctional(nums, 13));
  }

  @Test
  void bothVariantsHandleEmptyAndSingleInputs() {
    assertEquals(-1, binarySearch.searchImperative(new int[0], 1));
    assertEquals(-1, binarySearch.searchFunctional(new int[0], 1));
    assertEquals(0, binarySearch.searchImperative(new int[] {1}, 1));
    assertEquals(0, binarySearch.searchFunctional(new int[] {1}, 1));
    assertEquals(-1, binarySearch.searchImperative(new int[] {1}, 2));
    assertEquals(-1, binarySearch.searchFunctional(new int[] {1}, 2));
  }

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

  @Test
  void imperativeFindsExistingTarget() {
    assertEquals(4, binarySearch.searchImperative(new int[] { -1, 0, 3, 5, 9, 12 }, 9));
  }

  @Test
  void imperativeReturnsMinusOneWhenTargetMissing() {
    assertEquals(-1, binarySearch.searchImperative(new int[] { -1, 0, 3, 5, 9, 12 }, 2));
  }

  @Test
  void imperativeFindsTargetAtBoundaries() {
    assertEquals(0, binarySearch.searchImperative(new int[] { 1, 2, 3 }, 1));
    assertEquals(2, binarySearch.searchImperative(new int[] { 1, 2, 3 }, 3));
  }
}
