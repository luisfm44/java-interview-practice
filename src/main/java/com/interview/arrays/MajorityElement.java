package com.interview.arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * LeetCode 169 - Majority Element.
 * Encuentra el elemento que aparece mas de n / 2 veces.
 *
 * PATRON (imperative): Boyer-Moore Voting (cancelar pares distintos).
 * PATRON (functional): agrupar y contar con Collectors.
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 4, 4, 8};
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElementImperative(nums));
    }

    public int majorityElement(int[] nums) {
        return majorityElementImperative(nums);
    }

    public int majorityElementImperative(int[] nums) {
        int candidate = nums[0]; // candidato a ser el mayoritario
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++; // refuerza al candidato actual
            } else {
                count--; // cancela un voto del candidato
                if (count == 0) {
                    candidate = nums[i]; // cambia candidato cuando se anulan votos
                    count = 1;
                }
            }
        }
        return candidate; // el mayoritario (> n/2) siempre sobrevive
    }

    public int majorityElementFunctional(int[] nums) {
        return Arrays.stream(nums)
            .boxed()
            .collect(Collectors.groupingBy(value -> value, Collectors.counting()))
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue() > nums.length / 2)
            .map(Map.Entry::getKey)
            .findFirst()
            .orElse(0);
    }
}
