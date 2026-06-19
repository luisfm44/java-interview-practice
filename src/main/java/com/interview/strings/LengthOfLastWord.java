package com.interview.strings;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * LeetCode 58 - Length of Last Word.
 * Devuelve la longitud de la última palabra en un string.
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        Deque<String> words = new ArrayDeque<>(Arrays.asList(s.trim().split("\\s+")));
        return words.getLast().length();
    }
}
