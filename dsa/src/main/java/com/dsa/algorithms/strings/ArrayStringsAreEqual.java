package com.dsa.algorithms.strings;

/**
 * Leetcode 1662: Check If Two String Arrays are Equivalent
 * Given two string arrays `word1` and `word2`, return `true` if the two arrays
 * represent the same string, and `false` otherwise.
 *
 * A string is represented by an array if the array elements concatenated in
 * order form the string.
 */
public class ArrayStringsAreEqual {
    public static void main(String[] args) {
        String[] word1 = { "ab", "c" };
        String[] word2 = { "a", "bc" };

        System.out.println(arrayStringsAreEqual(word1, word2));
    }

    /**
     * Checks if two string arrays are equivalent by concatenating them and
     * comparing the resulting strings.
     * <p>
     * Time Complexity: O(L1 + L2), where L1 and L2 are the total lengths of strings
     * in word1 and word2, respectively.
     * Space Complexity: O(L1 + L2), for storing the concatenated strings in
     * StringBuilder.
     *
     * @param word1 The first array of strings.
     * @param word2 The second array of strings.
     * @return True if the concatenated strings are equal, false otherwise.
     */
    static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        for (String letter : word1) {
            sb1.append(letter);
        }

        StringBuilder sb2 = new StringBuilder();
        for (String letter : word2) {
            sb2.append(letter);
        }

        return sb1.toString().equals(sb2.toString());
    }

    /**
     * Checks if two string arrays are equivalent using a two-pointer approach
     * without explicit concatenation.
     * <p>
     * Time Complexity: O(L), where L is the length of the shorter concatenated
     * string.
     * Space Complexity: O(1).
     *
     * @param word1 The first array of strings.
     * @param word2 The second array of strings.
     * @return True if the concatenated strings are equal, false otherwise.
     */
    static boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        int i1 = 0, j1 = 0, i2 = 0, j2 = 0;

        while (i1 < word1.length && i2 < word2.length) {
            if (word1[i1].charAt(j1) != word2[i2].charAt(j2)) {
                return false;
            }

            j1++;
            j2++;

            if (j1 == word1[i1].length()) {
                i1++;
                j1 = 0;
            }

            if (j2 == word2[i2].length()) {
                i2++;
                j2 = 0;
            }
        }

        return i1 == word1.length && i2 == word2.length;
    }
}
