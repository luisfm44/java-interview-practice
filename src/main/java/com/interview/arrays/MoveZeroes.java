package com.interview.arrays;

import java.util.Arrays;

/**
 * LeetCode 283 - Move Zeroes.
 * Mueve todos los ceros al final manteniendo el orden relativo de los demas elementos.
 *
 * PATRON: Two Pointers (read / write) + relleno final.
 */
public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {0, 0, 0, 4, 7, 2, 6, 9, 0};
        moveZeroes.moveZeroes(nums);
    }

    public void moveZeroes(int[] nums) {
        moveZeroesImperative(nums);
    }

    public void moveZeroesImperative(int[] nums) {
        int write = 0; // indice donde colocar el proximo elemento distinto de cero
        for (int read = 0; read < nums.length; read++) {
            if (nums[read] != 0) {
                nums[write] = nums[read]; // compactamos los no-ceros al inicio
                write++;
            }
        }
        // lo que queda desde write hasta el final debe ser cero
        while (write < nums.length) {
            nums[write] = 0;
            write++;
        }
    }

    public void moveZeroesFunctional(int[] nums) {
        // filtra no-ceros, los copia al inicio y rellena el resto con ceros
        int[] nonZero = Arrays.stream(nums).filter(value -> value != 0).toArray();
        System.arraycopy(nonZero, 0, nums, 0, nonZero.length);
        Arrays.fill(nums, nonZero.length, nums.length, 0);
    }
}
