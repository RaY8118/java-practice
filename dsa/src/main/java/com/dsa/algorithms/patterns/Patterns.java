package com.dsa.algorithms.patterns;

/**
 * Implements various patterns to be printed.
 * This class provides a method for printing patterns and a main method to
 * demonstrate its usage.
 */
public class Patterns {
    /*
     * P
     * Main method to demonstrate the patterns.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        pattern1(4);
        pattern2(4);
        pattern3(4);
        pattern4(4);
    }

    /**
     * Prints a square pattern of stars.
     *
     * @param n The number of rows and columns.
     */
    static void pattern1(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /**
     * Prints a right-angled triangle pattern of stars.
     *
     * @param n The number of rows.
     */
    static void pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /**
     * Prints an inverted right-angled triangle pattern of stars.
     *
     * @param n The number of rows.
     */
    static void pattern3(int n) {
        for (int row = n; row >= 1; row--) {
            for (int col = row; col >= 1; col--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /**
     * Prints a right-angled triangle pattern of numbers.
     *
     * @param n The number of rows.
     */
    static void pattern4(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
