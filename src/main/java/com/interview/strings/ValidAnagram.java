package com.interview.strings;

import java.util.Arrays;

/**
 * LeetCode 242 - Valid Anagram.
 * Determina si dos strings son anagramas.
 *
 * PATRON (imperative): array de frecuencias de 26 letras.
 * PATRON (functional): ordenar ambos strings y comparar.
 */
public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("anagram", "nagaram"));
    }

    public boolean isAnagram(String s, String t) {
        return isAnagramImperative(s, t);
    }

    public boolean isAnagramImperative(String s, String t) {
        if (s.length() != t.length()) {
            return false; // distinta longitud -> no pueden ser anagramas
        }
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++; // suma frecuencia en s
            counts[t.charAt(i) - 'a']--; // resta frecuencia en t
        }
        for (int count : counts) {
            if (count != 0) {
                return false; // algun caracter no cuadra
            }
        }
        return true;
    }

    public boolean isAnagramFunctional(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sortedS = s.toCharArray();
        char[] sortedT = t.toCharArray();
        Arrays.sort(sortedS);
        Arrays.sort(sortedT);
        return Arrays.equals(sortedS, sortedT); // mismas letras en mismo orden -> anagramas
    }
}
