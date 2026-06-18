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
    assertEquals(15, strStr.strStr("hellohellohello", "llohel"));
  }
}
