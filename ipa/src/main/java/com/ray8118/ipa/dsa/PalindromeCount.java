
// ### 🔷 **Problem 4 – Palindrome Word Count**
//
// Read a sentence (string). Find and print the number of words in it that are palindromes (same forwards and backwards). If no palindromic words are found, print “No Palindrome Found”.
//

package com.ray8118.ipa.dsa;

import java.util.Scanner;

import com.ray8118.ipa.TestHelper;

public class PalindromeCount {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String sentence = sc.nextLine();
    String[] words = sentence.toLowerCase().split(" ");
    int count = 0;
    for (String word : words) {
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

  public static boolean isPalindrome(String word) {
    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  public static int countPalindromes(String sentence) {
    if (sentence == null || sentence.trim().isEmpty()) return 0;
    String[] words = sentence.toLowerCase().split("\\s+");
    int count = 0;
    for (String word : words) {
      if (isPalindrome(word)) {
        count++;
      }
    }
    return count;
  }


}
