package com.interview.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PlusOneTest {

  @Test
  void functionalHandlesNumbersBeyondLongRange() {
    int[] digits = new int[100];
    java.util.Arrays.fill(digits, 9);
    int[] expected = new int[101];
    expected[0] = 1;
    assertArrayEquals(expected, plusOne.plusOneFunctional(digits));
  }

  @Test
  void functionalHandlesZeroAndPartialCarry() {
    assertArrayEquals(new int[] {1}, plusOne.plusOneFunctional(new int[] {0}));
    assertArrayEquals(new int[] {1, 3, 0}, plusOne.plusOneFunctional(new int[] {1, 2, 9}));
  }

  private final PlusOne plusOne = new PlusOne();

  @Test
  void incrementsWithoutCarry() {
    assertArrayEquals(new int[] { 1, 2, 4 }, plusOne.plusOne(new int[] { 1, 2, 3 }));
  }

  @Test
  void incrementsWithCarry() {
    assertArrayEquals(new int[] { 1, 0, 0, 0 }, plusOne.plusOne(new int[] { 9, 9, 9 }));
  }

  @Test
  void imperativeIncrementsWithoutCarry() {
    assertArrayEquals(new int[] { 1, 2, 4 }, plusOne.plusOneImperative(new int[] { 1, 2, 3 }));
  }

  @Test
  void imperativeIncrementsWithCarry() {
    assertArrayEquals(new int[] { 1, 0, 0, 0 }, plusOne.plusOneImperative(new int[] { 9, 9, 9 }));
  }
}
