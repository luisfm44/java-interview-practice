package com.interview.arrays;

import java.util.Arrays;

/**
 * LeetCode 217 - Contains Duplicate.
 * Determina si un arreglo contiene algun valor repetido.
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {4,10,5,20, 15, 4};
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        System.out.println("Imperative ->" + containsDuplicate.containsDuplicateImperative(nums));
        System.out.println("Functional ->" + containsDuplicate.containsDuplicateImperative(nums));
    }

    public boolean containsDuplicate(int[] nums) {
       return containsDuplicateImperative(nums);
    }

    public boolean containsDuplicateImperative(int[] nums) {
        
        
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsDuplicateFunctional(int[] nums) {

        return Arrays.stream(nums)
        .distinct()
        .count() != nums.length;
    }
}
