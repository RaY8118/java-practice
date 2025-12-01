package com.dsa.algorithms.arrays;

/**
 * This class provides a solution to the "Cells with Odd Values in a Matrix"
 * problem on LeetCode.
 * <p>
 * LeetCode problem 1252:
 * https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
 * <p>
 * It counts the number of cells in a matrix that have odd values after
 * performing increment operations.
 */
public class OddCells {

    /**
     * The main method to test the oddCells function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[][] indices = { { 0, 1 }, { 1, 1 } };
        int m = 2;
        int n = 3;
        System.out.println(oddCells(m, n, indices));

        int[][] indices2 = { { 0, 0 }, { 1, 1 } };
        int m2 = 2;
        int n2 = 2;
        System.out.println(oddCells(m2, n2, indices2));
    }

    /**
     * Counts the number of cells with odd values in a matrix after incrementing
     * rows and columns.
     *
     * @param m       The number of rows in the matrix.
     * @param n       The number of columns in the matrix.
     * @param indices A 2D array where each element [ri, ci] specifies a row and
     *                column to increment.
     * @return The number of cells in the resulting matrix that have odd values.
     */
    /**
     * Counts the number of cells with odd values in a matrix after incrementing
     * rows and columns.
     * <p>
     * Time Complexity: O(k * (m + n) + m * n), where k is the number of indices, m is the number of rows, and n is the number of columns.
     * Space Complexity: O(m * n) for the matrix.
     *
     * @param m       The number of rows in the matrix.
     * @param n       The number of columns in the matrix.
     * @param indices A 2D array where each element [ri, ci] specifies a row and
     *                column to increment.
     * @return The number of cells in the resulting matrix that have odd values.
     */
    static int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        for (int[] row : indices) {
            int rowIndex = row[0];
            int colIndex = row[1];

            for (int r = 0; r < m; r++) {
                matrix[r][colIndex] += 1;
            }

            for (int c = 0; c < n; c++) {
                matrix[rowIndex][c] += 1;
            }
        }

        int count = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                if (num % 2 != 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
