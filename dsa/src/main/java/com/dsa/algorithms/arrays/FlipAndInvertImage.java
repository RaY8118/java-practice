package com.dsa.algorithms.arrays;

import java.util.Arrays;

/**
 * This class provides a solution to the "Flipping an Image" problem on
 * LeetCode.
 * <p>
 * LeetCode problem 832: https://leetcode.com/problems/flipping-an-image/
 * <p>
 * It flips a binary image horizontally and then inverts it.
 */
public class FlipAndInvertImage {

    /**
     * The main method to test the flipAndInvertImage function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[][] image = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
        System.out.println(Arrays.deepToString(flipAndInvertImage(image)));
    }

    /**
     * Flips a binary image horizontally and then inverts it.
     * <p>
     * First, each row of the image is reversed. Then, the values are inverted (0
     * becomes 1, and 1 becomes 0).
     *
     * <p>
     * Time Complexity: O(n*m) where n is the number of rows and m is the number of columns.
     * Space Complexity: O(1)
     *
     * @param image The binary image represented as a 2D integer array.
     * @return The transformed 2D integer array.
     */
    static int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            for (int i = 0; i < row.length / 2; i++) {
                int t = row[i];
                row[i] = row[row.length - 1 - i];
                row[row.length - 1 - i] = t;
            }
        }

        for (int[] row : image) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 0) {
                    row[i] = 1;
                } else {
                    row[i] = 0;
                }
            }
        }

        return image;

    }
}
