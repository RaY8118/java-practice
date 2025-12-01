package com.dsa.algorithms.searching;

/**
 * This class provides a solution to the "Valid Perfect Square" problem on LeetCode.
 * <p>
 * LeetCode problem 367:
 * https://leetcode.com/problems/valid-perfect-square/
 * <p>
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Follow up: Do not use any built-in library function such as sqrt.
 */
public class IsPerfectSquare {
    /**
     * The main method to test the isPerfectSquare function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int num = 16;
        System.out.println(isPerfectSquare(num));

        int num2 = 14;
        System.out.println(isPerfectSquare(num2));
    }

    /**
     * Checks if a given number is a perfect square.
     *
     * @param num The number to check.
     * @return true if the number is a perfect square, false otherwise.
     */
    /**
     * Checks if a given number is a perfect square.
     * <p>
     * Time Complexity: O(log num), where num is the input number.
     * Space Complexity: O(1)
     *
     * @param num The number to check.
     * @return true if the number is a perfect square, false otherwise.
     */
    static boolean isPerfectSquare(int num) {
        int min = 0;
        int max = num;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            long sq = (long) mid * mid;
            if (num == sq) {
                return true;
            } else if (num < sq) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return min * min == num;

    }
}
