package com.dsa.algorithms.sorting;

/**
 * Implements a solution to find the squares of a sorted array.
 * This class addresses LeetCode problem 977: Squares of a Sorted Array.
 * It efficiently calculates the squares of elements in a given array and
 * returns them in a new sorted array.
 */
// Leetcode 977
// https://leetcode.com/problems/squares-of-a-sorted-array/
import java.util.Arrays;

public class SortedSqaures {
    public static void main(String[] args) {
        // int[] nums = { -4, -1, 0, 3, 10 };
        // System.out.println(Arrays.toString(sortedSqaures(nums)));

        int[] nums2 = { -7, -3, 2, 3, 11 };
        System.out.println(Arrays.toString(sortedSqaures(nums2)));
    }

    /**
     * Sorts the squares of elements in a given array using a two-pointer approach.
     * The algorithm iterates from both ends of the input array, comparing the
     * absolute values of the elements to place the larger square at the end
     * of the result array, ensuring the final array is sorted in non-decreasing order.
     * <p>
     * Time Complexity: O(n), where n is the number of elements in the input array.
     * Space Complexity: O(n), for the result array.
     *
     * @param nums The input array of integers.
     * @return A new array containing the squares of the elements from the input array, sorted in non-decreasing order.
     */
    static int[] sortedSqaures(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int k = nums.length - 1;
        int[] result = new int[nums.length];

        while (i <= j) {
            if (Math.abs(nums[i]) < Math.abs(nums[j])) {
                result[k] = (nums[j] * nums[j]);
                j--;
            } else {
                result[k] = (nums[i] * nums[i]);
                i++;
            }
            k--;

        }

        return result;
    }
}
