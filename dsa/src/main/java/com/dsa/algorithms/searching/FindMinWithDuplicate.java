package com.dsa.algorithms.searching;

/**
 * This class provides a solution to the "Find Minimum in Rotated Sorted Array
 * II" problem on LeetCode.
 * <p>
 * LeetCode problem 154:
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * <p>
 * It finds the minimum element in a rotated sorted array that may contain
 * duplicates.
 */
public class FindMinWithDuplicate {

    /**
     * The main method to test the findMin function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums = { 1, 3, 5 };
        System.out.println(findMin(nums));

        int[] nums2 = { 2, 2, 2, 0, 1 };
        System.out.println(findMin(nums2));

        int[] nums3 = { 3, 3, 1, 3 };
        System.out.println(findMin(nums3));
    }

    /**
     * Finds the minimum element in a rotated sorted array that may contain
     * duplicates.
     *
     * @param nums An array of integers that is sorted, rotated, and may contain
     *             duplicates.
     * @return The minimum element in the array.
     */
    /**
     * Finds the minimum element in a rotated sorted array that may contain
     * duplicates.
     * <p>
     * Time Complexity: O(log n) in best/average case, O(n) in worst case (due to duplicates), where n is the length of the array.
     * Space Complexity: O(1)
     *
     * @param nums An array of integers that is sorted, rotated, and may contain
     *             duplicates.
     * @return The minimum element in the array.
     */
    static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                end--;
            }
        }

        return nums[start];
    }
}
