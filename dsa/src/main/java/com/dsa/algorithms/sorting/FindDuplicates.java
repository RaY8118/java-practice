package com.dsa.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution to the "Find All Duplicates in an Array"
 * problem on LeetCode.
 * <p>
 * LeetCode problem 442:
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * <p>
 * It finds all the duplicate elements in an array of integers where each
 * integer is in the range [1, n] and each integer appears once or twice.
 */
public class FindDuplicates {

    /**
     * The main method to test the findDuplicates function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(findDuplicates(nums).toString());

        int[] nums2 = { 1, 1, 2 };
        System.out.println(findDuplicates(nums2).toString());
    }

    /**
     * Finds all the duplicate elements in an array using the Cycle Sort concept.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums An array of integers where 1 ≤ a[i] ≤ n (n = size of array),
     *             some elements appear twice and others appear once.
     * @return A list of integers containing all the duplicate elements.
     */
    static List<Integer> findDuplicates(int[] nums) {
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

        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                ans.add(nums[j]);
            }
        }
        return ans;
    }
}
