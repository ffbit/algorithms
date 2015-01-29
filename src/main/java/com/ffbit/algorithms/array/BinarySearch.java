package com.ffbit.algorithms.array;

/**
 * Just binary search.
 */
public class BinarySearch {

    public int binarySearch(int[] numbers, int needle) {
        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (numbers[middle] == needle) {
                return middle;
            } else if (numbers[middle] < needle) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return -low - 1;
    }

}
