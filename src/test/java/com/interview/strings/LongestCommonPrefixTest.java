package com.interview.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonPrefixTest {

  private final LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

  @Test
  void findsSharedPrefix() {
    assertEquals("fl", longestCommonPrefix.longestCommonPrefix(
        new String[] { "flower", "flow", "flight" }));
  }

  @Test
  void returnsEmptyWhenNoCommonPrefix() {
    assertEquals("", longestCommonPrefix.longestCommonPrefix(
        new String[] { "dog", "racecar", "car" }));
  }

  @Test
  void handlesSingleString() {
    assertEquals("hello", longestCommonPrefix.longestCommonPrefix(
        new String[] { "hello" }));
  }

  @Test
  void imperativeFindsSharedPrefix() {
    assertEquals("fl", longestCommonPrefix.longestCommonPrefixImperative(
        new String[] { "flower", "flow", "flight" }));
  }

  @Test
  void imperativeReturnsEmptyWhenNoCommonPrefix() {
    assertEquals("", longestCommonPrefix.longestCommonPrefixImperative(
        new String[] { "dog", "racecar", "car" }));
  }

  @Test
  void imperativeHandlesSingleString() {
    assertEquals("hello", longestCommonPrefix.longestCommonPrefixImperative(
        new String[] { "hello" }));
  }
}
