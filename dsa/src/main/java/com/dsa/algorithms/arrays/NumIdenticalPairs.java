package com.dsa.algorithms.arrays;

/**
 * This class provides a solution to the "Number of Good Pairs" problem on LeetCode.
 * <p>
 * LeetCode problem 1512: https://leetcode.com/problems/number-of-good-pairs/
 * <p>
 * A "good pair" is a pair of indices (i, j) in an array such that nums[i] ==
 * nums[j] and i < j.
 */
public class NumIdenticalPairs {

    /**
     * The main method to test the numIdenticalPairs function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1, 1, 3 };
        System.out.println(numIdenticalPairs(nums));

        int[] nums2 = { 1, 1, 1, 1 };
        System.out.println(numIdenticalPairs(nums2));

        int[] nums3 = { 1, 2, 3 };
        System.out.println(numIdenticalPairs(nums3));
    }

    /**
     * Counts the number of "good pairs" in an array.
     *
     * @param nums An array of integers.
     * @return The number of good pairs.
     */
    static int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i < j) {
                    count++;
                }
            }
        }

        return count;
    }
}
