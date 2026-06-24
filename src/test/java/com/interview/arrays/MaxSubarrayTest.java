package com.interview.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSubarrayTest {

  private final MaxSubarray maxSubarray = new MaxSubarray();

  @Test
  void findsMaximumContiguousSum() {
    assertEquals(6, maxSubarray.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
  }

  @Test
  void handlesSingleElement() {
    assertEquals(5, maxSubarray.maxSubArray(new int[] { 5 }));
  }

  @Test
  void handlesAllNegativeNumbers() {
    assertEquals(-1, maxSubarray.maxSubArray(new int[] { -3, -1, -2 }));
  }

  @Test
  void imperativeFindsMaximumContiguousSum() {
    assertEquals(6, maxSubarray.maxSubArrayImperative(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
  }

  @Test
  void imperativeHandlesSingleElement() {
    assertEquals(5, maxSubarray.maxSubArrayImperative(new int[] { 5 }));
  }

  @Test
  void imperativeHandlesAllNegativeNumbers() {
    assertEquals(-1, maxSubarray.maxSubArrayImperative(new int[] { -3, -1, -2 }));
  }
}
