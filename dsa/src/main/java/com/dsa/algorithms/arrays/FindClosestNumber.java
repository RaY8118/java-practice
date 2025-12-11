package com.dsa.algorithms.arrays;

/**
 * Implements a solution to find the number closest to zero in an array.
 * This class addresses LeetCode problem 2239: Find Closest Number to Zero.
 * It finds the number in the input array that has the minimum absolute value.
 * If there are multiple numbers with the same minimum absolute value,
 * it returns the one with the greater value.
 */
// Leetcode 2239
//https://leetcode.com/problems/find-closest-number-to-zero/ 
public class FindClosestNumber {
    public static void main(String[] args) {
        int[] nums = { -4, -2, 1, 4, 8 };
        System.out.println(findClosestNumber(nums));

        int[] nums2 = { -10000, -10000 };
        System.out.println(findClosestNumber(nums2));
    }

    /**
     * Finds the number in the input array that is closest to zero.
     * If there are multiple numbers with the same minimum absolute value,
     * the positive number is returned. The algorithm iterates through the array,
     * maintaining the current closest number found so far.
     * <p>
     * Time Complexity: O(n), where n is the number of elements in the input array.
     * Space Complexity: O(1).
     *
     * @param nums The input array of integers.
     * @return The number in the array closest to zero. If there's a tie in absolute value, the positive number is returned.
     */
    static int findClosestNumber(int[] nums) {
        int closest = nums[0];
        for (int num : nums) {
            if (Math.abs(closest) > Math.abs(num)) {
                closest = num;
            } else if (Math.abs(closest) == Math.abs(num) && num > closest) {
                closest = num;
            }
        }

        return closest;

    }
}
