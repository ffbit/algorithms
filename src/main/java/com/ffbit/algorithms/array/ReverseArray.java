package com.ffbit.algorithms.array;

/**
 * Reverse an array of ints.
 */
public class ReverseArray {

    public int[] reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            swap(array, i, array.length - 1 - i);
        }

        return array;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
