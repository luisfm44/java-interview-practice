package com.interview.nivel01_basico.p01_arrays;

import java.util.Arrays;

/**
 * LeetCode 268 - Missing Number.
 * Encuentra el numero faltante en el rango 0..n.
 *
 * PATRON (imperative): ordenar y buscar hueco.
 * PATRON (functional): suma de Gauss (0+1+...+n) menos suma real.
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 3, 4, 6, 7, 9, 10};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        return missingNumberImperative(nums);
    }

    public int missingNumberImperative(int[] nums) {
        int[] orderedNums = orderArray(nums.clone()); // clone para no mutar el arreglo original

        if (orderedNums[0] != 0) {
            return 0; // falta el cero al inicio
        }

        for (int i = 0; i < orderedNums.length - 1; i++) {
            if (orderedNums[i + 1] - orderedNums[i] > 1) {
                return orderedNums[i] + 1; // hay un salto -> ese es el faltante
            }
        }

        return orderedNums.length; // falta n al final (ej: [0,1,2] -> falta 3)
    }

    public static int missingNumberFunctional(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2; // suma de 0..n
        int actualSum = Arrays.stream(nums).sum();
        return expectedSum - actualSum; // la diferencia es el numero que no aparecio
    }

    private int[] orderArray(int[] nums) {
        // bubble sort simple para dejar el arreglo ordenado
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}
