package com.interview.arrays;

/**
 * LeetCode 189 - Rotate Array.
 * Rota el arreglo k posiciones hacia la derecha in-place.
 *
 * PATRON (imperative): triple reversa.
 * reverse(todo) -> reverse(primeros k) -> reverse(resto) = rotacion a la derecha.
 */
public class RotateArray {

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotateArray.rotate(nums, 3);
    }

    public void rotate(int[] nums, int k) {
        rotateImperative(nums, k);
    }

    public void rotateImperative(int[] nums, int k) {
        k = k % nums.length; // k=10 en arreglo de 4 equivale a k=2
        reverse(nums, 0, nums.length - 1); // invierte todo el arreglo
        reverse(nums, 0, k - 1); // deja en orden los k elementos que van al inicio
        reverse(nums, k, nums.length - 1); // ordena el segmento restante
    }

    public void rotateFunctional(int[] nums, int k) {
        int normalizedK = k % nums.length;
        int[] rotated = new int[nums.length];
        // cada elemento en index termina en (index + k) % length
        java.util.stream.IntStream.range(0, nums.length)
            .forEach(index -> rotated[(index + normalizedK) % nums.length] = nums[index]);
        System.arraycopy(rotated, 0, nums, 0, nums.length);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
