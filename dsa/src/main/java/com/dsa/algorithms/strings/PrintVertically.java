package com.dsa.algorithms.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements a solution to Leetcode Problem 1324: Print Words Vertically.
 * This class provides a method to rearrange words from a given string into a
 * vertical format.
 * <p>
 * Leetcode Link: <a href=
 * "https://leetcode.com/problems/print-words-vertically/">https://leetcode.com/problems/print-words-vertically/</a>
 */
public class PrintVertically {
    public static void main(String[] args) {
        String s = "TO BE OR NOT TO BE";
        System.out.println(printVertically(s).toString());
    }

    /**
     * Given a string `s`, arranges its words vertically.
     * The words are arranged such that the i-th column in the new arrangement
     * is formed by the i-th character of all words, followed by spaces if a word
     * is shorter than the maximum length, and trailing spaces are removed.
     * <p>
     * For example, "TO BE OR NOT TO BE" would be printed as:
     * T B O N T B
     * O E R O O E
     * &nbsp; &nbsp; &nbsp; T &nbsp; &nbsp;
     * <p>
     * Time Complexity: O(L * W), where L is the maximum length of a word in the
     * input string
     * and W is the number of words in the input string.
     * Space Complexity: O(L * W), for the intermediate matrix used to store
     * characters
     * and the resulting list of strings.
     *
     * @param s The input string containing words separated by single spaces.
     * @return A list of strings, where each string represents a row in the
     *         vertically printed words.
     */
    static List<String> printVertically(String s) {
        String[] strArray = s.split(" ");

        int maxLen = strArray[0].length();

        for (String str : strArray) {
            if (maxLen < str.length()) {
                maxLen = str.length();
            }
        }

        String[][] mat = new String[maxLen][strArray.length];

        for (int row = 0; row < maxLen; row++) {
            for (int col = 0; col < strArray.length; col++) {
                if (row < strArray[col].length()) {
                    mat[row][col] = Character.toString(strArray[col].charAt(row));
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (int row = 0; row < maxLen; row++) {
            StringBuilder word = new StringBuilder();
            for (int col = 0; col < strArray.length; col++) {
                if (mat[row][col] != null) {
                    word.append(mat[row][col]);
                } else {
                    word.append(" ");
                }
            }
            result.add(word.toString().replaceAll("\\s+$", ""));
        }

        return result;

    }
}
