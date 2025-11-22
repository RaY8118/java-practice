package com.dsa.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class provides a solution to the "Create Target Array in the Given
 * Order" problem on LeetCode.
 * <p>
 * LeetCode problem 1389:
 * https://leetcode.com/problems/create-target-array-in-the-given-order/
 * <p>
 * It creates a target array by inserting elements from `nums` into specific
 * positions defined by `index`.
 */
public class CreateTargetArray {

    /**
     * The main method to test the createTargetArray function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 3, 4 };
        int[] index = { 0, 1, 2, 2, 1 };
        System.out.println(Arrays.toString(createTargetArray(nums, index)));

        int[] nums2 = { 1, 2, 3, 4, 0 };
        int[] index2 = { 0, 1, 2, 3, 0 };

        System.out.println(Arrays.toString(createTargetArray(nums2, index2)));
    }

    /**
     * Creates a target array by inserting elements from `nums` at positions
     * specified in `index`.
     *
     * @param nums  An array of integers to be inserted.
     * @param index An array of indices at which to insert the elements from `nums`.
     * @return The target array.
     */
    static int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] target = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans.add(index[i], nums[i]);
        }

        for (int i = 0; i < target.length; i++) {
            target[i] = ans.get(i);
        }

        return target;

    }
}
