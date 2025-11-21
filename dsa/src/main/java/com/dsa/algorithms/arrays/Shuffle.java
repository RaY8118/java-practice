package com.dsa.algorithms.arrays;

import java.util.Arrays;

/**
 * This class provides a method to shuffle an array of integers.
 * The shuffling is done in a specific pattern: [x1,y1,x2,y2,...,xn,yn].
 */
public class Shuffle {
    public static void main(String[] args) {
        int[] nums = { 2, 5, 1, 3, 4, 7 };
        int n = 3;
        System.out.println(Arrays.toString(shuffle(nums, n)));

        int[] nums2 = { 1, 2, 3, 4, 4, 3, 2, 1 };
        int n2 = 4;
        System.out.println(Arrays.toString(shuffle(nums2, n2)));

    }

    /**
     * Shuffles an array of 2n elements.
     * The array is shuffled into the form [x1,y1,x2,y2,...,xn,yn].
     *
     * @param nums The input array of 2n integers.
     * @param n The half size of the array.
     * @return A new array with the shuffled elements.
     */
    static int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[i + n];
        }

        return ans;
    }
}
