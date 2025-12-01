package com.dsa.algorithms.arrays;

// Leetcode 1295
// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

/**
 * This class provides a solution to find the number of integers in an array that have an even
 * number of digits.
 *
 * DSA Topics: Arrays, Mathematics, Counting, Iteration
 */
public class FindNumbers {
  public static void main(String[] args) {
    int[] nums = {12, 345, 2, 6, 7896};
    int ans = findNumbers(nums);
    System.out.println(ans);
  }

  /**
   * Given an array of integers, returns how many of them contain an even number of digits.
   *
   * <p>
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   *
   * @param nums The input array of integers.
   * @return The count of numbers with an even number of digits.
   */
  static int findNumbers(int[] nums) {
    int count = 0;
    for (int num : nums) {
      if (even(num)) {
        count++;
      }
    }
    return count;
  }

  /**
   * Checks if a number has an even number of digits.
   *
   * @param num The input integer.
   * @return {@code true} if the number has an even number of digits, {@code false} otherwise.
   */
  static boolean even(int num) {
    int numberOfDigits = digits2(num);
    return numberOfDigits % 2 == 0;
  }

  /**
   * Calculates the number of digits in an integer.
   *
   * @param num The input integer.
   * @return The number of digits in the integer.
   */
  static int digits(int num) {
    int count = 0;

    while (num > 0) {
      count++;
      num /= 10;
    }

    return count;
  }

  /**
   * Calculates the number of digits in an integer using a mathematical approach.
   *
   * @param num The input integer.
   * @return The number of digits in the integer.
   */
  static int digits2(int num) {
    if (num < 0) {
      num = num * -1;
    }
    return (int) (Math.log10(num) + 1);
  }
}
