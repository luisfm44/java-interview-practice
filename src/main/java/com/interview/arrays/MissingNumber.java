package com.interview.arrays;

/**
 * LeetCode 268 - Missing Number.
 * Encuentra el numero faltante en el rango 0..n.
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {2,1,5,3,4,6,7,9,10};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        
       return missingNumberImperative(nums);
    }

    public int missingNumberImperative(int[] nums) {
       int[] orderedNums = orderArray(nums);
       
       if (orderedNums[0] != 0) {
            return 0;
        } 
       
        for(int i = 0; i < orderedNums.length -1; i++){
            if(orderedNums[i + 1] - orderedNums[i]  > 1){
                return orderedNums[i] +1;
            }
        }
        
        return orderedNums.length;
    }

    public static int missingNumberFunctional(int[] nums) {
        throw new UnsupportedOperationException("Implementa missingNumberFunctional");
    }

    private int[] orderArray(int[] nums){
        int temp = 0;
        for (int i = 0; i < nums.length-1; i++) {           // pasadas
            for (int j = i + 1; j < nums.length; j++) {   // comparaciones
                if(nums[i]> nums[j]){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}
