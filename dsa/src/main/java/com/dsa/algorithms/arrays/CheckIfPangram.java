package com.dsa.algorithms.arrays;

import java.util.HashSet;

/**
 * This class provides a solution to the "Check if the Sentence Is Pangram"
 * problem on LeetCode.
 * <p>
 * LeetCode problem 1832:
 * https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 * <p>
 * It determines if a given sentence contains every letter of the English
 * alphabet.
 */
public class CheckIfPangram {

    /**
     * The main method to test the checkIfPangram function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram(sentence));
    }

    /**
     * Checks if a sentence is a pangram.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param sentence The sentence to check.
     * @return True if the sentence is a pangram, false otherwise.
     */
    static boolean checkIfPangram(String sentence) {
        HashSet<Character> charSet = new HashSet<>();
        for (Character character : sentence.toCharArray()) {
            charSet.add(character);
        }

        return charSet.size() == 26;
    }
}
