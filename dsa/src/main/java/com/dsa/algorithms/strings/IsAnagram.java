/**
 * Checks if one string is an anagram of another.
 * This class provides a solution to LeetCode problem 242.
 *
 * Leetcode 242: https://leetcode.com/problems/valid-anagram/
 */
package com.dsa.algorithms.strings;

import java.util.HashMap;

public class IsAnagram {
    /**
     * Main method to demonstrate the isAnagram functionality.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));

        String s2 = "rat";
        String t2 = "car";
        System.out.println(isAnagram(s2, t2));
    }

    /**
     * Determines if string t is an anagram of string s.
     * An anagram is formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     * This method uses HashMaps to count the frequency of each character in both strings.
     *
     * Time Complexity: O(L), where L is the length of the strings (assuming they have equal length).
     * Space Complexity: O(1), assuming a fixed-size character set (e.g., 26 lowercase English letters).
     *
     * @param s The first string.
     * @param t The second string.
     * @return true if t is an anagram of s, false otherwise.
     */
    static boolean isAnagram(String s, String t) {
        // Pre-condition: If lengths are different, they cannot be anagrams.
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        HashMap<Character, Integer> sSorted = new HashMap<>();
        HashMap<Character, Integer> tSorted = new HashMap<>();

        for (char c : sArray) {
            sSorted.put(c, sSorted.getOrDefault(c, 0) + 1);
        }

        for (char c : tArray) {
            tSorted.put(c, tSorted.getOrDefault(c, 0) + 1);
        }

        return sSorted.equals(tSorted);
    }
}