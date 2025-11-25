package com.dsa.algorithms.searching;

/**
 * This class provides a solution to the "Find in Mountain Array" problem on
 * LeetCode.
 * <p>
 * LeetCode problem 1095:
 * <a href=
 * "https://leetcode.com/problems/find-in-mountain-array/">https://leetcode.com/problems/find-in-mountain-array/</a>
 * <p>
 * It involves finding a target value in a mountain array using a specialized
 * binary search approach.
 */
public class FindInMountainInArray {
    /**
     * The main method to test the findInMountainInArray function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 3, 1 };
        System.out.println(findInMountainInArray(3, arr));
        int[] arr2 = { 1, 2, 3, 4, 5, 3, 1 };
        System.out.println(findInMountainInArray(2, arr2));
    }

    /**
     * Finds the target value in a mountain array.
     * This method first finds the peak element's index and then performs
     * binary searches on both the ascending and descending parts of the array.
     *
     * @param target The value to find.
     * @param arr    The mountain array.
     * @return The index of the target if found, otherwise -1. If the target exists
     *         multiple times,
     *         it returns the smallest index.
     */
    static int findInMountainInArray(int target, int[] arr) {
        int index = getIndexForPeak(arr);
        int idx1 = binarySearch1(arr, index, target);
        int idx2 = binarySearch2(arr, index, target);

        if (idx1 == -1)
            return idx2;
        if (idx2 == -1)
            return idx1;
        return idx1 < idx2 ? idx1 : idx2;

    }

    /**
     * Finds the index of the peak element in a mountain array.
     *
     * @param arr The mountain array.
     * @return The index of the peak element.
     */
    static int getIndexForPeak(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    /**
     * Performs a binary search on the ascending part of the mountain array.
     *
     * @param arr    The mountain array.
     * @param end    The ending index for the search (typically the peak index).
     * @param target The value to find.
     * @return The index of the target if found, otherwise -1.
     */
    static int binarySearch1(int[] arr, int end, int target) {
        int start = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * Performs a binary search on the descending part of the mountain array.
     *
     * @param arr    The mountain array.
     * @param start  The starting index for the search (typically the peak index).
     * @param target The value to find.
     * @return The index of the target if found, otherwise -1.
     */
    static int binarySearch2(int[] arr, int start, int target) {
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > arr[mid]) {
                end = mid - 1;
            } else if (target < arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
