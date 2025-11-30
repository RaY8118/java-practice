package com.dsa.algorithms.sorting;

import java.util.Arrays;

/**
 * This class provides an implementation of the Insertion Sort algorithm.
 * <p>
 * Insertion Sort is a simple sorting algorithm that builds the final sorted
 * array one item at a time. It is much less efficient on large lists than more
 * advanced algorithms such as quicksort, heapsort, or merge sort.
 */
public class InsertionSort {

    /**
     * The main method to test the insertionSort function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] arr = { 4, 5, 1, 2, 3 };
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Sorts an array of integers in ascending order using the Insertion Sort
     * algorithm.
     * <p>
     * Time Complexity:
     *   Worst Case: O(n^2)
     *   Average Case: O(n^2)
     *   Best Case: O(n)
     * Space Complexity: O(1)
     *
     * @param arr The array of integers to be sorted.
     */
    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

}
