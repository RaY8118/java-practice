package com.dsa.algorithms.arrays;

import java.util.List;

/**
 * This class provides a solution to the "Count Items Matching a Rule" problem
 * on LeetCode.
 * <p>
 * LeetCode problem 1773:
 * https://leetcode.com/problems/count-items-matching-a-rule/
 * <p>
 * It counts the number of items that match a given rule.
 */
public class CountMatches {

    /**
     * The main method to test the countMatches function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        List<List<String>> items = List.of(List.of("phone", "blue", "pixel"),
                List.of("computer", "silver", "lenovo"));
        String ruleKey = "color";
        String ruleValues = "silver";

        System.out.println(countMatches(items, ruleKey, ruleValues));
    }

    /**
     * Counts the number of items that match a given rule.
     *
     * @param items     A list of items, where each item is a list of strings
     *                  representing [type, color, name].
     * @param ruleKey   The key to match, which can be "type", "color", or "name".
     * @param ruleValue The value to match for the given ruleKey.
     * @return The number of items that match the rule.
     */
    static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int index;
        if (ruleKey.equals("type")) {
            index = 0;
        } else if (ruleKey.equals("color")) {
            index = 1;
        } else {
            index = 2;
        }

        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue)) {
                count++;
            }
        }

        return count;
    }
}
