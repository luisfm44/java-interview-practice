package com.interview.strings;

/**
 * LeetCode 344 - Reverse String.
 * Invierte un arreglo de caracteres in-place.
 *
 * PATRON: Two Pointers (left / right) intercambiando desde los extremos.
 */
public class ReverseString {

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        reverseString.reverseString(chars);
    }

    public void reverseString(char[] s) {
        reverseStringImperative(s);
    }

    public void reverseStringImperative(char[] s) {
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

    public void reverseStringFunctional(char[] s) {
        java.util.stream.IntStream.range(0, s.length / 2).forEach(index -> {
            char temp = s[index];
            s[index] = s[s.length - 1 - index];
            s[s.length - 1 - index] = temp;
        });
    }
}
