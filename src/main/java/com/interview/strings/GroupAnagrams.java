package com.interview.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LeetCode 49 - Group Anagrams.
 * Agrupa strings que son anagramas entre sí.
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();

        List<List<String>> result = solution.groupAnagrams(
            new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });

        System.out.println(result);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        return Arrays.stream(strs)
            .collect(Collectors.collectingAndThen(
                Collectors.groupingBy((String s) -> {
                    char[] text = s.toCharArray();
                    Arrays.sort(text);
                    return new String(text);
                }),
                map -> new ArrayList<>(map.values())));
    }
}
