package com.dsa.algorithms;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * This class provides methods to perform linear search on an array.
 * Linear search is a simple search algorithm that sequentially checks each
 * element
 * of the list until a match is found or the whole list has been searched.
 */
public class LinearSearch {

  /**
   * Performs a linear search to find a specified item in an integer array.
   *
   * @param arr  The array to be searched.
   * @param item The item to search for.
   * @return The item if found, otherwise -1.
   *
   *         Time Complexity: O(n), where n is the number of elements in the
   *         array.
   *         In the worst case, the entire array must be traversed.
   *         Space Complexity: O(1), as it uses a constant amount of extra space.
   */
  public static Integer linearSearch(int[] arr, int item) {
    for (int a : arr) {
      if (a == item) {
        return item;
      }
    }
    return -1;
  }

  /**
   * Performs a linear search using Java Stream API to find a specified item in an
   * integer array.
   * This method returns an {@code OptionalInt} which will contain the item if
   * found,
   * or be empty if the item is not present.
   *
   * @param arr  The array to be searched.
   * @param item The item to search for.
   * @return An {@code OptionalInt} containing the item if found, otherwise an
   *         empty {@code OptionalInt}.
   *
   *         Time Complexity: O(n), where n is the number of elements in the
   *         array.
   *         Space Complexity: O(n) in some stream implementations due to
   *         intermediate operations,
   *         though effectively O(1) for simple filtering and finding the first
   *         element.
   */
  public static OptionalInt linearSearch2(int[] arr, int item) {
    return Arrays.stream(arr).filter(x -> x == item).findFirst();
  }

  /**
   * Main method to demonstrate the linear search functionalities.
   * It searches for various elements in a sample array and prints the results.
   *
   * @param args Command line arguments (not used).
   */
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5 };
    System.out.println("Array: " + Arrays.toString(arr));

    int item1 = 3;
    System.out.println("Using linearSearch: Is " + item1 + " found? " + (linearSearch(arr, item1) != -1 ? "Yes" : "No")
        + " (Result: " + linearSearch(arr, item1) + ")");

    int item2 = 6;
    System.out.println("Using linearSearch: Is " + item2 + " found? " + (linearSearch(arr, item2) != -1 ? "Yes" : "No")
        + " (Result: " + linearSearch(arr, item2) + ")");

    int item3 = 4;
    System.out.print("Using linearSearch2: Is " + item3 + " found? ");
    linearSearch2(arr, item3).ifPresentOrElse(
        val -> System.out.println("Yes (Result: " + val + ")"),
        () -> System.out.println("No"));

    int item4 = 0;
    System.out.print("Using linearSearch2: Is " + item4 + " found? ");
    linearSearch2(arr, item4).ifPresentOrElse(
        val -> System.out.println("Yes (Result: " + val + ")"),
        () -> System.out.println("No"));
  }
}
