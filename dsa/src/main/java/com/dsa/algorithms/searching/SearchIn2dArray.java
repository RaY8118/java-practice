package com.dsa.algorithms.searching;

import java.util.Arrays;

/**
 * This class provides methods to search for a target element within a 2D integer array.
 * It implements a linear search approach for 2D arrays.
 *
 * DSA Topics: Arrays, Searching, Iteration
 */
public class SearchIn2dArray {
    /**
     * Main method to demonstrate the SearchIn2dArray functionality.
     * It initializes a 2D array and searches for a target element, then prints the result.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[][] arr = {
                { 23, 4, 1 },
                { 18, 12, 3, 9 },
                { 78, 99, 34, 56 },
                { 19, 12 }
        };

        int target = 7;
        int[] ans = search(arr, target);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * Searches for a target element in a 2D integer array.
     * It iterates through each element of the array to find a match.
     *
     * @param arr The 2D array to be searched.
     * @param target The element to search for.
     * @return An integer array of size 2, containing the row and column index of the target
     *         if found. Returns {-1, -1} if the target is not found or the array is empty.
     */
    /**
     * Searches for a target element in a 2D integer array.
     * It iterates through each element of the array to find a match.
     * <p>
     * Time Complexity: O(m * n), where m is the number of rows and n is the number of columns (total elements).
     * Space Complexity: O(1)
     *
     * @param arr The 2D array to be searched.
     * @param target The element to search for.
     * @return An integer array of size 2, containing the row and column index of the target
     *         if found. Returns {-1, -1} if the target is not found or the array is empty.
     */
    static int[] search(int[][] arr, int target) {
        if (arr.length == 0) {
            return new int[] { -1, -1 };
        }

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {
                    return new int[] { row, col };
                }
            }
        }
        return new int[] { -1, -1 };
    }
}
