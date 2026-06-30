package com.interview.arrays;

/**
 * LeetCode 268 - Missing Number.
 * Encuentra el numero faltante en el rango 0..n.
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {2,1,5,3,4,6,7,9,10};
        orderArray(nums);
    }

    public int missingNumber(int[] nums) {
        
        //primero debemos ordenar la lista
        //despues iteramos la lista y verificamos si hay algún vacío 
        // entre el numero anterior y el que estoy evaluando
        throw new UnsupportedOperationException("Implementa missingNumber");
    }

    public int missingNumberImperative(int[] nums) {
        throw new UnsupportedOperationException("Implementa missingNumberImperative");
    }

    public int missingNumberFunctional(int[] nums) {
        throw new UnsupportedOperationException("Implementa missingNumberFunctional");
    }

    public static int[] orderArray(int[] nums){
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
                if(i !=nums.length){
                    if(nums[i]> nums[i+1]){
                        temp = nums[i];
                        nums[i] = nums[i+1];
                        nums[i+1] = temp;
                    }
                } 
            }
        return nums;
    }
}
