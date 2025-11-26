package com.dsa.algorithms.searching;

/**
 * This class provides a solution to the "Binary Search" problem on LeetCode.
 * <p>
 * LeetCode problem 704:
 * https://leetcode.com/problems/binary-search/
 * <p>
 * It searches for a target value in a sorted array of integers.
 */
public class SearchBinary {

    /**
     * The main method to test the search function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        System.out.println(search(nums, 9));

        System.out.println(search(nums, 2));
    }

    /**
     * Searches for a target value in a sorted array of integers using the binary
     * search algorithm.
     *
     * @param nums   An array of integers sorted in ascending order.
     * @param target The integer value to search for.
     * @return The index of the target if it is found, otherwise -1.
     */
    static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
