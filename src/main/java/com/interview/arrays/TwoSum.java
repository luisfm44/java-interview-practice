package com.interview.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * LeetCode 1 - Two Sum.
 * Dado un arreglo y un target, devuelve los indices de dos numeros que sumen target.
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2,7,7,2,7,9};
        System.out.println("Imperative result ->" + Arrays.toString(twoSum.twoSumImperative(nums, 9)));
        System.out.println("Imperative result ->" + Arrays.toString(twoSum.twoSumFunctional(nums, 9)));
    }

    public int[] twoSum(int[] nums, int target) {
        return twoSumImperative(nums, target);
    }

    public int[] twoSumImperative(int[] nums, int target) {

        
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if((nums[i] + nums[j]) == target ){
                    return new int[] { i, j };
                }
            }
            
        }
        throw new IllegalArgumentException("No hay solución para el target dado");
    }

    public int[] twoSumFunctional(int[] nums, int target) {
        
        return IntStream.range(0, nums.length)
            .boxed()
            .flatMap(i -> IntStream.range(i+1, nums.length)
            .mapToObj(j -> new int[] { i, j }))
            .filter(pair -> nums[pair[0]] + nums[pair[1]] == target)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("No hay solución para el target dado"));
    }
}
