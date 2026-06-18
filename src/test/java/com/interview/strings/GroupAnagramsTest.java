package com.interview.strings;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupAnagramsTest {

  private final GroupAnagrams groupAnagrams = new GroupAnagrams();

  @Test
  void groupsAnagramsTogether() {
    List<List<String>> result = groupAnagrams.groupAnagrams(
        new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });

    assertEquals(
        List.of(
            List.of("ate", "eat", "tea"),
            List.of("bat"),
            List.of("nat", "tan")),
        normalize(result));
  }

  @Test
  void handlesSingleString() {
    List<List<String>> result = groupAnagrams.groupAnagrams(new String[] { "a" });

    assertEquals(List.of(List.of("a")), normalize(result));
  }

  @Test
  void handlesEmptyStrings() {
    List<List<String>> result = groupAnagrams.groupAnagrams(new String[] { "", "" });

    assertEquals(List.of(List.of("", "")), normalize(result));
  }

  private List<List<String>> normalize(List<List<String>> groups) {
    List<List<String>> normalized = new ArrayList<>();
    for (List<String> group : groups) {
      List<String> sortedGroup = new ArrayList<>(group);
      sortedGroup.sort(Comparator.naturalOrder());
      normalized.add(sortedGroup);
    }
    normalized.sort(Comparator.comparing(group -> group.get(0)));
    return normalized;
  }
}
