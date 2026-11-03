package com.interview.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 3 - Longest Substring Without Repeating Characters.
 * Devuelve la longitud del substring mas largo sin caracteres repetidos.
 *
 * PATRON: Sliding Window (left / right) + HashMap de ultima posicion vista.
 */
public class LongestSubstringWithoutRepeating {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating solution = new LongestSubstringWithoutRepeating();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstringImperative(s);
    }

    public int lengthOfLongestSubstringImperative(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int maxLength = 0;
        int left = 0; // inicio de la ventana actual sin repetidos

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            if (lastSeen.containsKey(current) && lastSeen.get(current) >= left) {
                // el caracter ya esta en la ventana -> movemos left despues de su ultima aparicion
                left = lastSeen.get(current) + 1;
            }
            lastSeen.put(current, right); // actualizamos ultima posicion del caracter
            maxLength = Math.max(maxLength, right - left + 1); // tamano de ventana [left, right]
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringFunctional(String s) {
        return java.util.stream.IntStream.range(0, s.length())
            .mapToObj(end -> {
                java.util.Set<Character> seen = new java.util.HashSet<>();
                int start = end;
                // expandimos hacia atras mientras no haya repetidos
                while (start >= 0 && seen.add(s.charAt(start))) {
                    start--;
                }
                return end - start; // longitud del substring que termina en end
            })
            .mapToInt(Integer::intValue)
            .max()
            .orElse(0);
    }
}
