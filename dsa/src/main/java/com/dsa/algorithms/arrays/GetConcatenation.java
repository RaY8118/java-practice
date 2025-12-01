package com.dsa.algorithms.arrays;

import java.util.Arrays;

// Leetcode 1929
// https://leetcode.com/problems/concatenation-of-array/
/**
 * Implements the "Concatenation of Array" algorithm.
 * This class provides a solution to LeetCode problem 1929:
 * <a href="https://leetcode.com/problems/concatenation-of-array/">Concatenation
 * of Array</a>
 *
 * The problem asks to build an array `ans` of length `2 * n`
 * where `ans[i] == nums[i]` and `ans[i + n] == nums[i]` for `0 <= i < n`
 * (0-indexed).
 *
 */
public class GetConcatenation {
    /**
     * Main method to test the getConcatenation function.
     * It demonstrates the functionality with example inputs.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int nums[] = { 1, 2, 1 };
        System.out.println(Arrays.toString(getConcatenation(nums)));

        int nums2[] = { 1, 3, 2, 1 };
        System.out.println(Arrays.toString(getConcatenation(nums2)));
    }

    /**
     * Builds an array `ans` by concatenating the given array `nums` with itself.
     * The resulting array `ans` will have a length of `2 * nums.length`.
     *
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums The input integer array.
     * @return The concatenated array `ans`.
     */
    static int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] ans = new int[2 * len];

        for (int i = 0; i < len; i++) {
            ans[i] = nums[i];
            ans[i + len] = nums[i];
        }

        return ans;
    }
}
