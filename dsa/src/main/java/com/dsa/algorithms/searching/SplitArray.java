package com.dsa.algorithms.searching;

/**
 * This class provides a solution to the "Split Array Largest Sum" problem on
 * LeetCode.
 * <p>
 * LeetCode problem 410:
 * https://leetcode.com/problems/split-array-largest-sum/
 */
public class SplitArray {
    /**
     * The main method to test the splitArray function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums = { 7, 2, 5, 10, 8 };
        System.out.println(splitArray(nums, 2));
    }

    /**
     * Given an array nums which consists of non-negative integers and an integer
     * k, you can split the
     * array into k non-empty continuous subarrays. Write an algorithm to minimize
     * the largest sum among
     * these k subarrays.
     *
     * @param nums The array of non-negative integers.
     * @param k    The number of subarrays to split the array into.
     * @return The minimized largest sum among the k subarrays.
     */
    static int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            end += nums[i];
        }

        while (start < end) {
            int mid = start + (end - start) / 2;

            int sum = 0;
            int parts = 1;
            for (int num : nums) {
                if (sum + num > mid) {
                    sum = num;
                    parts++;
                } else {
                    sum += num;
                }
            }

            if (parts > k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }
}
