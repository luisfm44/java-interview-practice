package com.interview.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MoveZeroesTest {

  private final MoveZeroes moveZeroes = new MoveZeroes();

  @Test
  void movesZeroesToEnd() {
    int[] input = { 0, 1, 0, 3, 12 };
    moveZeroes.moveZeroes(input);
    assertArrayEquals(new int[] { 1, 3, 12, 0, 0 }, input);
  }

  @Test
  void handlesArrayWithoutZeroes() {
    int[] input = { 1, 2, 3 };
    moveZeroes.moveZeroes(input);
    assertArrayEquals(new int[] { 1, 2, 3 }, input);
  }

  @Test
  void imperativeMovesZeroesToEnd() {
    int[] input = { 0, 1, 0, 3, 12 };
    moveZeroes.moveZeroesImperative(input);
    assertArrayEquals(new int[] { 1, 3, 12, 0, 0 }, input);
  }

  @Test
  void imperativeHandlesArrayWithoutZeroes() {
    int[] input = { 1, 2, 3 };
    moveZeroes.moveZeroesImperative(input);
    assertArrayEquals(new int[] { 1, 2, 3 }, input);
  }
}
