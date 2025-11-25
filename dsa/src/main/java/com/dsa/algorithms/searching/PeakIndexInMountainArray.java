package com.dsa.algorithms.searching;

/**
 * This class provides a solution to the "Peak Index in a Mountain Array" problem on LeetCode.
 * <p>
 * LeetCode problem 852:
 * <a href="https://leetcode.com/problems/peak-index-in-a-mountain-array/">https://leetcode.com/problems/peak-index-in-a-mountain-array/</a>
 * <p>
 * It finds the peak element's index in a mountain array. A mountain array is defined as
 * an array that has at least 3 elements;
 * is strictly increasing until some element, and then strictly decreasing from that element.
 */
public class PeakIndexInMountainArray {
    /**
     * The main method to test the peakIndexInMountainArray function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] arr = { 0, 1, 0 };
        System.out.println(peakIndexInMountainArray(arr));

        int[] arr2 = { 0, 2, 1, 0 };
        System.out.println(peakIndexInMountainArray(arr2));

        int[] arr3 = { 0, 10, 5, 2 };
        System.out.println(peakIndexInMountainArray(arr3));
    }

    /**
     * Finds the peak index in a mountain array.
     * A mountain array is guaranteed to have a peak.
     * The algorithm uses a binary search approach to efficiently find the peak.
     *
     * @param arr An array of integers representing a mountain array.
     * @return The index of the peak element in the mountain array.
     */
    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                // We are in the decreasing part of the array, or at the peak.
                // This might be the answer, so we try to find in the left half.
                // end does not become mid - 1, because mid could be the potential answer.
                end = mid;
            } else {
                // We are in the increasing part of the array.
                // The peak must be on the right side.
                start = mid + 1;
            }
        }
        // In the end, start == end and points to the largest element, which is the peak.
        return start;

    }

}
