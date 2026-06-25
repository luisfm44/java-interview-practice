package com.interview.arrays;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IntersectionOfTwoArraysTest {

  private final IntersectionOfTwoArrays intersection = new IntersectionOfTwoArrays();

  @Test
  void returnsUniqueIntersectionValues() {
    assertArrayEquals(new int[] { 2 }, sorted(intersection.intersection(
        new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 })));
  }

  @Test
  void returnsMultipleUniqueIntersectionValues() {
    assertArrayEquals(new int[] { 4, 9 }, sorted(intersection.intersection(
        new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));
  }

  @Test
  void imperativeReturnsUniqueIntersectionValues() {
    assertArrayEquals(new int[] { 2 }, sorted(intersection.intersectionImperative(
        new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 })));
  }

  @Test
  void imperativeReturnsMultipleUniqueIntersectionValues() {
    assertArrayEquals(new int[] { 4, 9 }, sorted(intersection.intersectionImperative(
        new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));
  }

  private int[] sorted(int[] values) {
    int[] copy = Arrays.copyOf(values, values.length);
    Arrays.sort(copy);
    return copy;
  }
}
