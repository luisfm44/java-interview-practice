package com.interview.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StrStrTest {

  private final StrStr strStr = new StrStr();

  @Test
  void findsNeedleAtBeginning() {
    assertEquals(0, strStr.strStr("sadbutsad", "sad"));
  }

  @Test
  void returnsMinusOneWhenNeedleMissing() {
    assertEquals(-1, strStr.strStr("leetcode", "leeto"));
  }

  @Test
  void findsNeedleInMiddle() {
    assertEquals(2, strStr.strStr("hellohellohello", "llohel"));
  }

  @Test
  void imperativeFindsNeedleAtBeginning() {
    assertEquals(0, strStr.strStrImperative("sadbutsad", "sad"));
  }

  @Test
  void imperativeReturnsMinusOneWhenNeedleMissing() {
    assertEquals(-1, strStr.strStrImperative("leetcode", "leeto"));
  }

  @Test
  void imperativeFindsNeedleInMiddle() {
    assertEquals(2, strStr.strStrImperative("hellohellohello", "llohel"));
  }
}
