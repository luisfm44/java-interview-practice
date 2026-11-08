package com.interview.nivel02_intermedio.p09_intervalos;

import java.util.Arrays;

/**
 * Calcula los servidores necesarios para atender intervalos [start, end).
 * Un servidor puede reutilizarse cuando un trabajo termina al iniciar otro.
 * Tiempo O(n log n), espacio O(n); conserva los arreglos originales.
 */
public class NumAvailableServers {

    public static void main(String[] args) {
        int[] start = {1, 4, 7};
        int[] end = {4, 7, 10};
        System.out.println(minServers(start, end));
    }

    public static int minServers(int[] start, int[] end) {
        if (start.length != end.length) {
            throw new IllegalArgumentException("Los arreglos deben tener la misma longitud");
        }
        for (int i = 0; i < start.length; i++) {
            if (start[i] >= end[i]) {
                throw new IllegalArgumentException("Cada intervalo debe tener duracion positiva");
            }
        }

        int[] starts = start.clone();
        int[] ends = end.clone();
        Arrays.sort(starts);
        Arrays.sort(ends);

        int endIndex = 0;
        int active = 0;
        int maximum = 0;
        for (int nextStart : starts) {
            while (endIndex < ends.length && ends[endIndex] <= nextStart) {
                active--;
                endIndex++;
            }
            active++;
            maximum = Math.max(maximum, active);
        }
        return maximum;
    }
}
