package com.dsa.algorithms.searching;

/**
 * This class provides a solution to the "Search in Rotated Sorted Array"
 * problem on LeetCode.
 * <p>
 * LeetCode problem 33:
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * <p>
 * It searches for a target value in a rotated sorted array.
 */
public class Search {
    /**
     * The main method to test the search function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(search(nums, 0));

        int[] nums2 = { 3, 4, 5, 6, 1, 2 };
        System.out.println(search(nums2, 2));

        int[] nums3 = { 1 };
        System.out.println(search(nums3, 0));
    }

    /**
     * Finds the pivot index in a rotated sorted array.
     *
     * @param arr The rotated sorted array.
     * @return The index of the pivot element.
     */
    /**
     * Finds the pivot index in a rotated sorted array.
     * <p>
     * Time Complexity: O(log n), where n is the length of the array.
     * Space Complexity: O(1)
     *
     * @param arr The rotated sorted array.
     * @return The index of the pivot element.
     */
    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    /**
     * Searches for a target value in a rotated sorted array.
     *
     * @param nums   The rotated sorted array.
     * @param target The value to search for.
     * @return The index of the target value if found, otherwise -1.
     */
    /**
     * Searches for a target value in a rotated sorted array.
     * <p>
     * Time Complexity: O(log n), where n is the length of the array, due to finding pivot and then performing binary search.
     * Space Complexity: O(1)
     *
     * @param nums   The rotated sorted array.
     * @param target The value to search for.
     * @return The index of the target value if found, otherwise -1.
     */
    static int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if (pivot == 0) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        if (target >= nums[pivot] && target <= nums[nums.length - 1]) {
            return binarySearch(nums, pivot, nums.length - 1, target);
        }
        return binarySearch(nums, 0, pivot - 1, target);
    }

    /**
     * Performs a binary search on a sorted array.
     *
     * @param arr    The sorted array.
     * @param start  The starting index of the search range.
     * @param end    The ending index of the search range.
     * @param target The value to search for.
     * @return The index of the target value if found, otherwise -1.
     */
    /**
     * Performs a binary search on a sorted array.
     * <p>
     * Time Complexity: O(log n), where n is the length of the array (or the search range).
     * Space Complexity: O(1)
     *
     * @param arr    The sorted array.
     * @param start  The starting index of the search range.
     * @param end    The ending index of the search range.
     * @param target The value to search for.
     * @return The index of the target value if found, otherwise -1.
     */
    static int binarySearch(int[] arr, int start, int end, int target) {
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

}
