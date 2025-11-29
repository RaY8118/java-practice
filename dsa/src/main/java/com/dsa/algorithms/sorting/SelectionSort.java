package com.dsa.algorithms.sorting;

import java.util.Arrays;

/**
 * Implements the Selection Sort algorithm to sort an array of integers.
 * This class provides methods for sorting, swapping elements, and finding the maximum element's index.
 */
public class SelectionSort {
    /**
     * Main method to demonstrate the Selection Sort algorithm.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] arr = { 3, 1, 5, 4, 2 };
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Sorts an array of integers using the Selection Sort algorithm.
     * In each iteration, the largest element is selected from the unsorted part
     * of the array and moved to its correct position at the end of the sorted part.
     * <p>
     * Time Complexity:
     *   Worst Case: O(n^2)
     *   Average Case: O(n^2)
     *   Best Case: O(n^2)
     * Space Complexity: O(1)
     *
     * @param arr The array of integers to be sorted.
     */
    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr, maxIndex, last);
        }
    }

    /**
     * Swaps two elements in an array.
     *
     * @param arr    The array in which elements are to be swapped.
     * @param first  The index of the first element.
     * @param second The index of the second element.
     */
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    /**
     * Finds the index of the maximum element in a specified range of an array.
     *
     * @param arr   The array to search within.
     * @param start The starting index of the range (inclusive).
     * @param end   The ending index of the range (inclusive).
     * @return The index of the maximum element in the specified range.
     */
    static int getMaxIndex(int[] arr, int start, int end) {
        int max = start;

        for (int i = start; i <= end; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }
}
