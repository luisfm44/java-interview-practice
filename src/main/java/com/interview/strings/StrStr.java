package com.interview.strings;

/**
 * LeetCode 28 - Find the Index of the First Occurrence in a String.
 * Devuelve el indice de la primera aparicion de needle en haystack, o -1.
 *
 * PATRON: ventana deslizante del tamano de needle + startsWith.
 */
public class StrStr {

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr("sadbutsad", "sad"));
    }

    public int strStr(String haystack, String needle) {
        return strStrImperative(haystack, needle);
    }

    public int strStrImperative(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.startsWith(needle, i)) {
                return i; // primera posicion donde needle coincide
            }
        }
        return -1;
    }

    public int strStrFunctional(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        return java.util.stream.IntStream.rangeClosed(0, haystack.length() - needle.length())
            .filter(index -> haystack.startsWith(needle, index))
            .findFirst()
            .orElse(-1);
    }
}
