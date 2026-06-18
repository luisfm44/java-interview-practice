package com.interview.strings;

import java.util.Arrays;

/**
 * LeetCode 242 - Valid Anagram.
 * Determina si dos strings son anagramas.
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        // TODO: compara frecuencias de caracteres
        char[] sChar = s.toLowerCase().toCharArray();
        char[] tChar = t.toLowerCase().toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return Arrays.equals(sChar, tChar);
    }
}
