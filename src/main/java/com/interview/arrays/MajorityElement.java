package com.interview.arrays;

/**
 * LeetCode 169 - Majority Element.
 * Encuentra el elemento que aparece mas de n / 2 veces.
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {4,4,4,4, 4, 8};
        MajorityElement majorityElement = new MajorityElement();
        System.out.println("Imperative ->" + majorityElement.majorityElementImperative(nums));
    }

    public int majorityElement(int[] nums) {
        return majorityElementImperative(nums);
    }

    public int majorityElementImperative(int[] nums) {

        int majorityValue = 0;
        for(int i = 0; i < nums.length; i++){
            majorityValue = 1;
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    majorityValue++;
                }
                if(majorityValue > (nums.length/2)){
                    return nums[i];
                }
            }
        }
        return 0;
        
    }

    public int majorityElementFunctional(int[] nums) {
        throw new UnsupportedOperationException("Implementa majorityElementFunctional");
    }
}
