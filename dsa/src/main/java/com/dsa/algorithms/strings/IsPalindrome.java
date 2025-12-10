package com.dsa.algorithms.strings;


/**
 * Checks if a given string is a valid palindrome, considering only alphanumeric
 * characters and ignoring cases.
 * <p>
 * This solution corresponds to LeetCode problem 125: Valid Palindrome.
 * https://leetcode.com/problems/valid-palindrome/
 */
public class IsPalindrome {
    /**
     * Main method to demonstrate the isPalindrome functionality.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

        String s2 = "race a car";
        System.out.println(isPalindrome(s2));
    }

    /**
     * Checks if a string is a palindrome after cleaning it of non-alphanumeric characters.
     * <p>
     * Time Complexity: O(n), where n is the length of the string. This is because cleaning the string takes O(n) and the two-pointer check takes O(n/2).
     * <p>
     * Space Complexity: O(n), where n is the length of the string, due to the new string created by `cleanString`.
     *
     * @param s The input string to check.
     * @return {@code true} if the string is a palindrome, {@code false} otherwise.
     */
    static boolean isPalindrome(String s) {
        String cleanStr = cleanString(s);
        int i = 0;
        int j = cleanStr.length() - 1;

        while (i < cleanStr.length() / 2) {
            if (cleanStr.charAt(i) != cleanStr.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * Cleans a string by removing non-alphanumeric characters and converting to lowercase.
     *
     * @param s The input string.
     * @return A new string containing only the alphanumeric characters of the original string, in lowercase.
     */
    static String cleanString(String s) {
        StringBuilder str = new StringBuilder();

        for (Character letter : s.toCharArray()) {
            if (Character.isAlphabetic(letter) || Character.isDigit(letter)) {
                str.append(Character.toLowerCase(letter));
            } else {
                str.append("");
            }
        }

        return str.toString();
    }
}
