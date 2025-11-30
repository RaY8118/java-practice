package com.dsa.algorithms.sorting;

/**
 * This class provides a solution to the "Find the Duplicate Number" problem on
 * LeetCode.
 * <p>
 * LeetCode problem 287: https://leetcode.com/problems/find-the-duplicate-number/
 * <p>
 * It finds the duplicate number in an array containing n + 1 integers where
 * each integer is in the range [1, n] inclusive.
 */
public class FindDuplicate {

    /**
     * The main method to test the findDuplicate function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 2, 2 };
        System.out.println(findDuplicate(nums));
    }

    /**
     * Finds the duplicate number in an array using the Cycle Sort concept.
     * <p>
     * This method assumes that the input array contains n + 1 integers where each
     * integer is in the range [1, n] inclusive, and there is only one duplicate
     * number.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums The array of integers.
     * @return The duplicate number in the array. Returns -1 if no duplicate is
     *         found (though the problem statement guarantees a duplicate exists).
     */
    static int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                int correctIndex = nums[i] - 1;

                if (nums[i] != nums[correctIndex]) {
                    int temp = nums[i];
                    nums[i] = nums[correctIndex];
                    nums[correctIndex] = temp;
                } else {
                    return nums[i];
                }
            } else {
                i++;
            }
        }
        return -1;
    }
}
