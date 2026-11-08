package com.interview.nivel02_intermedio.p02_dospunteros;

/**
 * LeetCode 392 - Is Subsequence.
 * Determina si s es subsecuencia de t (mismo orden, no necesariamente consecutivo).
 *
 * PATRON: Two Pointers — avanzar en t solo cuando hay match con s.
 */
public class IsSubsequence {

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("abc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        return isSubsequenceImperative(s, t);
    }

    public boolean isSubsequenceImperative(String s, String t) {
        int sIndex = 0; // cuantos caracteres de s ya emparejamos
        for (int tIndex = 0; tIndex < t.length() && sIndex < s.length(); tIndex++) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++; // encontramos el siguiente caracter de s en t
            }
        }
        return sIndex == s.length(); // true si consumimos todo s
    }

    public boolean isSubsequenceFunctional(String s, String t) {
        int[] sIndex = {0};
        t.chars().forEach(character -> {
            if (sIndex[0] < s.length() && s.charAt(sIndex[0]) == (char) character) {
                sIndex[0]++;
            }
        });
        return sIndex[0] == s.length();
    }
}
