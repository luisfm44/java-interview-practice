package com.interview.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesFromSortedArrayTest {

  private final RemoveDuplicatesFromSortedArray removeDuplicates = new RemoveDuplicatesFromSortedArray();

  @Test
  void removesDuplicatesAndReturnsNewLength() {
    int[] input = { 1, 1, 2 };
    int length = removeDuplicates.removeDuplicates(input);
    assertEquals(2, length);
    assertArrayEquals(new int[] { 1, 2 }, java.util.Arrays.copyOf(input, length));
  }

  @Test
  void handlesMultipleDuplicates() {
    int[] input = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
    int length = removeDuplicates.removeDuplicates(input);
    assertEquals(5, length);
    assertArrayEquals(new int[] { 0, 1, 2, 3, 4 }, java.util.Arrays.copyOf(input, length));
  }

  @Test
  void imperativeRemovesDuplicatesAndReturnsNewLength() {
    int[] input = { 1, 1, 2 };
    int length = removeDuplicates.removeDuplicatesImperative(input);
    assertEquals(2, length);
    assertArrayEquals(new int[] { 1, 2 }, java.util.Arrays.copyOf(input, length));
  }

  @Test
  void imperativeHandlesMultipleDuplicates() {
    int[] input = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
    int length = removeDuplicates.removeDuplicatesImperative(input);
    assertEquals(5, length);
    assertArrayEquals(new int[] { 0, 1, 2, 3, 4 }, java.util.Arrays.copyOf(input, length));
  }
}
