package com.dsa.algorithms.arrays;

// Leetcode 867
// https://leetcode.com/problems/transpose-matrix/
import java.util.Arrays;

/**
 * Solution for Leetcode problem 867: Transpose Matrix.
 * <p>
 * Given a matrix A, return the transpose of A. The transpose of a matrix is
 * the matrix flipped over its main diagonal, switching the row and column
 * indices of the matrix.
 *
 * @see <a href="https://leetcode.com/problems/transpose-matrix/">Leetcode 867</a>
 */
public class Transpose {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(Arrays.deepToString(transpose(matrix)));

        int[][] matrix2 = { { 1, 2, 3 }, { 4, 5, 6 } };
        System.out.println(Arrays.deepToString(transpose(matrix2)));
    }

    /**
     * Transposes the given matrix.
     *
     * Time Complexity: O(R * C), where R is the number of rows and C is the number of columns in the matrix.
     * Space Complexity: O(R * C) to store the transposed matrix.
     *
     * @param matrix The matrix to be transposed.
     * @return The transposed matrix.
     */
    static int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] result = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}
