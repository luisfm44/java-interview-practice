package com.interview.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReverseStringTest {

  private final ReverseString reverseString = new ReverseString();

  @Test
  void reversesEvenLengthArray() {
    char[] input = { 'h', 'e', 'l', 'l', 'o' };
    reverseString.reverseString(input);
    assertArrayEquals(new char[] { 'o', 'l', 'l', 'e', 'h' }, input);
  }

  @Test
  void reversesOddLengthArray() {
    char[] input = { 'H', 'a', 'n', 'n', 'a', 'h' };
    reverseString.reverseString(input);
    assertArrayEquals(new char[] { 'h', 'a', 'n', 'n', 'a', 'H' }, input);
  }
}
