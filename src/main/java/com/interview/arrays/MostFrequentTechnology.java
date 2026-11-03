package com.interview.arrays;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Devuelve la tecnologia mas frecuente, distinguiendo mayusculas y minusculas.
 * En empate gana la primera en aparecer; para un arreglo vacio devuelve "".
 */
public class MostFrequentTechnology {
    public static void main(String[] args){
        String[] technologies = {"Ruby","Go","Go","Ruby"};
        System.out.println(findMostFrequent(technologies));
    }

    public static String findMostFrequent(String[] technologies){

        Map<String, Integer> frequencies = new LinkedHashMap<>();

        for(int i = 0; i < technologies.length; i++){
            frequencies.put(
                technologies[i],
                frequencies.getOrDefault(technologies[i], 0) + 1
            );
        }

        return obtainMostFrequent(frequencies);
    }

    private static String obtainMostFrequent(Map<String, Integer> frequencies){
        int maxFrequency = 0;
        String mostFrequent = "";
        for(Map.Entry<String, Integer> entry : frequencies.entrySet()){
            if(entry.getValue() > maxFrequency){
                maxFrequency = entry.getValue();
                mostFrequent = entry.getKey();
            }

        }
        return mostFrequent;
    }
}
