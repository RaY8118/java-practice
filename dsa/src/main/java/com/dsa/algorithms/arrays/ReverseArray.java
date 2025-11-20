package com.dsa.algorithms.arrays;

import java.util.Arrays;

/**
 * This class provides methods to reverse an array.
 */
public class ReverseArray {

  /**
   * Reverses the given array and returns a new array with the elements in reverse
   * order.
   * This method does not modify the original array.
   *
   * @param arr The input array to be reversed.
   * @return A new array with elements in reverse order.
   *
   *         Time complexity: O(n), where n is the number of elements in the
   *         array.
   *         Space complexity: O(n) for the new array.
   *         Auxiliary space: O(1) (excluding the space for the result array).
   */
  public static int[] reverse(int[] arr) {
    int[] result = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      result[i] = arr[arr.length - 1 - i];
    }
    return result;
  }

  /**
   * Reverses the given array in place.
   * This method modifies the original array directly.
   *
   * @param arr The input array to be reversed.
   *
   *            Time complexity: O(n), where n is the number of elements in the
   *            array.
   *            Space complexity: O(1) as the reversal is done in place.
   *            Auxiliary space: O(1).
   */
  public static void reverseInPlace(int[] arr) {
    for (int i = 0; i < arr.length / 2; i++) {
      // Swap the element at the current index 'i' with the element at the
      // corresponding
      // position from the end of the array (arr.length - 1 - i).
      int temp = arr[i];
      arr[i] = arr[arr.length - 1 - i];
      arr[arr.length - 1 - i] = temp;
    }
  }

  /**
   * Main method to demonstrate the array reversal functionalities.
   * It creates an array, reverses it using both methods, and prints the results.
   *
   * @param args Command line arguments (not used).
   */
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5, 6 };

    System.out.println("Original array: " + Arrays.toString(arr));

    // Demonstrate reverse method (returns a new array)
    int[] reversedArr = reverse(arr);
    System.out.println("Reversed array (new array): " + Arrays.toString(reversedArr));

    System.out.println();

    // Demonstrate reverseInPlace method (modifies original array)
    System.out.println("Array before in-place reversal: " + Arrays.toString(arr));
    reverseInPlace(arr);
    System.out.println("Array after in-place reversal: " + Arrays.toString(arr));
  }
}
