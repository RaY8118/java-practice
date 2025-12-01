package com.dsa.algorithms.searching;

/**
 * This class provides a solution to the "sqrt(x)" problem on LeetCode.
 * <p>
 * LeetCode problem 69:
 * https://leetcode.com/problems/sqrtx/
 * <p>
 * It calculates the integer square root of a non-negative integer.
 */
public class MySqrt {
    /**
     * The main method to test the mySqrt function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int x = 2147395599;
        System.out.println(mySqrt(x));
    }

    /**
     * Calculates the integer square root of a non-negative integer.
     *
     * @param x The non-negative integer.
     * @return The integer square root of x.
     */
    /**
     * Calculates the integer square root of a non-negative integer.
     * <p>
     * Time Complexity: O(log x), where x is the input number.
     * Space Complexity: O(1)
     *
     * @param x The non-negative integer.
     * @return The integer square root of x.
     */
    static int mySqrt(int x) {
        int min = 0;
        int max = x;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            long sq = (long) mid * mid;
            if (x == sq) {
                return mid;
            } else if (x < sq) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return max;
    }
}
