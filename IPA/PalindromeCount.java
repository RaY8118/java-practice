
// ### 🔷 **Problem 4 – Palindrome Word Count**
//
// Read a sentence (string). Find and print the number of words in it that are palindromes (same forwards and backwards). If no palindromic words are found, print “No Palindrome Found”.
//

import java.util.Scanner;

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

  static {
    String[][] tests = {
        { "HeeH", "Palindrome count: 1" },
        { "Hello World", "No Palindrome found" }
    };

    TestHelper.runTests(PalindromeCount::main, tests);
    System.exit(0);
  }
}
