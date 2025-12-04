package com.dsa.algorithms.strings;

/**
 * Solution for Leetcode 1678: Goal Parser Interpretation.
 * You own a Goal Parser that can interpret a string `command`.
 * The `command` consists of three types of primitive strings: "G", "()" and
 * "(al)".
 * The Goal Parser interprets "G" as the string "G".
 * The Goal Parser interprets "()" as the string "o".
 * The Goal Parser interprets "(al)" as the string "al".
 * The interpreted strings are then concatenated in the original order.
 * Given a string `command`, return the Goal Parser's interpretation of
 * `command`.
 *
 * Problem Link:
 * <a href="https://leetcode.com/problems/goal-parser-interpretation/">Leetcode
 * 1678 - Goal Parser Interpretation</a>
 */
public class Interpret {
    /**
     * Main method to demonstrate the interpret function.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        String command = "G()(al)";
        System.out.println(interpret(command));

        String command2 = "G()()()()(al)";
        System.out.println(interpret(command2));
    }

    /**
     * Interprets a given command string according to Goal Parser rules.
     * The command consists of "G", "()" and "(al)".
     * "G" is interpreted as "G".
     * "()" is interpreted as "o".
     * "(al)" is interpreted as "al".
     * <p>
     * Time Complexity: O(N), where N is the length of the input string `command`.
     * The method iterates through the string once.
     * Space Complexity: O(N), where N is the length of the input string `command`.
     * A new StringBuilder is created to store the interpreted string.
     *
     * @param command The string command to interpret.
     * @return The interpreted string.
     */
    static String interpret(String command) {
        char[] charArray = command.toCharArray();
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < command.length()) {
            if (charArray[i] == 'G') {
                result.append('G');
                i++;
            } else if (charArray[i] == '(' && charArray[i + 1] == ')') {
                result.append('o');
                i += 2;
            } else {
                result.append("al");
                i += 4;
            }
        }

        return result.toString();
    }
}
