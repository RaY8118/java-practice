
// ### 🔷 **Problem 4 – Palindrome Word Count**
//
// Read a sentence (string). Find and print the number of words in it that are palindromes (same forwards and backwards). If no palindromic words are found, print “No Palindrome Found”.
//

package com.ray8118.ipa.dsa;

import java.util.Scanner;

public class PalindromeCount {

  public static void main(final String[] args) {
    final Scanner sc = new Scanner(System.in);
    final String sentence = sc.nextLine();
    final String[] words = sentence.toLowerCase().split(" ");
    int count = 0;
    for (final String word : words) {
      if (isPalindrome(word)) {
        count++;
      }
    }

    if (count != 0) {
      System.out.println("Palindrome count: " + count);
    } else {
      System.out.println("No Palindrome found");
    }
    sc.close();
  }

  public static boolean isPalindrome(final String word) {
    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  public static int countPalindromes(final String sentence) {
    if (sentence == null || sentence.trim().isEmpty())
      return 0;
    final String[] words = sentence.toLowerCase().split("\\s+");
    int count = 0;
    for (final String word : words) {
      if (isPalindrome(word)) {
        count++;
      }
    }
    return count;
  }

}
