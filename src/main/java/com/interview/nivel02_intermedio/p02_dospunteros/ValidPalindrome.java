package com.interview.nivel02_intermedio.p02_dospunteros;

/**
 * LeetCode 125 - Valid Palindrome.
 * Determina si un string es palindromo ignorando mayusculas y caracteres no alfanumericos.
 *
 * PATRON: Two Pointers (left / right) saltando caracteres invalidos.
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        return isPalindromeImperative(s);
    }

    public boolean isPalindromeImperative(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // avanza left hasta encontrar letra o digito
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // retrocede right hasta encontrar letra o digito
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindromeFunctional(String s) {
        String normalized = s.chars()
            .filter(Character::isLetterOrDigit)
            .mapToObj(character -> String.valueOf(Character.toLowerCase((char) character)))
            .collect(java.util.stream.Collectors.joining());
        return normalized.contentEquals(new StringBuilder(normalized).reverse());
    }
}
