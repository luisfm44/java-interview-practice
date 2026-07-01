package com.interview.arrays;

import java.util.Arrays;

/**
 * LeetCode 66 - Plus One.
 * Suma uno a un numero representado como arreglo de digitos.
 */
public class PlusOne {

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] digits = {1,1,2,4};
        System.out.println(Arrays.toString(plusOne.plusOne(digits)));
    }

    public int[] plusOne(int[] digits) {
        return plusOneImperative(digits);
    }

    public int[] plusOneImperative(int[] digits) {
        String append = "";
        for(int i = 0; i < digits.length; i++){
            append = append + digits[i];
        }
        Long value = Long.parseLong(append);
        value = value + 1;
        String[] parts = String.valueOf(value).split("(?=.)");
        int[] result =  new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            result[i] = Integer.parseInt(parts[i]);
        }

        return result;

    }

    public int[] plusOneFunctional(int[] digits) {
        throw new UnsupportedOperationException("Implementa plusOneFunctional");
    }
}
