package com.dsa.algorithms.miscellaneous;

import java.util.Stack;

/**
 * This class provides a method to find and print the next greater element for each element in an array.
 * It utilizes a Stack data structure to efficiently determine the next greater elements.
 *
 * DSA Topics: Arrays, Stacks, Iteration
 */
public class NextGreater {

    public static void printNextGreater(int[] arr) {
        if (arr.length == 0) {
            System.out.println();
            return;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int next = arr[i];
            if (!stack.isEmpty()) {
                int popped = stack.pop();
                while (popped < next) {
                    System.out.println(popped + " --> " + next);
                    if (stack.isEmpty()) {
                        break;
                    }
                    popped = stack.pop();
                }

                if (popped > next) {
                    stack.push(popped);
                }
            }
            stack.push(next);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " --> " + -1);
        }
    }

    public static void main(String[] args) {
        printNextGreater(new int[] { 16, 7, 2, 15 });
    }
}
