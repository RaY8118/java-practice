
//
// ### 🔷 **Problem 10 – String Anagram Checker**
//
// Write a program that takes two strings as input and determines if they are
// anagrams of each other. Anagrams are words or phrases formed by rearranging
// the letters of another, using all the original letters exactly once. The
// comparison should be case-insensitive and ignore non-alphabetic characters.
//
// Return `true` if they are anagrams, `false` otherwise.
package com.ray8118.ipa.dsa;

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
  }
}
