package com.interview.arrays;

import java.util.HashSet;
import java.util.Set;

/** Devuelve el primer valor que se repite al recorrer el arreglo, o -1 si no hay repetidos. */
public class FirstDuplicate{

    public static void main(String[] args){
        int[] numeros = {1,2,3,3,4,5};
        System.out.println(findFirstRepeatedNumber(numeros));
    }

    public static int findFirstRepeatedNumber(int[] numeros){
        Set<Integer> seen = new HashSet<>();

        for(int i = 0; i < numeros.length; i++){
            if(seen.add(numeros[i]) == false){
                return numeros[i];
            }
        }

        return -1;
    }

}
