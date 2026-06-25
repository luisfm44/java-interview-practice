package com.interview.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortedArrayTest {

  private final MergeSortedArray mergeSortedArray = new MergeSortedArray();

  @Test
  void mergesTwoSortedArrays() {
    int[] nums1 = { 1, 2, 3, 0, 0, 0 };
    mergeSortedArray.merge(nums1, 3, new int[] { 2, 5, 6 }, 3);
    assertArrayEquals(new int[] { 1, 2, 2, 3, 5, 6 }, nums1);
  }

  @Test
  void handlesEmptySecondArray() {
    int[] nums1 = { 1 };
    mergeSortedArray.merge(nums1, 1, new int[] {}, 0);
    assertArrayEquals(new int[] { 1 }, nums1);
  }

  @Test
  void imperativeMergesTwoSortedArrays() {
    int[] nums1 = { 1, 2, 3, 0, 0, 0 };
    mergeSortedArray.mergeImperative(nums1, 3, new int[] { 2, 5, 6 }, 3);
    assertArrayEquals(new int[] { 1, 2, 2, 3, 5, 6 }, nums1);
  }

  @Test
  void imperativeHandlesEmptySecondArray() {
    int[] nums1 = { 1 };
    mergeSortedArray.mergeImperative(nums1, 1, new int[] {}, 0);
    assertArrayEquals(new int[] { 1 }, nums1);
  }
}
