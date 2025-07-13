import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

/**
 * This class provides methods to find even numbers from one or more integer arrays.
 */
public class FindEvenNums {

  /**
   * Finds all even numbers from two given integer arrays and returns them as a new array.
   * This method iterates through both arrays and collects even numbers.
   *
   * @param arr1 The first input array.
   * @param arr2 The second input array.
   * @return A new array containing all even numbers from both input arrays.
   *
   * Time Complexity: O(n + m), where n is the length of arr1 and m is the length of arr2.
   * Space Complexity: O(k), where k is the number of even numbers found (in the worst case, k = n + m).
   */
  public static int[] findEvenNums(int[] arr1, int[] arr2) {
    ArrayList<Integer> result = new ArrayList<>();

    for (int num : arr1) {
      if (num % 2 == 0) {
        result.add(num);
      }
    }

    for (int num : arr2) {
      if (num % 2 == 0) {
        result.add(num);
      }
    }

    return result.stream().mapToInt(Integer::intValue).toArray();
  }

  /**
   * Finds all even numbers from two given integer arrays using Java Streams and returns them as a new array.
   * This method provides a more concise way to achieve the same result as {@code findEvenNums}.
   *
   * @param arr1 The first input array.
   * @param arr2 The second input array.
   * @return A new array containing all even numbers from both input arrays.
   *
   * Time Complexity: O(n + m), where n is the length of arr1 and m is the length of arr2.
   * Space Complexity: O(k), where k is the number of even numbers found (in the worst case, k = n + m).
   */
  public static int[] findEvenNums2(int[] arr1, int[] arr2) {
    IntPredicate isEvenPred = num -> num % 2 == 0;
    return Stream.of(arr1, arr2)
        .flatMapToInt(Arrays::stream)
        .filter(isEvenPred)
        .toArray();
  }

  /**
   * Main method to demonstrate the functionality of finding even numbers.
   * It initializes two arrays and uses both {@code findEvenNums} and {@code findEvenNums2}
   * to find and print the even numbers.
   *
   * @param args Command line arguments (not used).
   */
  public static void main(String[] args) {
    int[] arr1 = { -9, 3, 2, -8, 12, -16 };
    int[] arr2 = { 0, -3, -8, -35, 40, 20, 7 };

    System.out.println("Array 1: " + Arrays.toString(arr1));
    System.out.println("Array 2: " + Arrays.toString(arr2));

    System.out.println("\nEven numbers using findEvenNums:");
    Arrays.stream(findEvenNums(arr1, arr2))
        .forEach(System.out::println);

    System.out.println("\nEven numbers using findEvenNums2:");
    Arrays.stream(findEvenNums2(arr1, arr2))
        .forEach(System.out::println);
  }
}

