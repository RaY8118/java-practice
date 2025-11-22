package com.dsa.algorithms.arrays;

import java.util.Arrays;

// Leetcode 1920
// https://leetcode.com/problems/build-array-from-permutation/
/**
 * Implements the "Build Array from Permutation" algorithm.
 * This class provides a solution to LeetCode problem 1920:
 * <a href="https://leetcode.com/problems/build-array-from-permutation/">Build
 * Array from Permutation</a>
 *
 * The problem asks to build an array `ans` of the same length as `nums`
 * where `ans[i] = nums[nums[i]]` for each `0 <= i < nums.length`.
 *
 */
public class BuildArray {
    /**
     * Main method to test the buildArray function.
     * It demonstrates the functionality with example inputs.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] nums = { 0, 2, 1, 5, 3, 4 };
        System.out.println(Arrays.toString(buildArray(nums)));
        int[] nums2 = { 5, 0, 1, 2, 3, 4 };
        System.out.println(Arrays.toString(buildArray(nums2)));

    }

    /**
     * Builds an array `ans` from a given 0-indexed permutation `nums`.
     * The array `ans` is constructed such that `ans[i] = nums[nums[i]]` for each
     * `i`.
     *
     * @param nums The 0-indexed permutation array.
     * @return The array `ans` built according to the problem description.
     */
    static int[] buildArray(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = nums[nums[i]];
        }

        return ans;
    }
}
