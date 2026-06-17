package com.interview.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidAnagramTest {

  private final ValidAnagram validAnagram = new ValidAnagram();

  @Test
  void recognizesValidAnagrams() {
    assertTrue(validAnagram.isAnagram("anagram", "nagaram"));
  }

  @Test
  void rejectsDifferentLengths() {
    assertFalse(validAnagram.isAnagram("rat", "car"));
  }

  @Test
  void rejectsSameLengthButDifferentCharacters() {
    assertFalse(validAnagram.isAnagram("hello", "bello"));
  }
}
