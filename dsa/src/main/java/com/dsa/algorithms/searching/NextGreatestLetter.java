package com.dsa.algorithms.searching;

/**
 * This class provides a solution to the "Find Smallest Letter Greater Than Target" problem on LeetCode.
 * <p>
 * LeetCode problem 744:
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 * <p>
 * Given a characters array letters that is sorted in non-decreasing order and a character target,
 * return the smallest character in the array that is larger than target.
 * Note that the letters wrap around.
 * For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
 */
public class NextGreatestLetter {
    /**
     * The main method to test the nextGreatestLetter function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        char[] letters = { 'c', 'f', 'j' };
        char target = 'a';
        System.out.println(nextGreatestLetter(letters, target));
    }

    /**
     * Finds the smallest character in the array that is larger than target.
     *
     * @param letters The characters array, sorted in non-decreasing order.
     * @param target  The target character.
     * @return The smallest character in the array that is larger than target.
     */
    static char nextGreatestLetter(char[] letters, char target) {
        int min = 0;
        int max = letters.length - 1;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (target < letters[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return letters[min % letters.length];
    }
}
