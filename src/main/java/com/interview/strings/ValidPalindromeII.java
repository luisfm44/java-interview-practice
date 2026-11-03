package com.interview.strings;

/**
 * LeetCode 680 - Valid Palindrome II.
 * Determina si s puede ser palindromo eliminando como maximo un caracter.
 *
 * PATRON: Two Pointers + probar borrar izquierda o derecha al encontrar mismatch.
 */
public class ValidPalindromeII {

    public static void main(String[] args) {
        ValidPalindromeII validPalindromeII = new ValidPalindromeII();
        System.out.println(validPalindromeII.validPalindrome("abca"));
    }

    public boolean validPalindrome(String s) {
        return validPalindromeImperative(s);
    }

    public boolean validPalindromeImperative(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // permitimos borrar UN caracter: probamos saltar left o saltar right
                return isPalindromeRange(s, left + 1, right)
                    || isPalindromeRange(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean validPalindromeFunctional(String s) {
        return isValidWithDeletions(s, 0, s.length() - 1, 0);
    }

    private boolean isPalindromeRange(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isValidWithDeletions(String s, int left, int right, int deletionsUsed) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (deletionsUsed == 1) {
                    return false; // ya usamos la unica eliminacion permitida
                }
                return isValidWithDeletions(s, left + 1, right, 1)
                    || isValidWithDeletions(s, left, right - 1, 1);
            }
            left++;
            right--;
        }
        return true;
    }
}
