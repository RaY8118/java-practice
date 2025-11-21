package com.dsa.algorithms.arrays;

import java.util.Arrays;

// Leetcode 1480
// https://leetcode.com/problems/running-sum-of-1d-array/description/

/**
 * This class calculates the running sum of a 1D array.
 * For an input array `nums`, the running sum is an array `runningSum` where
 * `runningSum[i] = sum(nums[0]…nums[i])`.
 */
public class RunningSum {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(runningSum(nums)));

        int[] nums2 = { 1, 1, 1, 1, 1 };
        System.out.println(Arrays.toString(runningSum(nums2)));
    }

    /**
     * Calculates the running sum of an array.
     * @param nums The input array of integers.
     * @return A new array with the running sum.
     */
    static int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = sumArray(nums, i);
        }

        return ans;
    }

    /**
     * Calculates the sum of all elements in an array up to a given index.
     * @param nums The input array of integers.
     * @param i The index to sum up to (inclusive).
     * @return The sum of elements from index 0 to i.
     */
    static int sumArray(int[] nums, int i) {
        int sum = 0;
        for (int index = 0; index <= i; index++) {
            sum += nums[index];
        }

        return sum;
    }
}
