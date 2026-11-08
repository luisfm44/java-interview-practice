package com.interview.nivel02_intermedio.p02_dospunteros;

/**
 * LeetCode 26 - Remove Duplicates from Sorted Array.
 * Elimina duplicados in-place en un arreglo ordenado y devuelve la nueva longitud.
 *
 * PATRON: Two Pointers (read / write).
 * - read recorre todo el arreglo.
 * - write marca donde escribir el siguiente valor unico.
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1, 2, 2, 2, 2, 3, 4, 6};
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        return removeDuplicatesImperative(nums);
    }

    public int removeDuplicatesImperative(int[] nums) {
        if (nums.length == 0) {
            return 0; // arreglo vacio -> longitud valida es 0
        }
        int write = 1; // nums[0] siempre se conserva; el primer hueco libre es indice 1
        for (int read = 1; read < nums.length; read++) {
            // Como el arreglo esta ordenado, basta comparar con el ultimo valor guardado
            if (nums[read] != nums[write - 1]) {
                nums[write] = nums[read]; // encontramos un valor nuevo -> lo escribimos adelante
                write++; // la zona valida crece en una posicion
            }
            // si es duplicado, read avanza pero write no (lo "saltamos")
        }
        return write; // cantidad de elementos unicos al inicio del arreglo
    }

    public int removeDuplicatesFunctional(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // int[] de un elemento permite mutar write dentro del lambda (streams no admiten int mutable)
        int[] write = {1};
        java.util.stream.IntStream.range(1, nums.length).forEach(read -> {
            if (nums[read] != nums[write[0] - 1]) {
                nums[write[0]] = nums[read];
                write[0]++;
            }
        });
        return write[0];
    }
}
