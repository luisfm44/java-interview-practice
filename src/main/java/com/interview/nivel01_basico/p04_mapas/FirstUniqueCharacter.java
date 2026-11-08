package com.interview.nivel01_basico.p04_mapas;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LeetCode 387 - First Unique Character in a String.
 * Devuelve el indice del primer caracter que no se repite, o -1 si no existe.
 *
 * PATRON: HashMap de frecuencias + segundo recorrido por indice.
 */
public class FirstUniqueCharacter {

    public static void main(String[] args) {
        FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
        System.out.println(firstUniqueCharacter.firstUniqChar("leetcode"));
    }

    public int firstUniqChar(String s) {
        return firstUniqCharImperative(s);
    }

    public int firstUniqCharImperative(String s) {
        Map<Character, Integer> frequencies = new LinkedHashMap<>();
        for (char character : s.toCharArray()) {
            // incrementa cuantas veces aparece cada caracter
            frequencies.put(character, frequencies.getOrDefault(character, 0) + 1);
        }
        for (int index = 0; index < s.length(); index++) {
            if (frequencies.get(s.charAt(index)) == 1) {
                return index; // primer indice cuyo caracter aparece una sola vez
            }
        }
        return -1;
    }

    public int firstUniqCharFunctional(String s) {
        return s.chars()
            .mapToObj(character -> (char) character)
            .distinct()
            .filter(character -> s.indexOf(character) == s.lastIndexOf(character)) // unico = misma primera y ultima posicion
            .mapToInt(s::indexOf)
            .min() // el mas a la izquierda
            .orElse(-1);
    }
}
