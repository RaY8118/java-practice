package com.dsa.algorithms.strings;

/**
 * Leetcode 709: To Lower Case
 * Implements a function that converts a given string to its lowercase equivalent.
 *
 * Problem:
 * Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.
 * https://leetcode.com/problems/to-lower-case/
 */
public class ToLowerCase {

    public static void main(String[] args) {

    }

    /**
     * Converts all uppercase letters in the input string to lowercase letters.
     * Non-alphabetic characters and already lowercase characters remain unchanged.
     * <p>
     * Time Complexity: O(n), where n is the length of the input string.
     *                  This is because each character in the string is processed once.
     * Space Complexity: O(n), where n is the length of the input string.
     *                   This is due to the use of a StringBuilder to construct the new string.
     *
     * @param s The input string to convert to lowercase.
     * @return The string with all uppercase letters converted to lowercase.
     */
    public static String toLowerCase(String s) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                result.append((char) (c + 32));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
