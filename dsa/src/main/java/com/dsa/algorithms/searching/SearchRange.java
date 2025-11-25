package com.dsa.algorithms.searching;

import java.util.Arrays;

/**
 * This class provides a solution to the "Find First and Last Position of Element in Sorted Array"
 * problem on LeetCode.
 * <p>
 * LeetCode problem 34:
 * <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">Find First and Last Position of Element in Sorted Array</a>
 * <p>
 * It finds the starting and ending position of a given target value in a sorted array.
 */
public class SearchRange {
    /**
     * The main method to test the searchRange function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 7, 8, 8, 10 };
        System.out.println(Arrays.toString(searchRange(nums, 7)));
    }

    /**
     * Finds the starting and ending position of a given target value in a sorted array.
     *
     * @param nums   The sorted array of integers.
     * @param target The value to search for.
     * @return An array of two integers representing the start and end indices of the target value.
     *         If the target is not found, returns [-1, -1].
     */
    static int[] searchRange(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        int ans[] = { -1, -1 };

        while (min <= max) {
            int mid = min + (max - min) / 2;

            if (target < nums[mid]) {
                max = mid - 1;
            } else if (target > nums[mid]) {
                min = mid + 1;
            } else {
                ans[0] = mid;
                max = mid - 1;
            }
        }

        min = 0;
        max = nums.length - 1;

        while (min <= max) {
            int mid = min + (max - min) / 2;

            if (target < nums[mid]) {
                max = mid - 1;
            } else if (target > nums[mid]) {
                min = mid + 1;
            } else {
                ans[1] = mid;
                min = mid + 1;
            }
        }

        return ans;
    }
}

