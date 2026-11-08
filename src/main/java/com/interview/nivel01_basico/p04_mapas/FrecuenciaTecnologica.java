package com.interview.nivel01_basico.p04_mapas;

import java.util.HashMap;
import java.util.Map;

/** Cuenta apariciones de cada tecnologia, distinguiendo mayusculas y minusculas. */
public class FrecuenciaTecnologica {
    static void main(String[] args){
        String[] technologies = {"Java", "java", "AWS", "Java","Python", "AWS", "Java"};
        System.out.println(calculateFrecuencies(technologies));
    }

    public static Map<String, Integer> calculateFrecuencies(String[] technologies){
        Map<String, Integer> frequencies = new HashMap<>();

        for (String technology : technologies) {
            frequencies.put(
                technology,
                frequencies.getOrDefault(technology, 0) + 1
            );
        }
        return frequencies;
    }
}
