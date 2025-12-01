package com.dsa.algorithms.sorting;

/**
 * This class provides a solution to the "Majority Element" problem on LeetCode.
 * <p>
 * LeetCode problem 169:
 * https://leetcode.com/problems/majority-element/
 * <p>
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 */
public class MajorityElement {
    /**
     * The main method to test the majorityElement function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums = { 3, 2, 3 };
        System.out.println(majorityElement(nums));
    }

    /**
     * Finds the majority element in an array.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums An array of integers.
     * @return The majority element.
     */
    static int majorityElement(int[] nums) {
        int ans = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                ans = num;
            }
            if (num == ans) {
                count++;
            } else {
                count--;
            }
        }
        return ans;
    }
}
