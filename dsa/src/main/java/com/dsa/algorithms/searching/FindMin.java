package com.dsa.algorithms.searching;

/**
 * This class provides a solution to the "Find Minimum in Rotated Sorted Array"
 * problem on LeetCode.
 * <p>
 * LeetCode problem 153:
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * <p>
 * It finds the minimum element in a rotated sorted array.
 */
public class FindMin {

    /**
     * The main method to test the findMin function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2 };
        System.out.println(findMin(nums));

        int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(findMin(nums2));

        int[] nums3 = { 2, 3, 4, 5, 1 };
        System.out.println(findMin(nums3));
    }

    /**
     * Finds the minimum element in a rotated sorted array.
     *
     * @param nums An array of integers that is sorted and rotated.
     * @return The minimum element in the array.
     */
    static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return nums[end];
    }
}
