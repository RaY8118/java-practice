package com.dsa.algorithms.sorting;

/**
 * This class provides a solution to the "First Missing Positive" problem on LeetCode.
 * <p>
 * LeetCode problem 41:
 * <a href="https://leetcode.com/problems/first-missing-positive/">https://leetcode.com/problems/first-missing-positive/</a>
 * <p>
 * It finds the smallest missing positive integer in an unsorted array of integers.
 */
public class FirstMissingPositive {

    /**
     * The main method to test the firstMissingPositive function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums = { -1, 1, 3, 4 };
        System.out.println(firstMissingPositive(nums));
    }

    /**
     * Finds the smallest missing positive integer in an unsorted array of integers.
     * The algorithm uses cyclic sort to place each number in its correct position
     * (i.e., number `x` should be at index `x-1`). After sorting, it iterates
     * through the array to find the first index `i` where `nums[i] != i + 1`.
     * If no such index is found, the smallest missing positive is `nums.length + 1`.
     *
     * @param nums An array of integers.
     * @return The smallest missing positive integer.
     */
    static int firstMissingPositive(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correctIndex]) {
                // Swap nums[i] with nums[correctIndex]
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                return index + 1;
            }
        }
        return nums.length + 1;
    }
}
