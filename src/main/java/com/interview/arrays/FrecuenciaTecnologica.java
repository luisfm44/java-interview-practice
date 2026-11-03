package com.interview.arrays;

import java.util.HashMap;
import java.util.Map;

/** Cuenta apariciones de cada tecnologia, distinguiendo mayusculas y minusculas. */
public class FrecuenciaTecnologica {
    public static void main(String[] args){
        String[] technologies = {"Java", "java", "AWS", "Java","Python", "AWS", "Java"};
        System.out.println(calculateFrecuencies(technologies));
    }

    public static Map<String, Integer> calculateFrecuencies(String[] technologies){
        Map<String, Integer> frequencies = new HashMap<>();

        for (int i = 0; i < technologies.length; i++) {
            frequencies.put(
                technologies[i],
                frequencies.getOrDefault(technologies[i], 0) + 1
            );
        }
        return frequencies;
    }
}
