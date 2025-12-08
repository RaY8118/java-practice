/**
 * Groups anagrams from a given array of strings.
 * This class provides a solution to LeetCode problem 49.
 *
 * Leetcode 49: https://leetcode.com/problems/group-anagrams/
 */
package com.dsa.algorithms.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    /**
     * Main method to demonstrate the groupAnagrams functionality.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strs).toString());
    }

    /**
     * Groups anagrams from a given array of strings.
     * Anagrams are words that contain the same characters in a different order.
     * The approach involves sorting each string to create a canonical representation
     * and using a HashMap to group strings with the same sorted representation.
     *
     * Time Complexity: O(N * K log K), where N is the number of strings and K is the length of the longest string.
     * Space Complexity: O(N * K), where N is the number of strings and K is the length of the longest string.
     *
     * @param strs The array of strings to group.
     * @return A list of lists, where each inner list contains strings that are anagrams of each other.
     */
    static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String word : strs) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedArray = new String(charArray);
            result.putIfAbsent(sortedArray, new ArrayList<>());
            result.get(sortedArray).add(word);
        }
        return new ArrayList<>(result.values());
    }
}