package com.dsa.algorithms.miscellaneous;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class provides a method to print the first 'n' binary numbers.
 * It utilizes a Queue data structure to generate binary numbers in a breadth-first manner.
 *
 * DSA Topics: Queues, Iteration, Number Theory
 */
public class BinaryNumbers {

    /**
     * Prints the first 'n' binary numbers.
     * It uses a Queue to generate binary numbers in a breadth-first manner.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param n The number of binary numbers to print.
     */
    public static void printBinary(int n) {
        if (n <= 0) {
            System.out.println();
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        for (int i = 0; i < n; i++) {
            int current = queue.remove();
            System.out.println(current);

            queue.add(current * 10);
            queue.add(current * 10 + 1);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printBinary(8);
    }
}
