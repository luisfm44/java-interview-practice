package com.interview.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidPalindromeTest {

  private final ValidPalindrome validPalindrome = new ValidPalindrome();

  @Test
  void acceptsPalindromeWithSpacesAndPunctuation() {
    assertTrue(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
  }

  @Test
  void rejectsNonPalindrome() {
    assertFalse(validPalindrome.isPalindrome("race a car"));
  }

  @Test
  void acceptsEmptyString() {
    assertTrue(validPalindrome.isPalindrome(""));
  }

  @Test
  void imperativeAcceptsPalindromeWithSpacesAndPunctuation() {
    assertTrue(validPalindrome.isPalindromeImperative("A man, a plan, a canal: Panama"));
  }

  @Test
  void imperativeRejectsNonPalindrome() {
    assertFalse(validPalindrome.isPalindromeImperative("race a car"));
  }

  @Test
  void imperativeAcceptsEmptyString() {
    assertTrue(validPalindrome.isPalindromeImperative(""));
  }
}
