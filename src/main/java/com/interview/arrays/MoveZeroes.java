package com.interview.arrays;

import java.util.Arrays;

/**
 * LeetCode 283 - Move Zeroes.
 * Mueve todos los ceros al final manteniendo el orden relativo de los demas elementos.
 */
public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {0,0,0,4,7,2,6,9,0};
        moveZeroes.moveZeroes(nums);
    }
    
    public void moveZeroes(int[] nums) {
        moveZeroesImperative(nums);
    }

    public void moveZeroesImperative(int[] nums) {
        
        int write = 0;
        for (int read = 0; read < nums.length; read++) {
            if (nums[read] != 0) {
                nums[write] = nums[read];
                write++;
            }
        }
        while (write < nums.length) {
            nums[write] = 0;
            write++;
        }
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroesFunctional(int[] nums) {
        throw new UnsupportedOperationException("Implementa moveZeroesFunctional");
    }
}
