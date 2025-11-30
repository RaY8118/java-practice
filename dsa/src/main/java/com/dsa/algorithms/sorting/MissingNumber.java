package com.dsa.algorithms.sorting;

/**
 * This class provides a solution to the "Missing Number" problem on LeetCode.
 * <p>
 * LeetCode problem 268: https://leetcode.com/problems/missing-number/
 * <p>
 * It finds the missing number in an array containing n distinct numbers in the
 * range [0, n].
 */
public class MissingNumber {

    /**
     * The main method to test the missingNumber function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums = { 0, 2, 1, 5, 4 };
        System.out.println(missingNumber(nums));
    }

    /**
     * Finds the missing number in an array containing n distinct numbers in the
     * range [0, n].
     * <p>
     * This method uses the Cycle Sort concept to place numbers at their correct
     * indices.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums An array of n distinct numbers in the range [0, n].
     * @return The missing number in the range.
     */
    static int missingNumber(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            int correctIndex = nums[i];

            if (nums[i] < nums.length && nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index) {
                return index;
            }
        }

        return nums.length;
    }

}
