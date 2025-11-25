package com.dsa.algorithms.searching;

/**
 * This class provides a solution for searching in an infinite sorted array.
 * Although a true infinite array cannot exist, this simulates the problem
 * where the size of the array is unknown, and we cannot use `arr.length`
 * directly in the initial search for the bounds.
 * <p>
 * The approach involves finding the bounds (start and end) where the target
 * might exist, and then performing a standard binary search within those bounds.
 */
public class InfiniteArray {
    /**
     * The main method to test the infiniteArray function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int target = 2;
        System.out.println(infiniteArray(nums, target));

    }

    /**
     * Searches for a target value in a simulated infinite sorted array.
     * The array is considered "infinite" in the sense that its size is unknown
     * and cannot be accessed directly. The method first finds a range where
     * the target might be present and then performs a binary search within that range.
     *
     * @param nums The sorted array to search within.
     * @param target The value to search for.
     * @return The index of the target if found, otherwise -1.
     */
    static int infiniteArray(int[] nums, int target) {
        int start = 0;
        int end = 1;

        while (target > nums[end]) {
            int temp = end + 1;
            // Double the search box size: new end = previous end + (size of previous box * 2)
            // or more simply, previous end + (end - start + 1)
            end = end + (end - start + 1);
            start = temp;
        }

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
        return -1;

    }

}
