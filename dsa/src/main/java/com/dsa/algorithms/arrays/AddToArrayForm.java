package com.dsa.algorithms.arrays;

// Leetcode 989
// https://leetcode.com/problems/add-to-array-form-of-integer/
import java.util.LinkedList;
import java.util.List;

/**
 * Solution for Leetcode problem 989: Add to Array-Form of Integer.
 * <p>
 * Given an array A of non-negative integers representing the digits of an integer,
 * for example, [1,2,3] represents the integer 123, and an integer K, return the
 * array-form of the sum of the integer represented by A and K.
 * The result is also represented in its array-form.
 *
 * @see <a href="https://leetcode.com/problems/add-to-array-form-of-integer/">Leetcode 989</a>
 */
public class AddToArrayForm {
    public static void main(String[] args) {
        int[] num = { 1, 2, 0, 0 };
        int k = 34;
        System.out.println(addToArrayForm(num, k).toString());

        int[] num2 = { 2, 1, 5 };
        int k2 = 806;
        System.out.println(addToArrayForm(num2, k2).toString());
    }

    /**
     * Adds an integer K to the array-form of an integer represented by `num`.
     *
     * Time Complexity: O(max(N, log K)), where N is the length of `num` and log K
     * is the number of digits in K. This is because we iterate through the digits
     * of both `num` and `K` at most.
     * Space Complexity: O(max(N, log K)) to store the result.
     *
     * @param num The array-form of the integer.
     * @param k The integer to add.
     * @return The array-form of the sum.
     */
    static List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> result = new LinkedList<>();

        int i = num.length - 1;
        int carry = 0;

        while (i >= 0 || k > 0 || carry != 0) {
            int digitNum = i >= 0 ? num[i] : 0;
            int digitK = k % 10;

            int sum = digitNum + digitK + carry;

            result.addFirst(sum % 10);
            carry = sum / 10;

            k /= 10;
            i--;
        }

        return result;
    }
}