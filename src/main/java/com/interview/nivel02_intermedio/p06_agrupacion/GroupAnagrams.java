package com.interview.nivel02_intermedio.p06_agrupacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 49 - Group Anagrams.
 * Agrupa strings que son anagramas entre si.
 *
 * PATRON: HashMap donde la clave es la version ordenada de cada palabra.
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(
            new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        return groupAnagramsImperative(strs);
    }

    public List<List<String>> groupAnagramsImperative(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars); // anagramas comparten la misma clave ordenada
            String key = new String(chars);
            groups.computeIfAbsent(key, ignored -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(groups.values());
    }

    public List<List<String>> groupAnagramsFunctional(String[] strs) {
        return Arrays.stream(strs)
            .collect(java.util.stream.Collectors.groupingBy(word -> {
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                return new String(chars);
            }))
            .values()
            .stream()
            .toList();
    }
}
