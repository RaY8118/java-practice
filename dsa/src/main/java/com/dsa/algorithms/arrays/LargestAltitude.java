package com.dsa.algorithms.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class provides a solution to the "Find the Highest Altitude" problem on
 * LeetCode.
 * <p>
 * LeetCode problem 1732:
 * https://leetcode.com/problems/find-the-highest-altitude/
 * <p>
 * It calculates the largest altitude reached during a bike ride given an array
 * of altitude gains.
 */
public class LargestAltitude {

    /**
     * The main method to test the largestAltitude function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] gain = { -5, 1, 5, 0, -7 };
        System.out.println(largestAltitude(gain));

        int[] gain2 = { -4, -3, -2, -1, 4, 3, 2 };
        System.out.println(largestAltitude(gain2));
    }

    /**
     * Calculates the largest altitude reached during a bike ride.
     *
     * @param gain An array of integers representing the altitude gain between
     *             points.
     * @return The highest altitude reached.
     */
    static int largestAltitude(int[] gain) {
        List<Integer> altitudes = new ArrayList<>(List.of(0));

        int sum = 0;
        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];
            altitudes.add(sum);
        }

        return Collections.max(altitudes);
    }
}
