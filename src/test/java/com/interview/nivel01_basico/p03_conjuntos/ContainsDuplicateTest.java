package com.interview.nivel01_basico.p03_conjuntos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContainsDuplicateTest {

  @Test
  void functionalDetectsDuplicatesAndHandlesEmptyInput() {
    assertTrue(containsDuplicate.containsDuplicateFunctional(new int[] {1, 2, 3, 1}));
    assertFalse(containsDuplicate.containsDuplicateFunctional(new int[] {1, 2, 3, 4}));
    assertFalse(containsDuplicate.containsDuplicateFunctional(new int[0]));
  }

  private final ContainsDuplicate containsDuplicate = new ContainsDuplicate();

  @Test
  void detectsDuplicateValues() {
    assertTrue(containsDuplicate.containsDuplicate(new int[] { 1, 2, 3, 1 }));
  }

  @Test
  void returnsFalseWhenAllValuesAreUnique() {
    assertFalse(containsDuplicate.containsDuplicate(new int[] { 1, 2, 3, 4 }));
  }

  @Test
  void imperativeDetectsDuplicateValues() {
    assertTrue(containsDuplicate.containsDuplicateImperative(new int[] { 1, 2, 3, 1 }));
  }

  @Test
  void imperativeReturnsFalseWhenAllValuesAreUnique() {
    assertFalse(containsDuplicate.containsDuplicateImperative(new int[] { 1, 2, 3, 4 }));
  }
}
