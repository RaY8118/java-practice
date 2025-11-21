package com.dsa.algorithms.arrays;

// Leetcode 1672
// https://leetcode.com/problems/richest-customer-wealth/

/**
 * This class provides a solution to find the maximum wealth among a list of customers.
 */
public class MaximumWealth {

    public static void main(String[] args) {
        int[][] accounts = { { 1, 2, 3 }, { 3, 2, 4 } };
        int ans = maxWealth(accounts);
        System.out.println(ans);
    }

    /**
     * Calculates the maximum wealth of a customer.
     *
     * @param accounts A 2D integer array where {@code accounts[i][j]} is the amount of money the
     *     i-th customer has in the j-th bank.
     * @return The wealth of the richest customer.
     */
    static int maxWealth(int[][] accounts) {
        int ans = Integer.MIN_VALUE;
        for (int person = 0; person < accounts.length; person++) {
            int sum = 0;
            for (int account = 0; account < accounts[person].length; account++) {
                sum += accounts[person][account];
            }

            if (sum > ans) {
                ans = sum;
            }
        }

        return ans;

    }
}
