package com.dsa.algorithms.sorting;

import java.util.Arrays;

/**
 * This class provides a solution to the "Merge Sorted Array" problem on
 * LeetCode.
 * <p>
 * LeetCode problem 88:
 * https://leetcode.com/problems/merge-sorted-array/
 * <p>
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
 * order, and two integers m and n, representing the number of elements in
 * nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function, but instead
 * be stored inside the array nums1. To accommodate this, nums1 has a length
 * of m + n, where the first m elements denote the elements that should be
 * merged, and the last n elements are set to 0 and should be ignored. nums2
 * has a length of n.
 */
public class Merge {
    /**
     * The main method to test the merge function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };
        merge(nums1, 3, nums2, 3);
    }

    /**
     * Merges two sorted arrays into one sorted array.
     *
     * @param nums1 The first sorted array, with space for the merged result.
     * @param m     The number of elements in nums1.
     * @param nums2 The second sorted array.
     * @param n     The number of elements in nums2.
     */
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        quickSort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * Sorts an array of integers using the quicksort algorithm.
     *
     * @param nums The array to be sorted.
     */
    static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    /**
     * Sorts a subarray of integers using the quicksort algorithm.
     *
     * @param nums  The array to be sorted.
     * @param start The starting index of the subarray.
     * @param end   The ending index of the subarray.
     */
    static void quickSort(int[] nums, int start, int end) {
        if (start >= end)
            return;

        int pivotIndex = partition(nums, start, end);

        quickSort(nums, start, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, end);
    }

    /**
     * Partitions a subarray of integers for the quicksort algorithm.
     *
* @param nums The array to be partitioned.
     * @param start The starting index of the subarray.
     * @param end   The ending index of the subarray.
     * @return The index of the pivot element.
     */
    static int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (nums[j] < pivot) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        int temp = nums[i + 1];
        nums[i + 1] = nums[end];
        nums[end] = temp;

        return i + 1;
    }
}
