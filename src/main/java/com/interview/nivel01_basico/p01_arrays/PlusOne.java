package com.interview.nivel01_basico.p01_arrays;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * LeetCode 66 - Plus One.
 * Suma uno a un numero representado como arreglo de digitos.
 *
 * PATRON: Simulacion con acarreo (carry), recorriendo de derecha a izquierda.
 */
public class PlusOne {

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] digits = {1, 1, 2, 4};
        System.out.println(Arrays.toString(plusOne.plusOne(digits)));
    }

    public int[] plusOne(int[] digits) {
        return plusOneImperative(digits);
    }

    public int[] plusOneImperative(int[] digits) {
        // empezamos por el digito menos significativo (final del arreglo)
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++; // no hay overflow -> sumamos y terminamos
                return digits;
            }
            digits[i] = 0; // era 9 -> pasa a 0 y el acarreo continua a la izquierda
        }
        // caso [9,9,9]: necesitamos un digito extra al inicio
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public int[] plusOneFunctional(int[] digits) {
        // BigInteger permite trabajar con cualquier cantidad de digitos.
        BigInteger value = new BigInteger(
                Arrays.stream(digits).mapToObj(String::valueOf).collect(Collectors.joining()))
            .add(BigInteger.ONE);
        return value.toString().chars().map(character -> character - '0').toArray();
    }
}
