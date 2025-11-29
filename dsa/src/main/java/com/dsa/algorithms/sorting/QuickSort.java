package com.dsa.algorithms.sorting;

import java.util.Arrays;

/**
 * This class implements the QuickSort algorithm for sorting an array of integers.
 * QuickSort is a divide-and-conquer algorithm that picks an element as a pivot
 * and partitions the given array around the picked pivot.
 */
public class QuickSort {
    /**
     * The main method to test the QuickSort implementation.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums = { 8, 3, 2, 9, 1, 7, 6, 10, 4, 5 };
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    
    }

    /**
     * Sorts an array of integers using the QuickSort algorithm.
     * <p>
     * Time Complexity:
     *   Worst Case: O(n^2)
     *   Average Case: O(n log n)
     *   Best Case: O(n log n)
     * Space Complexity: O(log n) (due to recursion stack)
     *
     * @param nums The array of integers to be sorted.
     */
    static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    /**
     * Recursively sorts a portion of an array using the QuickSort algorithm.
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
}
