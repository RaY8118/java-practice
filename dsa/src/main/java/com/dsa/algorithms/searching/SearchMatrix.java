package com.dsa.algorithms.searching;

// Leetcode 74
// https://leetcode.com/problems/search-a-2d-matrix/

/**
 * Solution for Leetcode problem 74: Search a 2D Matrix.
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * <ul>
 *     <li>Integers in each row are sorted in ascending order.</li>
 *     <li>The first integer of each row is greater than the last integer of the previous row.</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/search-a-2d-matrix/">Leetcode 74</a>
 */
public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        System.out.println(searchMatrix(matrix, 3));
        System.out.println(searchMatrix(matrix, 13));
    }

    /**
     * Searches for a target value in a 2D matrix.
     * The matrix is sorted in ascending order row-wise and the first integer of each row
     * is greater than the last integer of the previous row.
     *
     * Time Complexity: O(log(M * N)), where M is the number of rows and N is the number of columns.
     * This is because the search space is effectively M * N, and binary search reduces the space by half in each step.
     * Space Complexity: O(1)
     *
     * @param matrix The 2D matrix to search in.
     * @param target The value to search for.
     * @return True if the target is found, false otherwise.
     */
    static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = matrix[mid / n][mid % n];

            if (value == target) {
                return true;
            }
            if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
