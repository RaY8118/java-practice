package com.dsa.algorithms;

/**
 * This class provides methods to reverse individual words within a sentence
 * and to reverse a string.
 */
public class ReverseWords {

  /**
   * Reverses a given string.
   *
   * @param s The input string to be reversed.
   * @return The reversed string.
   *
   *         Time Complexity: O(n), where n is the length of the string.
   *         Each character is appended once to the StringBuilder.
   *         Space Complexity: O(n), for the StringBuilder used to store the
   *         reversed string.
   */
  public static String reverse(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
      sb.append(s.charAt(i));
    }
    return sb.toString();
  }

  /**
   * Reverses each word in a given sentence while maintaining the order of the
   * words.
   * Words are separated by spaces.
   *
   * @param sentence The input sentence whose words are to be reversed.
   * @return A new string with each word reversed.
   *
   *         Time Complexity: O(L), where L is the total number of characters in
   *         the sentence.
   *         This includes splitting the sentence and reversing each word.
   *         Space Complexity: O(L), for storing the array of words and the result
   *         StringBuilder.
   */
  public static String reverseWords(String sentence) {
    StringBuilder result = new StringBuilder();
    // Split the sentence into individual words based on spaces.
    String[] words = sentence.split(" ");
    for (String word : words) {
      // Reverse each word and append it to the result.
      result.append(reverse(word));
      // Append a space after each word to maintain separation.
      result.append(" ");
    }
    // Remove any trailing space if present.
    // Note: trimToSize() only reduces the capacity, not the content. Use trim() for
    // content.
    return result.toString().trim();
  }

  /**
   * Main method to demonstrate the word reversal functionality.
   * It takes a sample sentence, reverses its words, and prints the result.
   *
   * @param args Command line arguments (not used).
   */
  public static void main(String[] args) {
    String s = "sally is a great worker";
    System.out.println("Original sentence: " + s);
    String result = reverseWords(s);
    System.out.println("Sentence with reversed words: " + result);
  }
}
