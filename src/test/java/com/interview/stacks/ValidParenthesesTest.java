package com.interview.stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidParenthesesTest {

  private final ValidParentheses validParentheses = new ValidParentheses();

  @Test
  void acceptsBalancedParentheses() {
    assertTrue(validParentheses.isValid("()"));
    assertTrue(validParentheses.isValid("()[]{}"));
    assertTrue(validParentheses.isValid("{[]}"));
  }

  @Test
  void rejectsUnbalancedParentheses() {
    assertFalse(validParentheses.isValid("(]"));
    assertFalse(validParentheses.isValid("([)]"));
    assertFalse(validParentheses.isValid("(("));
  }
}
