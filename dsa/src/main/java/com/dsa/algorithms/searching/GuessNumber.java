package com.dsa.algorithms.searching;

/**
 * This class provides a solution to the "Guess Number Higher or Lower" problem on
 * LeetCode.
 * <p>
 * LeetCode problem 374:
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 * <p>
 * It uses a binary search algorithm to guess a secret number within a given
 * range.
 */
public class GuessNumber {

    /**
     * The main method to test the guessNumber function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int n = 10;
        System.out.println(guessNumber(n));
    }

    /**
     * Finds the secret number using binary search.
     *
     * @param n The upper bound of the range in which to guess the number.
     * @return The secret number.
     */
    static int guessNumber(int n) {
        int min = 1;
        int max = n;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            int res = guess(mid);

            if (res == 0) {
                return mid;
            } else if (res < 0) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return -1;
    }

    /**
     * A mock of the guess API which tells if the secret number is higher or
     * lower.
     *
     * @param n The number to guess.
     * @return -1 if n is higher than the secret number, 1 if n is lower, and 0
     *         if n is equal to the secret number.
     */
    private static int guess(int n) {
        int res = 6;
        if (n > res) {
            return -1;
        } else if (n < res) {
            return 1;
        } else {
            return 0;
        }
    }
}
