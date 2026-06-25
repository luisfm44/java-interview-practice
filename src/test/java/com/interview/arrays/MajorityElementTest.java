package com.interview.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MajorityElementTest {

  private final MajorityElement majorityElement = new MajorityElement();

  @Test
  void findsMajorityInShortArray() {
    assertEquals(3, majorityElement.majorityElement(new int[] { 3, 2, 3 }));
  }

  @Test
  void findsMajorityInLongerArray() {
    assertEquals(2, majorityElement.majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
  }

  @Test
  void imperativeFindsMajorityInShortArray() {
    assertEquals(3, majorityElement.majorityElementImperative(new int[] { 3, 2, 3 }));
  }

  @Test
  void imperativeFindsMajorityInLongerArray() {
    assertEquals(2, majorityElement.majorityElementImperative(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
  }
}
