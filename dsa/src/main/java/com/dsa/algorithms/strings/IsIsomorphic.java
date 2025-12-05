package com.dsa.algorithms.strings;

import java.util.HashMap;

/**
 * Implements the solution for checking if two strings are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to
 * get t.
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters.
 * No two characters may map to the same character, but a character may map to
 * itself.
 * <p>
 * LeetCode 205: Isomorphic Strings
 * <a href="https://leetcode.com/problems/isomorphic-strings/">Problem Link</a>
 */
public class IsIsomorphic {
    /**
     * Main method to demonstrate the isIsomorphic functionality.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s, t));

        String s2 = "foo";
        String t2 = "bar";
        System.out.println(isIsomorphic(s2, t2));
    }

    /**
     * Determines if two strings are isomorphic.
     * Uses two HashMaps to track the mapping from s to t and t to s to ensure
     * bijection.
     * <p>
     * Time Complexity: O(n) where n is the length of the strings
     * Space Complexity: O(1) since the character set is limited (ASCII)
     *
     * @param s The first string.
     * @param t The second string.
     * @return true if the strings are isomorphic, false otherwise.
     */
    static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (mapST.containsKey(c1)) {
                if (mapST.get(c1) != c2) {
                    return false;
                }
            } else {
                mapST.put(c1, c2);
            }

            if (mapTS.containsKey(c2)) {
                if (mapTS.get(c2) != c1) {
                    return false;
                }
            } else {
                mapTS.put(c2, c1);
            }
        }

        return true;
    }
}
