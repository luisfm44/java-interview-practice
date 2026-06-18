package com.interview.strings;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * LeetCode 387 - First Unique Character in a String.
 * Devuelve el índice del primer carácter que no se repite, o -1 si no existe.
 */
public class FirstUniqueCharacter {

    public static void main(String[] args) {
        FirstUniqueCharacter solution = new FirstUniqueCharacter();
        System.out.println(solution.firstUniqChar("leetcode"));       // esperado: 0
        System.out.println(solution.firstUniqChar("loveleetcode")); // esperado: 2
        System.out.println(solution.firstUniqChar("aabb"));           // esperado: -1
    }

    public int firstUniqChar(String s) {
        // TODO: cuenta frecuencias y recorre de nuevo el string
        Map<Integer, Long> frecuencias = s.chars().boxed().collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return IntStream.range(0, s.length())
        .filter(i -> frecuencias.get((int) s.charAt(i)) == 1L)
        .findFirst()
        .orElse(-1);
    }
}
