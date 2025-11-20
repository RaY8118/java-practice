package com.dsa.algorithms.searching;

/**
 * This class provides a method to search for a target element within a
 * specified
 * range
 * in an integer array.
 */
public class SearchInRange {

    /**
     * Searches for a target element within a specified range [start, end] in the
     * given array.
     *
     * @param arr    The array to be searched.
     * @param target The element to search for.
     * @param start  The starting index of the search range (inclusive).
     * @param end    The ending index of the search range (inclusive).
     * @return The index of the target element if found within the range, otherwise
     *         -1.
     */
    static int search(int[] arr, int target, int start, int end) {
        if (arr.length == 0) {
            return -1;
        }

        for (int i = start; i <= end; i++) {
            int element = arr[i];
            if (element == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Main method to demonstrate the SearchInRange functionality.
     * It searches for a target element in a sample array within a defined range.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] arr = { 18, 12, -7, 3, 14, 28 };
        int target = 3;
        System.out.println(search(arr, target, 1, 4));
        System.out.println(search(arr, 11, 0, 4));
    }
}
