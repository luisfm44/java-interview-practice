package com.interview.arrays;

import java.util.Set;
import java.util.HashSet;


/** Cuenta valores distintos: [4, 2, 4, 7, 2] contiene tres valores distintos. */
public class CountUniqueNumbers {

    public static void main(String args[]){
        int[] numbers = {4, 2, 4, 7, 2};
        System.out.println(countUnique(numbers));
    }


    public static int countUnique(int[] numbers){
        Set<Integer> arregloUnique = new HashSet<>();
        for(int i = 0; i< numbers.length; i++){
            arregloUnique.add(numbers[i]);
        }

        return arregloUnique.size();
    }
}
