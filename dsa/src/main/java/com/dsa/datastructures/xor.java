package com.dsa.datastructures;

public class xor {

    /**
     * Calculates the XOR sum of all elements in the given array.
     *
     * @param arr The input array of integers.
     * @return The XOR sum of the elements.
     * <p>
     * Time Complexity: O(n), where n is the length of the array.
     * Space Complexity: O(1)
     */
    public static int test(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum ^= arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {

        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 1, 2, 3, 4, 5, 6 };

        int res1 = test(arr1);
        System.out.println(res1);
        int res2 = test(arr2);
        System.out.println(res2);

        System.out.println(res1 ^ res2);

    }
}
