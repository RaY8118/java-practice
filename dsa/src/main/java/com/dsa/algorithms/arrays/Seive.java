package com.dsa.algorithms.arrays;

/**
 * Implements the Sieve of Eratosthenes algorithm to find all prime numbers up to a given limit.
 * This class provides a method to demonstrate the generation of prime numbers.
 */
public class Seive {
    public static void main(String[] args) {
        seive(1000);
    }

    /**
     * Prints all prime numbers up to a given integer `n` using the Sieve of Eratosthenes algorithm.
     * The algorithm works by iteratively marking as composite (i.e., not prime) the multiples
     * of each prime, starting with the first prime number, 2. The unmarked numbers remaining
     * are the prime numbers.
     * <p>
     * Time Complexity: O(n log log n) - The primary loop runs up to sqrt(n), and marking multiples
     * for each prime contributes to this complexity.
     * Space Complexity: O(n) - For the boolean array `isPrime` which stores whether each number
     * up to `n` is prime or not.
     *
     * @param n The upper limit (inclusive) up to which prime numbers should be found and printed.
     */
    static void seive(int n) {
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

        for (int i = 2; i <= n; i++) {
            if (isPrime[i] == true)
                System.out.print(i + " ");
        }

    }
}

