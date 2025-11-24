package com.dsa.algorithms.searching;

/**
 * This class provides a solution to the "First Bad Version" problem on LeetCode.
 * <p>
 * LeetCode problem 278:
 * https://leetcode.com/problems/first-bad-version/
 * <p>
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which returns whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
public class FirstBadVersion {

    /**
     * The main method to test the firstBadVersion function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int n = 5;
        System.out.println(firstBadVersion(n));
    }

    /**
     * Finds the first bad version.
     *
     * @param n The total number of versions.
     * @return The first bad version.
     */
    static int firstBadVersion(int n) {
        int min = 1;
        int max = n;
        int ans = n;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (isBadVersion(mid)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }

        }
        return ans;
    }

    /**
     * A dummy implementation of the isBadVersion API for testing purposes.
     * In the actual problem, this method would be provided.
     *
     * @param n The version to check.
     * @return true if the version is bad, false otherwise.
     */
    static boolean isBadVersion(int n) {
        return n >= 4;
    }
}
