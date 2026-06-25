package com.interview.arrays;

import java.util.stream.IntStream;

/**
 * LeetCode 53 - Maximum Subarray.
 * Encuentra la suma maxima de un subarreglo contiguo.
 */
public class MaxSubarray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Imperative result ->" + maxSubArrayImperative(nums));
        System.out.println("Functional result ->" + maxSubArrayFunctional(nums));
    }

    public int maxSubArray(int[] nums) {
        return maxSubArrayImperative(nums);
    }

    public static int maxSubArrayImperative(int[] nums) {
        
        int maxTotal = nums[0];

        for(int i= 0; i < nums.length; i++){
            int subSum = 0;
            for(int j = i; j < nums.length; j++){
                subSum += nums[j];
                if(subSum > maxTotal){
                    maxTotal = subSum;
                }
            }
        }
        return maxTotal;
    }

    public static int maxSubArrayFunctional(int[] nums) {
        
        return IntStream.range(0, nums.length).flatMap(start -> 
                IntStream.range(start, nums.length).map(end ->  IntStream.rangeClosed(start, end)
                .map(i -> nums[i])
                .sum()))
                .max()
                .orElse(0);
    }
}
