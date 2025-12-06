package com.dsa.algorithms.arrays;

/**
 * Implements a solution to Leetcode Problem 204: Count Primes.
 * This class provides a method to count the number of prime numbers less than a
 * non-negative number, `n`.
 * The solution uses the Sieve of Eratosthenes algorithm.
 * <p>
 * Leetcode Link: <a href=
 * "https://leetcode.com/problems/count-primes/">https://leetcode.com/problems/count-primes/</a>
 */
public class CountPrimes {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(countPrimes(n));
    }

    /**
     * Counts the number of prime numbers less than a non-negative number, `n`.
     * This method implements the Sieve of Eratosthenes algorithm to efficiently
     * find all primes
     * up to a specified limit.
     * <p>
     * Time Complexity: O(n log log n) - The Sieve of Eratosthenes algorithm marks
     * multiples.
     * Space Complexity: O(n) - For the boolean array `isPrime` to store primality
     * information.
     *
     * @param n The upper limit (exclusive) to count prime numbers up to.
     * @return The total count of prime numbers less than `n`.
     */
    static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == true)
                count++;
        }

        return count;

    }
}
