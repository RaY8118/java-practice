package com.dsa.algorithms.sorting;

// Leetcode 217
// https://leetcode.com/problems/contains-duplicate/
import java.util.HashSet;

/**
 * Implements a solution for Leetcode problem 217: Contains Duplicate.
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * Problem link: <a href="https://leetcode.com/problems/contains-duplicate/">Leetcode 217</a>
 */
public class ContainsDuplicate {
    /**
     * Main method to demonstrate the containsDuplicate algorithm.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(containsDuplicate(nums));
    }

    /**
     * Checks if an array contains any duplicate elements.
     * This method uses a HashSet to store encountered numbers. If a number is already
     * in the set, it means a duplicate has been found.
     * <p>
     * Time Complexity: O(n), where n is the number of elements in the array.
     *                  Each element is inserted into the HashSet once, and HashSet
     *                  operations (add, contains) take O(1) on average.
     * Space Complexity: O(n), where n is the number of elements in the array.
     *                   In the worst case, all elements are distinct and stored in the HashSet.
     *
     * @param nums The array of integers to check for duplicates.
     * @return true if any value appears at least twice in the array, false otherwise.
     */
    static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }
}
