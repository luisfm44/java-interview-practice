package com.interview.nivel02_intermedio.p02_dospunteros;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseWordsTest {

  private final ReverseWords reverseWords = new ReverseWords();

  @Test
  void reversesWordOrder() {
    assertEquals("blue is sky the", reverseWords.reverseWords("the sky is blue"));
  }

  @Test
  void trimsExtraSpaces() {
    assertEquals("world hello", reverseWords.reverseWords("  hello world  "));
  }

  @Test
  void handlesSingleWord() {
    assertEquals("a", reverseWords.reverseWords("a"));
  }

  @Test
  void imperativeReversesWordOrder() {
    assertEquals("blue is sky the", reverseWords.reverseWordsImperative("the sky is blue"));
  }

  @Test
  void imperativeTrimsExtraSpaces() {
    assertEquals("world hello", reverseWords.reverseWordsImperative("  hello world  "));
  }

  @Test
  void imperativeHandlesSingleWord() {
    assertEquals("a", reverseWords.reverseWordsImperative("a"));
  }
}
