package com.interview.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LengthOfLastWordTest {

  private final LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

  @Test
  void countsLastWordInSimpleSentence() {
    assertEquals(5, lengthOfLastWord.lengthOfLastWord("Hello World"));
  }

  @Test
  void ignoresTrailingSpaces() {
    assertEquals(4, lengthOfLastWord.lengthOfLastWord("   fly me   to   the moon  "));
  }

  @Test
  void handlesSingleWord() {
    assertEquals(5, lengthOfLastWord.lengthOfLastWord("luffy"));
  }
}
