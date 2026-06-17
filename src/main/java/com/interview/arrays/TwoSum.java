package com.interview.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1 - Two Sum (ejemplo resuelto).
 * Dado un arreglo y un target, devuelve los índices de dos números que sumen target.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[] { seen.get(complement), i };
            }
            seen.put(nums[i], i);
        }

        throw new IllegalArgumentException("No hay solución para el target dado");
    }
}
