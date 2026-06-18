package com.interview.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringWithoutRepeatingTest {

  private final LongestSubstringWithoutRepeating longestSubstring = new LongestSubstringWithoutRepeating();

  @Test
  void findsLongestWithoutRepeats() {
    assertEquals(3, longestSubstring.lengthOfLongestSubstring("abcabcbb"));
  }

  @Test
  void handlesAllSameCharacter() {
    assertEquals(1, longestSubstring.lengthOfLongestSubstring("bbbbb"));
  }

  @Test
  void handlesEmptyString() {
    assertEquals(0, longestSubstring.lengthOfLongestSubstring(""));
  }
}
