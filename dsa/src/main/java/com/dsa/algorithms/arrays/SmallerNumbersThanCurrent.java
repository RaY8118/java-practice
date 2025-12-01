package com.dsa.algorithms.arrays;

import java.util.Arrays;

/**
 * This class provides a solution to the "How Many Numbers Are Smaller Than the
 * Current Number" problem on LeetCode.
 * <p>
 * LeetCode problem 1365:
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * <p>
 * For each number in an array, it counts how many other numbers in the array
 * are smaller than it.
 */
public class SmallerNumbersThanCurrent {

    /**
     * The main method to test the smallerNumbersThanCurrent function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums = { 8, 1, 2, 2, 3 };
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));

        int[] nums2 = { 6, 5, 4, 8 };
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums2)));

        int[] nums3 = { 7, 7, 7, 7 };
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums3)));
    }

    /**
     * For each number in an array, counts how many other numbers in the array are
     * smaller than it.
     *
     * @param nums An array of integers.
     * @return An array of integers where each element at index i is the count of
     *         numbers in the input
     *         array that are smaller than nums[i].
     */
    /**
     * For each number in an array, counts how many other numbers in the array are
     * smaller than it.
     * <p>
     * Time Complexity: O(n^2), where n is the length of the input array.
     * Space Complexity: O(n), for the new array to store the results.
     *
     * @param nums An array of integers.
     * @return An array of integers where each element at index i is the count of
     *         numbers in the input
     *         array that are smaller than nums[i].
     */
    static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < ans.length; i++) {
            int count = 0;
            for (int j = 0; j < ans.length; j++) {
                if (i != j && nums[j] < nums[i]) {
                    count++;
                }
            }
            ans[i] = count;
        }

        return ans;
    }
}
