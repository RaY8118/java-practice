package com.dsa.algorithms.stacks;

import java.util.Stack;

public class MatchingParetheses {

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
