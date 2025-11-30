package com.dsa.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class provides a solution to the "Find All Numbers Disappeared in an
 * Array" problem on LeetCode.
 * <p>
 * LeetCode problem 448:
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * <p>
 * It finds all the numbers that are missing from an array containing numbers
 * from 1 to n.
 */
public class FindDisappearedNumbers {

    /**
     * The main method to test the findDisappearedNumbers function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(findDisappearedNumbers(nums).toString());
    }

    /**
     * Finds all the numbers that are missing from an array containing numbers from 1
     * to n.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums An array of integers where 1 ≤ a[i] ≤ n (n = size of array).
     * @return A list of integers that are missing from the input array.
     */
    static List<Integer> findDisappearedNumbers(int[] nums) {
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

        System.out.println(Arrays.toString(nums));

        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                result.add(index + 1);
            }
        }

        return result;
    }
}
