package com.dsa.datastructures;

import java.util.Arrays;

/**
 * This class provides a basic demonstration of how to declare, initialize,
 * and iterate over arrays in Java. It covers both single-dimensional arrays
 * and uses utility methods from `java.util.Arrays`.
 * <p>
 * This class primarily showcases basic language features related to arrays
 * rather than implementing a specific algorithm or data structure.
 * <p>
 * Typical complexities for operations demonstrated:
 * <ul>
 *     <li>Array declaration and initialization: O(1) time, O(N) space (where N is array size).</li>
 *     <li>Element assignment/access: O(1) time.</li>
 *     <li>Iteration (for-loop, for-each loop): O(N) time, O(1) auxiliary space.</li>
 *     <li>`Arrays.toString()`: O(N) time, O(N) space for the resulting string.</li>
 *     <li>`Arrays.stream().forEach()`: O(N) time.</li>
 * </ul>
 */
public class Array {
    public static void main(String[] args) {
        String[] arr = new String[4];
        arr[0] = "one";
        arr[1] = "two";
        arr[2] = "three";
        arr[3] = "four";

        System.out.println(Arrays.toString(arr));
        int[] numbers = { 100, 200, 300 };
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        for (int num : numbers) {
            System.out.println(num);
        }

        Arrays.stream(arr).forEach(System.out::println);
    }
}
