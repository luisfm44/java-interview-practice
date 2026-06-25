package com.interview.arrays;

import java.util.stream.IntStream;

/**
 * LeetCode 704 - Binary Search.
 * Busca target en un arreglo ordenado y devuelve su indice, o -1 si no existe.
 */
public class BinarySearch {

    public static void main(String[] args) {
       
        int[] nums = {4,10,5,20, 15};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println("Imperative ->" + binarySearch.searchImperative(nums, 5));
        System.out.println("Functional ->" + binarySearch.searchFunctional(nums, 20));

    }

    public int search(int[] nums, int target) {
       return searchImperative(nums, target);
    }

    public int searchImperative(int[] nums, int target) {
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }
        
        return -1;
    }

    public int searchFunctional(int[] nums, int target) {
        
        return IntStream.range(0, nums.length)
            .filter(i -> nums[i] == target)
            .findFirst()
            .orElse(-1);
    }
}
