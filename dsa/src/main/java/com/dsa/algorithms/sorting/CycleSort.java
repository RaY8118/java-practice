package com.dsa.algorithms.sorting;

import java.util.Arrays;

/**
 * This class provides an implementation of the Cycle Sort algorithm.
 * <p>
 * Cycle Sort is an in-place, unstable sorting algorithm that is optimal in terms
 * of the number of writes to memory.
 */
public class CycleSort {

    /**
     * The main method to test the cycleSort function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] arr = { 3, 5, 2, 1, 4 };
        cycleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Sorts an array of integers in ascending order using the Cycle Sort algorithm.
     * <p>
     * This method assumes that the input array contains a permutation of numbers
     * from 1 to arr.length.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param arr The array of integers to be sorted.
     */
    static void cycleSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIdx = arr[i] - 1;
            if (arr[i] != arr[correctIdx]) {
                int temp = arr[i];
                arr[i] = arr[correctIdx];
                arr[correctIdx] = temp;
            } else {
                i++;
            }
        }
    }
}
