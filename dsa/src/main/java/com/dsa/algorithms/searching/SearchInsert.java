package com.dsa.algorithms.searching;

/**
 * This class provides a solution to the "Search Insert Position" problem on LeetCode.
 * Leetcode 35
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsert {

    /**
     * The main method to test the searchInsert function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 7));
    }

    /**
     * Given a sorted array of distinct integers and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     *
     * @param nums   The sorted array of distinct integers.
     * @param target The target value.
     * @return The index of the target value or the index where it would be inserted.
     */
    /**
     * Given a sorted array of distinct integers and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * <p>
     * Time Complexity: O(log n), where n is the length of the array.
     * Space Complexity: O(1)
     *
     * @param nums   The sorted array of distinct integers.
     * @param target The target value.
     * @return The index of the target value or the index where it would be inserted.
     */
    static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }
}
