package com.dsa.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution to the "Kids with the Greatest Number of
 * Candies" problem on LeetCode.
 * <p>
 * LeetCode problem 1431:
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 * <p>
 * It determines which kids will have the greatest number of candies if they are
 * given some extra candies.
 */
public class KidsWithCandies {

    /**
     * The main method to test the kidsWithCandies function.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        int[] candies = { 2, 3, 5, 1, 3 };
        int extraCandies = 3;
        System.out.println(kidsWithCandies(candies, extraCandies));

        int[] candies2 = { 4, 2, 1, 1, 2 };
        int extraCandies2 = 1;
        System.out.println(kidsWithCandies(candies2, extraCandies2));
    }

    /**
     * Determines which kids will have the greatest number of candies after
     * receiving extra candies.
     *
     * @param candies      An array of integers representing the number of candies
     *                     each kid has.
     * @param extraCandies The number of extra candies to be given to each kid.
     * @return A list of booleans, where each element at index i is true if the i-th
     *         kid will have the
     *         greatest number of candies after receiving extra candies, and false
     *         otherwise.
     */
    static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> boolArray = new ArrayList<>();

        for (int candy : candies) {
            if (candy + extraCandies >= maxCandies(candies)) {
                boolArray.add(true);
            } else {
                boolArray.add(false);
            }
        }
        return boolArray;
    }

    /**
     * Finds the maximum number of candies any kid has.
     *
     * @param candies An array of integers representing the number of candies each
     *                kid has.
     * @return The maximum number of candies.
     */
    private static int maxCandies(int[] candies) {
        int maxCandy = candies[0];
        for (int candy : candies) {
            if (candy > maxCandy) {
                maxCandy = candy;
            }
        }

        return maxCandy;
    }
}
