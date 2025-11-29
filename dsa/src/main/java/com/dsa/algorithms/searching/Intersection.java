package com.dsa.algorithms.searching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This class provides a solution to find the intersection of two arrays.
 * Leetcode 349
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class Intersection {
    /**
     * The main method to test the intersection function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));

        int[] a = {4, 9, 5};
        int[] b = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(a, b)));
    }

    /**
     * Finds the intersection of two arrays.
     *
     * @param nums1 The first array.
     * @param nums2 The second array.
     * @return An array containing the intersection of the two input arrays.
     */
    static int[] intersection(int[] nums1, int[] nums2) {
        quickSort(nums2);
        Set<Integer> result = new HashSet<>();

        for (int n : nums1) {
            if (binarySearch(nums2, n)) {
                result.add(n);
            }
        }

        int[] out = new int[result.size()];
        int i = 0;
        for (int n : result) {
            out[i++] = n;
        }
        return out;
    }

    static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    /**
     * Recursively sorts a portion of an array using the QuickSort algorithm.
     * This is a helper method for the intersection finding logic.
     *
     * @param nums  The array of integers to be sorted.
     * @param start The starting index of the portion to be sorted.
     * @param end   The ending index of the portion to be sorted.
     */
    static void quickSort(int[] nums, int start, int end) {
        if (start >= end)
            return;

        int pivotIndex = partition(nums, start, end);

        quickSort(nums, start, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, end);
    }

    /**
     * Partitions a portion of an array around a pivot element.
     * This is a helper method for the QuickSort algorithm used in intersection finding.
     *
     * @param nums  The array of integers to be partitioned.
     * @param start The starting index of the portion to be partitioned.
     * @param end   The ending index of the portion to be partitioned (the pivot element).
     * @return The final index of the pivot element after partitioning.
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

    /**
     * Performs a binary search on a sorted array to find a target value.
     *
     * @param nums2 The sorted array to search in.
     * @param n     The target value to search for.
     * @return True if the target value is found, false otherwise.
     */
    static boolean binarySearch(int[] nums2, int n) {
        int start = 0;
        int end = nums2.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (n < nums2[mid]) {
                end = mid - 1;
            } else if (n > nums2[mid]) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
