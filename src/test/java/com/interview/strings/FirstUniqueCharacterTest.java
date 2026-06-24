package com.interview.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstUniqueCharacterTest {

  private final FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();

  @Test
  void findsFirstUniqueAtBeginning() {
    assertEquals(0, firstUniqueCharacter.firstUniqChar("leetcode"));
  }

  @Test
  void findsFirstUniqueInMiddle() {
    assertEquals(2, firstUniqueCharacter.firstUniqChar("loveleetcode"));
  }

  @Test
  void returnsMinusOneWhenNoUniqueCharacter() {
    assertEquals(-1, firstUniqueCharacter.firstUniqChar("aabb"));
  }

  @Test
  void imperativeFindsFirstUniqueAtBeginning() {
    assertEquals(0, firstUniqueCharacter.firstUniqCharImperative("leetcode"));
  }

  @Test
  void imperativeFindsFirstUniqueInMiddle() {
    assertEquals(2, firstUniqueCharacter.firstUniqCharImperative("loveleetcode"));
  }

  @Test
  void imperativeReturnsMinusOneWhenNoUniqueCharacter() {
    assertEquals(-1, firstUniqueCharacter.firstUniqCharImperative("aabb"));
  }
}
