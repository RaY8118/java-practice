package com.dsa.algorithms.arrays;

import java.util.Arrays;

/**
 * Implements the Rotate algorithm to rotate an array of integers.
 * This class provides a method for rotating and a main method to demonstrate its usage.
 * Leetcode 189
 * https://leetcode.com/problems/rotate-array/
 */
public class Rotate {
    /**
     * Main method to demonstrate the Rotate algorithm.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        rotate(nums, 3);
    }

    /**
     * Rotates an array of integers using the Rotate algorithm.
     * <p>
     * Time Complexity:
     *   Worst Case: O(n)
     *   Average Case: O(n)
     *   Best Case: O(n)
     * Space Complexity: O(1)
     *
     * @param nums The array of integers to be sorted.
     * @param k The number of steps to rotate the array.
     */
    static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * Reverses the elements of an array within a specified range.
     *
     * @param nums The array to be modified.
     * @param start The starting index of the range to reverse (inclusive).
     * @param end The ending index of the range to reverse (inclusive).
     */
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Rotates an array of integers using a less efficient method.
     * <p>
     * Time Complexity:
     *   Worst Case: O(n*k)
     *   Average Case: O(n*k)
     *   Best Case: O(n*k)
     * Space Complexity: O(1)
     *
     * @param nums The array of integers to be sorted.
     * @param k The number of steps to rotate the array.
     */
    static void rotate2(int[] nums, int k) {
        for (int index = 0; index < k; index++) {
            int last = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = last;

        }

        System.out.println(Arrays.toString(nums));
    }
}
