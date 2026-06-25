package com.interview.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PlusOneTest {

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
