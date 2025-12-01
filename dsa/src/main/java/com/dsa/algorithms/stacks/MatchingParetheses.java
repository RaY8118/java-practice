package com.dsa.algorithms.stacks;

import java.util.Stack;

/**
 * This class provides a method to check if a given string has matching parentheses.
 * It utilizes a Stack data structure to keep track of opening parentheses.
 *
 * DSA Topics: Stacks, Strings, Iteration
 */
public class MatchingParetheses {

    /**
     * Checks if a given string has matching parentheses.
     * It uses a stack to keep track of opening parentheses.
     * <p>
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(n), where n is the length of the string (in the worst case).
     *
     * @param s The input string to check for matching parentheses.
     * @return true if the parentheses in the string are matching, false otherwise.
     */
    public static boolean hasMatchinngParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(') {
                stack.push(current);
            } else if (current == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(hasMatchinngParentheses("(algorithm())"));
        System.out.println(hasMatchinngParentheses(")(algorithm"));
    }
}
