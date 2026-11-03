package com.interview.arrays;

import java.util.stream.IntStream;

/**
 * LeetCode 88 - Merge Sorted Array.
 * Combina nums2 dentro de nums1 manteniendo el orden ascendente.
 *
 * PATRON: Merge desde el final (evita sobrescribir datos de nums1 que aun no procesaste).
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 5, 8, 0, 0, 0, 0, 0};
        int[] nums2 = {1, 3, 6, 7, 9};
        int m = 5;
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.mergeImperative(nums1, m, nums2, nums2.length);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        mergeImperative(nums1, m, nums2, n);
    }

    public void mergeImperative(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // ultimo elemento real de nums1
        int j = n - 1; // ultimo elemento de nums2
        int k = m + n - 1; // posicion de escritura (al final del arreglo)

        while (j >= 0) { // mientras queden elementos por insertar desde nums2
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i]; // el mayor va al final
                i--;
            } else {
                nums1[k] = nums2[j]; // nums2[j] es mayor o nums1 ya se agoto
                j--;
            }
            k--; // avanzamos la posicion de escritura hacia la izquierda
        }
        // si j llega a -1, los elementos restantes de nums1 ya estan en su lugar
    }

    public void mergeFunctional(int[] nums1, int m, int[] nums2, int n) {
        // une ambos segmentos, ordena y copia de vuelta (mas simple, O(n log n))
        int[] merged = IntStream.concat(
                IntStream.range(0, m).map(index -> nums1[index]),
                IntStream.range(0, n).map(index -> nums2[index]))
            .sorted()
            .toArray();
        System.arraycopy(merged, 0, nums1, 0, merged.length);
    }
}
