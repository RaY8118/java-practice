package com.dsa.algorithms.strings;

/**
 * This class provides various utility methods for common string manipulation
 * and analysis tasks.
 */
public class StringAlgorithms {

  /**
   * Checks if all characters in the given string are uppercase letters.
   *
   * @param s The input string.
   * @return {@code true} if all characters are uppercase, {@code false}
   *         otherwise.
   *
   *         Time Complexity: O(n), where n is the length of the string, as it
   *         iterates through all characters.
   *         Space Complexity: O(1).
   */
  public static boolean isUpperCase(String s) {
    return s.chars().allMatch(Character::isUpperCase);

  }

  /**
   * Checks if all characters in the given string are lowercase letters.
   *
   * @param s The input string.
   * @return {@code true} if all characters are lowercase, {@code false}
   *         otherwise.
   *
   *         Time Complexity: O(n), where n is the length of the string.
   *         Space Complexity: O(1).
   */
  public static boolean isLowerCase(String s) {
    return s.chars().allMatch(Character::isLowerCase);
  }

  /**
   * Checks if a given string meets a basic complexity requirement for a password.
   * A password is considered complex if it contains at least one uppercase
   * letter,
   * at least one lowercase letter, and at least one digit.
   *
   * @param s The input string (password) to check.
   * @return {@code true} if the string is complex, {@code false} otherwise.
   *
   *         Time Complexity: O(n), where n is the length of the string, as it may
   *         iterate through characters multiple times.
   *         Space Complexity: O(1).
   */
  public static boolean isPasswordComplex(String s) {
    return s.chars().anyMatch(Character::isUpperCase) &&
        s.chars().anyMatch(Character::isLowerCase) &&
        s.chars().anyMatch(Character::isDigit);
  }

  /**
   * Normalizes a string by converting it to lowercase, trimming leading/trailing
   * whitespace,
   * and removing all commas.
   *
   * @param s The input string to normalize.
   * @return The normalized string.
   *
   *         Time Complexity: O(n), where n is the length of the string, due to
   *         string operations.
   *         Space Complexity: O(n), for creating new string objects.
   */
  public static String normalizeString(String s) {
    return s.toLowerCase().trim().replace(",", "");
  }

  /**
   * Parses and prints the contents of a string character by character using two
   * different methods:
   * 1. Iterating with `charAt(i)`.
   * 2. Iterating over a `toCharArray()` conversion.
   *
   * @param s The input string to parse.
   *
   *          Time Complexity: O(n) for both methods, where n is the length of the
   *          string.
   *          Space Complexity: O(1) for the first method, O(n) for the second
   *          method (due to `toCharArray()`).
   */
  public static void parseContents(String s) {
    System.out.println("\nParsing string using charAt(i):");
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      System.out.print(c);
    }
    System.out.println();

    System.out.println("\nParsing string using toCharArray():");
    for (char c : s.toCharArray()) {
      System.out.print(c);
    }
    System.out.println();
  }

  /**
   * Main method to demonstrate the string algorithm functionalities.
   *
   * @param args Command line arguments (not used).
   */
  public static void main(String[] args) {
    System.out.println("--- isUpperCase Examples ---");
    System.out.println("Is 'hello' all uppercase? " + isUpperCase("hello")); // Expected: false
    System.out.println("Is 'HELLO' all uppercase? " + isUpperCase("HELLO")); // Expected: true
    System.out.println("Is 'Hello' all uppercase? " + isUpperCase("Hello")); // Expected: false

    System.out.println("\n--- isLowerCase Examples ---");
    System.out.println("Is 'hello' all lowercase? " + isLowerCase("hello")); // Expected: true
    System.out.println("Is 'HELLO' all lowercase? " + isLowerCase("HELLO")); // Expected: false
    System.out.println("Is 'Hello' all lowercase? " + isLowerCase("Hello")); // Expected: false

    System.out.println("\n--- isPasswordComplex Examples ---");
    System.out.println("Is 'hello' complex? " + isPasswordComplex("hello")); // Expected: false
    System.out.println("Is 'HELLO' complex? " + isPasswordComplex("HELLO")); // Expected: false
    System.out.println("Is '123456' complex? " + isPasswordComplex("123456")); // Expected: false
    System.out.println("Is 'Hello123' complex? " + isPasswordComplex("Hello123")); // Expected: true
    System.out.println("Is 'Pass1' complex? " + isPasswordComplex("Pass1")); // Expected: true

    System.out.println("\n--- normalizeString Examples ---");
    System.out.println("Normalized '  Hello World,  ': '" + normalizeString("  Hello World,  ") + "'"); // Expected:
                                                                                                        // 'hello world'
    System.out.println("Normalized 'TEST, STRING': '" + normalizeString("TEST, STRING") + "'"); // Expected: 'test
                                                                                                // string'

    String s = "Sample String for Parsing";
    parseContents(s);
  }
}
