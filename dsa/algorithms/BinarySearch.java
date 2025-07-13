/**
 * This class implements the Binary Search algorithm.
 * Binary Search is an efficient algorithm for finding an item from a sorted
 * list of items.
 * It works by repeatedly dividing in half the portion of the list that could
 * contain the item,
 * until the item is found or the possible remaining locations are eliminated.
 */
public class BinarySearch {

  /**
   * Searches for a specified item in a sorted integer array using the Binary
   * Search algorithm.
   *
   * @param arr  The sorted array to be searched.
   * @param item The item to search for.
   * @return {@code true} if the item is found in the array, {@code false}
   *         otherwise.
   *
   *         Time Complexity: O(log n), where n is the number of elements in the
   *         array.
   *         This is because the search space is halved in each iteration.
   *         Space Complexity: O(1), as it uses a constant amount of extra space
   *         regardless of the input size.
   */
  public static boolean binarySearch(int[] arr, int item) {
    int min = 0;
    int max = arr.length - 1;

    while (min <= max) {
      int mid = min + (max - min) / 2; // To prevent potential integer overflow
      if (item == arr[mid]) {
        return true;
      } else if (item < arr[mid]) {
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }
    return false;
  }

  /**
   * Main method to demonstrate the Binary Search functionality.
   * It searches for various elements in a sample sorted array and prints the
   * results.
   *
   * @param args Command line arguments (not used).
   */
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5, 6 };
    System.out.println("Array: " + java.util.Arrays.toString(arr));

    int searchItem1 = 3;
    System.out.println("Is " + searchItem1 + " in array? " + binarySearch(arr, searchItem1)); // Expected: true

    int searchItem2 = 1;
    System.out.println("Is " + searchItem2 + " in array? " + binarySearch(arr, searchItem2)); // Expected: true

    int searchItem3 = 7;
    System.out.println("Is " + searchItem3 + " in array? " + binarySearch(arr, searchItem3)); // Expected: false

    int searchItem4 = 6;
    System.out.println("Is " + searchItem4 + " in array? " + binarySearch(arr, searchItem4)); // Expected: true

    int searchItem5 = 0;
    System.out.println("Is " + searchItem5 + " in array? " + binarySearch(arr, searchItem5)); // Expected: false
  }
}
