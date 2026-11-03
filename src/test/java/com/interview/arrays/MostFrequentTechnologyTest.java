package com.interview.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MostFrequentTechnologyTest {
  @Test
  void findsMostFrequentAndDistinguishesCase() {
    assertEquals("Java", MostFrequentTechnology.findMostFrequent(new String[] {"java", "AWS", "Java", "Java"}));
  }

  @Test
  void breaksFinalFrequencyTiesByFirstAppearance() {
    assertEquals("Ruby", MostFrequentTechnology.findMostFrequent(new String[] {"Ruby", "Go", "Go", "Ruby"}));
  }

  @Test
  void handlesEmptyAndSingleInputs() {
    assertEquals("", MostFrequentTechnology.findMostFrequent(new String[0]));
    assertEquals("Java", MostFrequentTechnology.findMostFrequent(new String[] {"Java"}));
  }
}
