package com.interview.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MissingNumberTest {

  private final MissingNumber missingNumber = new MissingNumber();

  @Test
  void findsMissingNumberInMiddle() {
    assertEquals(2, missingNumber.missingNumber(new int[] { 3, 0, 1 }));
  }

  @Test
  void findsMissingNumberAtEnd() {
    assertEquals(8, missingNumber.missingNumber(new int[] { 0, 1, 2, 3, 4, 5, 6, 7 }));
  }

  @Test
  void imperativeFindsMissingNumberInMiddle() {
    assertEquals(2, missingNumber.missingNumberImperative(new int[] { 3, 0, 1 }));
  }

  @Test
  void imperativeFindsMissingNumberAtEnd() {
    assertEquals(8, missingNumber.missingNumberImperative(new int[] { 0, 1, 2, 3, 4, 5, 6, 7 }));
  }
}
