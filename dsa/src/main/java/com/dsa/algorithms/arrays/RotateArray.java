package com.dsa.algorithms.arrays;

/**
 * This class provides a method to rotate an array to the left by one position.
 *
 * DSA Topics: Arrays, Iteration
 */
public class RotateArray {

  /**
   * Rotates the given integer array to the left by one position.
   * The first element becomes the last element.
   *
   * @param numbers The array of integers to be rotated.
   * @return A new array with the elements rotated to the left by one position.
   */
  public static int[] rotateArray(int[] numbers) {
    int[] rotated = new int[numbers.length];
    for (int i = 1; i < numbers.length; i++) {
      rotated[i - 1] = numbers[i];
    }
    rotated[rotated.length - 1] = numbers[0];
    return rotated;
  }

  /**
   * Main method to demonstrate the rotateArray function.
   * It initializes an array, rotates it, and prints the rotated array.
   *
   * @param args Command line arguments (not used).
   */
  public static void main(String[] args) {
    int[] numbers = { 1, 2, 3, 4, 5 };
    int[] rotated = rotateArray(numbers);
    for (int i = 0; i < rotated.length; i++) {
      System.out.print(rotated[i] + " ");
    }
    System.out.println();
  }
}
