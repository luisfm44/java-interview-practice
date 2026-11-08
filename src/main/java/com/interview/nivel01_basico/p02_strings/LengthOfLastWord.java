package com.interview.nivel01_basico.p02_strings;

/**
 * LeetCode 58 - Length of Last Word.
 * Devuelve la longitud de la ultima palabra en un string.
 *
 * PATRON: recorrer desde el final saltando espacios y contando caracteres.
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord("Hello World"));
    }

    public int lengthOfLastWord(String s) {
        return lengthOfLastWordImperative(s);
    }

    public int lengthOfLastWordImperative(String s) {
        int index = s.length() - 1;
        while (index >= 0 && s.charAt(index) == ' ') {
            index--; // salta espacios finales
        }
        int length = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            length++; // cuenta caracteres de la ultima palabra
            index--;
        }
        return length;
    }

    public int lengthOfLastWordFunctional(String s) {
        String trimmed = s.trim();
        int lastSpace = trimmed.lastIndexOf(' ');
        return lastSpace == -1 ? trimmed.length() : trimmed.length() - lastSpace - 1;
    }
}
