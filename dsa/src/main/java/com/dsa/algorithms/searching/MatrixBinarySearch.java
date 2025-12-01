package com.dsa.algorithms.searching;

import java.util.Arrays;

/**
 * This class provides a solution for searching in a row-wise and column-wise
 * sorted matrix.
 */
public class MatrixBinarySearch {
    /**
     * The main method to test the search function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[][] arr = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 28, 29, 37, 49 },
                { 33, 34, 38, 50 }
        };

        System.out.println(Arrays.toString(search(arr, 37)));

        System.out.println(Arrays.toString(search(arr, 49)));

        System.out.println(Arrays.toString(search(arr, 43)));
    }

    /**
     * Searches for a target value in a row-wise and column-wise sorted matrix.
     *
     * @param matrix The sorted matrix to search in.
     * @param target The value to search for.
     * @return An array containing the row and column of the target, or {-1, -1} if
     *         not found.
     */
    /**
     * Searches for a target value in a row-wise and column-wise sorted matrix.
     * <p>
     * Time Complexity: O(m + n), where m is the number of rows and n is the number of columns in the matrix.
     * Space Complexity: O(1)
     *
     * @param matrix The sorted matrix to search in.
     * @param target The value to search for.
     * @return An array containing the row and column of the target, or {-1, -1} if
     *         not found.
     */
    static int[] search(int[][] matrix, int target) {
        int r = 0;
        int c = matrix.length - 1;

        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return new int[] { r, c };
            }
            if (matrix[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return new int[] { -1, -1 };
    }
}
