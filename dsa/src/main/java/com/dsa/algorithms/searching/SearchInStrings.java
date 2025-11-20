package com.dsa.algorithms.searching;

/**
 * This class provides a method to search for a target character within a given string.
 * The search is case-insensitive.
 */
public class SearchInStrings {

    /**
     * Searches for a target character within a given string.
     * The search is case-insensitive, meaning 'A' will match 'a'.
     *
     * @param str The string to be searched.
     * @param target The character to search for.
     * @return {@code true} if the target character is found in the string, {@code false} otherwise.
     */
    static boolean search(String str, char target) {
        if (str.length() == 0) {
            return false;
        }

        for (char ch : str.toCharArray()) {
            if (Character.toLowerCase(ch) == Character.toLowerCase(target)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Main method to demonstrate the SearchInStrings functionality.
     * It searches for a target character in a sample string and prints the result.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        String name = "Parth";
        System.out.println(search(name, 'p'));
        System.out.println(search(name, 'o'));
    }
}
