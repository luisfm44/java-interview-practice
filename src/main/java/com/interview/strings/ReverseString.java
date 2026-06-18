package com.interview.strings;

/**
 * LeetCode 344 - Reverse String.
 * Invierte un arreglo de caracteres in-place.
 */
public class ReverseString {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
