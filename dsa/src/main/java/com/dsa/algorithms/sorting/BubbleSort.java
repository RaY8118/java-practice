package com.dsa.algorithms.sorting;

import java.util.Arrays;

/**
 * Implements the Bubble Sort algorithm to sort an array of integers.
 * This class provides a method for sorting and a main method to demonstrate its usage.
 */
public class BubbleSort {
    /**
     * Main method to demonstrate the Bubble Sort algorithm.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] arr = { 3, 1, 5, 4, 2 };
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Sorts an array of integers using the Bubble Sort algorithm.
     * The algorithm repeatedly steps through the list, compares adjacent elements
     * and swaps them if they are in the wrong order.
     * <p>
     * Time Complexity:
     *   Worst Case: O(n^2)
     *   Average Case: O(n^2)
     *   Best Case: O(n)
     * Space Complexity: O(1)
     *
     * @param arr The array of integers to be sorted.
     */
    static void bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
