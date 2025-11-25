package com.dsa.algorithms.searching;

/**
 * This class finds a peak element in an array.
 * <p>
 * A peak element is an element that is strictly greater than its neighbors.
 * <p>
 * LeetCode problem 162:
 * https://leetcode.com/problems/find-peak-element/
 */
public class FindPeakElement {
    /**
     * The main method to test the findPeakElement function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(findPeakElement(nums));

        int[] nums2 = { 1, 2, 1, 3, 5, 6, 4 };
        System.out.println(findPeakElement(nums2));
    }

    /**
     * Finds a peak element in the given array.
     *
     * @param nums The input array.
     * @return The index of a peak element.
     */
    static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
