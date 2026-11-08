package com.interview.nivel02_intermedio.p01_busqueda;

/**
 * LeetCode 704 - Binary Search.
 * Busca target en un arreglo ordenado y devuelve su indice, o -1 si no existe.
 * Ambas variantes dividen el intervalo de busqueda: tiempo O(log n).
 */
public class BinarySearch {

    static void main(String[] args) {
        int[] nums = {4, 5, 10, 15, 20};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println("Imperative ->" + binarySearch.searchImperative(nums, 5));
        System.out.println("Functional ->" + binarySearch.searchFunctional(nums, 20));
    }

    public int search(int[] nums, int target) {
        return searchImperative(nums, target);
    }

    public int searchImperative(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public int searchFunctional(int[] nums, int target) {
        return searchRecursive(nums, target, 0, nums.length - 1);
    }

    private int searchRecursive(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = left + (right - left) / 2;
        if (nums[middle] == target) {
            return middle;
        }
        return nums[middle] < target
            ? searchRecursive(nums, target, middle + 1, right)
            : searchRecursive(nums, target, left, middle - 1);
    }
}
