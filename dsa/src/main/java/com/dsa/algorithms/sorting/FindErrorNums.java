package com.dsa.algorithms.sorting;

// Leetcode 645
// https://leetcode.com/problems/set-mismatch/
import java.util.Arrays;

/**
 * Implements a solution for Leetcode problem 645: Set Mismatch.
 * You have a set of integers s, which originally contains all the numbers from 1 to n.
 * Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
 * which results in repetition of one number and loss of another number.
 * Given an integer array nums representing the data status of this set after the error.
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 *
 * Problem link: <a href="https://leetcode.com/problems/set-mismatch/">Leetcode 645</a>
 */
public class FindErrorNums {
    /**
     * Main method to demonstrate the findErrorNums algorithm.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 4 };
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    /**
     * Finds the number that occurs twice and the number that is missing in an array
     * that originally contained all numbers from 1 to n.
     * This method uses an in-place cyclic sort approach.
     * <p>
     * Time Complexity: O(n), where n is the number of elements in the array.
     *                  The cyclic sort part iterates through the array at most twice (inner loop
     *                  only runs when a swap is needed, and each element is swapped at most once).
     *                  The final loop to find the mismatch is also O(n).
     * Space Complexity: O(1), as the sorting is done in-place without using extra data structures
     *                   proportional to the input size.
     *
     * @param nums The array of integers representing the data status after the error.
     * @return An array of two integers: the number that occurs twice and the number that is missing.
     */
    static int[] findErrorNums(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return new int[] { nums[j], j + 1 };
            }
        }
        return new int[] { -1, -1 };
    }
}
