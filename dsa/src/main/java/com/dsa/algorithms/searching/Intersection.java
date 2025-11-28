package com.dsa.algorithms.searching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This class provides a solution to find the intersection of two arrays.
 * Leetcode 349
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class Intersection {
    /**
     * The main method to test the intersection function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));

        int[] a = {4, 9, 5};
        int[] b = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection(a, b)));
    }

    /**
     * Finds the intersection of two arrays.
     *
     * @param nums1 The first array.
     * @param nums2 The second array.
     * @return An array containing the intersection of the two input arrays.
     */
    static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        Set<Integer> result = new HashSet<>();

        for (int n : nums1) {
            if (binarySearch(nums2, n)) {
                result.add(n);
            }
        }

        int[] out = new int[result.size()];
        int i = 0;
        for (int n : result) {
            out[i++] = n;
        }
        return out;
    }

    /**
     * Performs a binary search on a sorted array to find a target value.
     *
     * @param nums2 The sorted array to search in.
     * @param n     The target value to search for.
     * @return True if the target value is found, false otherwise.
     */
    static boolean binarySearch(int[] nums2, int n) {
        int start = 0;
        int end = nums2.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (n < nums2[mid]) {
                end = mid - 1;
            } else if (n > nums2[mid]) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
