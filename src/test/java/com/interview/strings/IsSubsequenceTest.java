package com.interview.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsSubsequenceTest {

  private final IsSubsequence isSubsequence = new IsSubsequence();

  @Test
  void recognizesValidSubsequence() {
    assertTrue(isSubsequence.isSubsequence("abc", "ahbgdc"));
  }

  @Test
  void rejectsInvalidSubsequence() {
    assertFalse(isSubsequence.isSubsequence("axc", "ahbgdc"));
  }

  @Test
  void acceptsEmptySubsequence() {
    assertTrue(isSubsequence.isSubsequence("", "ahbgdc"));
  }

  @Test
  void imperativeRecognizesValidSubsequence() {
    assertTrue(isSubsequence.isSubsequenceImperative("abc", "ahbgdc"));
  }

  @Test
  void imperativeRejectsInvalidSubsequence() {
    assertFalse(isSubsequence.isSubsequenceImperative("axc", "ahbgdc"));
  }

  @Test
  void imperativeAcceptsEmptySubsequence() {
    assertTrue(isSubsequence.isSubsequenceImperative("", "ahbgdc"));
  }
}
