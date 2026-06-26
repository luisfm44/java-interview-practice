package com.interview.arrays;

import java.util.Arrays;

/**
 * LeetCode 88 - Merge Sorted Array.
 * Combina nums2 dentro de nums1 manteniendo el orden ascendente.
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        
        int[] nums1 = {1, 2, 3, 5, 8, 0,0,0,0,0};
        int[] nums2 = {1, 3, 6, 7, 9};
        int m = 5;
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.mergeImperative(nums1, m ,nums2, nums2.length);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        mergeImperative(nums1, m, nums2, n);
    }

    public void mergeImperative(int[] nums1, int m, int[] nums2, int n) {
        
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while(j>=0){
            if(i >= 0 && nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        System.out.println(Arrays.toString(nums1));
    }

    public void mergeFunctional(int[] nums1, int m, int[] nums2, int n) {
        throw new UnsupportedOperationException("Implementa mergeFunctional");
    }
}
