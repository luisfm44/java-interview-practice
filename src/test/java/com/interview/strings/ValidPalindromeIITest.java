package com.interview.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidPalindromeIITest {

  private final ValidPalindromeII validPalindromeII = new ValidPalindromeII();

  @Test
  void acceptsAlreadyValidPalindrome() {
    assertTrue(validPalindromeII.validPalindrome("aba"));
  }

  @Test
  void acceptsWithOneDeletion() {
    assertTrue(validPalindromeII.validPalindrome("abca"));
  }

  @Test
  void rejectsWhenMoreThanOneDeletionNeeded() {
    assertFalse(validPalindromeII.validPalindrome("abc"));
  }

  @Test
  void imperativeAcceptsAlreadyValidPalindrome() {
    assertTrue(validPalindromeII.validPalindromeImperative("aba"));
  }

  @Test
  void imperativeAcceptsWithOneDeletion() {
    assertTrue(validPalindromeII.validPalindromeImperative("abca"));
  }

  @Test
  void imperativeRejectsWhenMoreThanOneDeletionNeeded() {
    assertFalse(validPalindromeII.validPalindromeImperative("abc"));
  }
}
