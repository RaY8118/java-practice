
//
// ### 🔷 **Problem 10 – String Anagram Checker**
//
// Write a program that takes two strings as input and determines if they are
// anagrams of each other. Anagrams are words or phrases formed by rearranging
// the letters of another, using all the original letters exactly once. The
// comparison should be case-insensitive and ignore non-alphabetic characters.
//
// Return `true` if they are anagrams, `false` otherwise.
package com.ray8118.ipa;

import java.util.Arrays;

public class Anagram {

  public static boolean isAnagram(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return false;
    }

    String cleanS1 = s1.replaceAll("[^a-zA-Z]", "").toLowerCase();
    String cleanS2 = s2.replaceAll("[^a-zA-Z]", "").toLowerCase();

    if (cleanS1.length() != cleanS2.length()) {
      return false;
    }

    char[] charArray1 = cleanS1.toCharArray();
    char[] charArray2 = cleanS2.toCharArray();

    Arrays.sort(charArray1);
    Arrays.sort(charArray2);

    return Arrays.equals(charArray1, charArray2);
  }

  public static void main(String[] args) {

    System.out.println("--- Testing isAnagram ---");
    TestHelper.assertEqual("isAnagram - Basic Anagram", true, Anagram.isAnagram("listen", "silent"));
    TestHelper.assertEqual("isAnagram - Different Case", true, Anagram.isAnagram("Listen", "Silent"));
    TestHelper.assertEqual("isAnagram - With Spaces", true, Anagram.isAnagram("A gentleman", "Elegant man"));
    TestHelper.assertEqual("isAnagram - With Punctuation", true, Anagram.isAnagram("Debit card", "Bad credit"));
    TestHelper.assertEqual("isAnagram - Not Anagrams", false, Anagram.isAnagram("hello", "world"));
    TestHelper.assertEqual("isAnagram - Different Length", false, Anagram.isAnagram("abc", "abcd"));
    TestHelper.assertEqual("isAnagram - Empty Strings", true, Anagram.isAnagram("", ""));
    TestHelper.assertEqual("isAnagram - One Empty String", false, Anagram.isAnagram("a", ""));
    TestHelper.assertEqual("isAnagram - Null Strings", false, Anagram.isAnagram(null, "abc"));
    TestHelper.assertEqual("isAnagram - Null Strings 2", false, Anagram.isAnagram("abc", null));
    TestHelper.assertEqual("isAnagram - Null Strings 3", false, Anagram.isAnagram(null, null));
  }
}
