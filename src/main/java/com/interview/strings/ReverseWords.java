package com.interview.strings;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * LeetCode 151 - Reverse Words in a String.
 * Invierte el orden de las palabras en un string.
 *
 * PATRON: split por espacios + swap de extremos (two pointers sobre palabras).
 */
public class ReverseWords {

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords("the sky is blue"));
    }

    public String reverseWords(String s) {
        return reverseWordsImperative(s);
    }

    public String reverseWordsImperative(String s) {
        String[] words = s.trim().split("\\s+"); // separa palabras ignorando espacios extra
        int left = 0;
        int right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", words); // reconstruye el string final
    }

    public String reverseWordsFunctional(String s) {
        return Arrays.stream(s.trim().split("\\s+"))
            .collect(Collectors.collectingAndThen(Collectors.toList(), words -> {
                java.util.Collections.reverse(words);
                return String.join(" ", words);
            }));
    }
}
