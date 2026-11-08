package com.interview.nivel01_basico.p02_strings;

import java.util.Arrays;

/**
 * LeetCode 14 - Longest Common Prefix.
 * Encuentra el prefijo comun mas largo entre un arreglo de strings.
 *
 * PATRON: acortar el prefijo candidato hasta que todas las palabras lo compartan.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(
            new String[] {"flower", "flow", "flight"}));
    }

    public String longestCommonPrefix(String[] strs) {
        return longestCommonPrefixImperative(strs);
    }

    public String longestCommonPrefixImperative(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0]; // empezamos asumiendo que el prefijo es la primera palabra
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1); // recortamos el ultimo caracter
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public String longestCommonPrefixFunctional(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        // reduce compara de a pares y conserva solo el prefijo comun entre ellos
        return Arrays.stream(strs)
            .reduce((first, second) -> {
                int index = 0;
                int limit = Math.min(first.length(), second.length());
                while (index < limit && first.charAt(index) == second.charAt(index)) {
                    index++;
                }
                return first.substring(0, index);
            })
            .orElse("");
    }
}
