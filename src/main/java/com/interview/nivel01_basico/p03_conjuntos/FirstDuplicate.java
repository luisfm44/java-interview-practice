package com.interview.nivel01_basico.p03_conjuntos;

import java.util.HashSet;
import java.util.Set;

/** Devuelve el primer valor que se repite al recorrer el arreglo, o -1 si no hay repetidos. */
public class FirstDuplicate{

    static void main(String[] args){
        int[] numeros = {1,2,3,3,4,5};
        System.out.println(findFirstRepeatedNumber(numeros));
    }

    public static int findFirstRepeatedNumber(int[] numeros){
        Set<Integer> seen = new HashSet<>();

        for(int numero : numeros){
            if(!seen.add(numero)){
                return numero;
            }
        }

        return -1;
    }

}
