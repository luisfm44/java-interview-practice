package com.interview.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RotateArrayTest {

  private final RotateArray rotateArray = new RotateArray();

  @Test
  void rotatesArrayToTheRight() {
    int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
    rotateArray.rotate(nums, 3);
    assertArrayEquals(new int[] { 5, 6, 7, 1, 2, 3, 4 }, nums);
  }

  @Test
  void handlesKGreaterThanLength() {
    int[] nums = { -1, -100, 3, 99 };
    rotateArray.rotate(nums, 2);
    assertArrayEquals(new int[] { 3, 99, -1, -100 }, nums);
  }

  @Test
  void imperativeRotatesArrayToTheRight() {
    int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
    rotateArray.rotateImperative(nums, 3);
    assertArrayEquals(new int[] { 5, 6, 7, 1, 2, 3, 4 }, nums);
  }

  @Test
  void imperativeHandlesKGreaterThanLength() {
    int[] nums = { -1, -100, 3, 99 };
    rotateArray.rotateImperative(nums, 2);
    assertArrayEquals(new int[] { 3, 99, -1, -100 }, nums);
  }
}
