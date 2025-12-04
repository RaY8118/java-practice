package com.dsa.algorithms.arrays;

import java.util.Arrays;

/**
 * Solution for Leetcode 66: Plus One.
 * Given a large integer represented as an integer array where each digits[i] is the i-th digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading zero's, except for the number 0 itself.
 * Increment the large integer by one and return the resulting array of digits.
 *
 * Problem Link: <a href="https://leetcode.com/problems/plus-one/">Leetcode 66 - Plus One</a>
 */
public class PlusOne {
    /**
     * Main method to demonstrate the Plus One algorithm.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] digits = { 1, 2, 3 };
        System.out.println(Arrays.toString(plusOne(digits)));

        int[] digits2 = { 9, 9, 9 };
        System.out.println(Arrays.toString(plusOne(digits2)));
    }

    /**
     * Increments a large integer represented as an array of digits by one.
     * The digits are ordered from most significant to least significant.
     * <p>
     * Time Complexity: O(N), where N is the number of digits in the input array.
     * In the worst case (e.g., [9, 9, 9]), the entire array is traversed and a new array might be created.
     * Space Complexity: O(1) in the best case (no new array created), and O(N) in the worst case (a new array of size N+1 is created).
     *
     * @param digits The array of integers representing the large integer.
     * @return The array of digits representing the incremented large integer.
     */
    static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }

        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
