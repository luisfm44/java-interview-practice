package com.interview.arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * LeetCode 349 - Intersection of Two Arrays.
 * Devuelve los valores unicos que aparecen en ambos arreglos.
 *
 * PATRON (imperative): doble bucle + chequeo manual de duplicados.
 * PATRON (functional): HashSet + filter + distinct.
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {4, 10, 5, 20, 15, 4};
        int[] nums2 = {4, 3, 5, 20, 15, 8};
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        System.out.println(Arrays.toString(intersectionOfTwoArrays.intersectionImperative(nums1, nums2)));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        return intersectionImperative(nums1, nums2);
    }

    public int[] intersectionImperative(int[] nums1, int[] nums2) {
        int[] intersection = new int[nums1.length]; // tamano maximo posible
        int resultIndex = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                // valor en ambos arreglos y aun no agregado al resultado
                if (nums1[i] == nums2[j] && !isAlreadyAdded(resultIndex, intersection, nums1[i])) {
                    intersection[resultIndex] = nums1[i];
                    resultIndex++;
                }
            }
        }
        return Arrays.copyOf(intersection, resultIndex); // recorta al tamano real
    }

    private boolean isAlreadyAdded(int resultIndex, int[] intersection, int value) {
        for (int k = 0; k < resultIndex; k++) {
            if (intersection[k] == value) {
                return true;
            }
        }
        return false;
    }

    public int[] intersectionFunctional(int[] nums1, int[] nums2) {
        Set<Integer> nums2Set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums1)
            .filter(nums2Set::contains) // solo valores que existen en nums2
            .distinct() // elimina duplicados preservando orden de nums1
            .toArray();
    }
}
