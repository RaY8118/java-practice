// ### 🔷 **Problem 8 – String: Word Length Filter**
//
// Read a string and print words with length greater than 5 characters. If no such words exist, print “No words with length > 5 found”.
//
package com.ray8118.ipa.dsa;

import java.util.ArrayList;
import java.util.List;

public class WordLength {

  public static int countWordsWithLength(String inputString, int length) {
    String[] words = inputString.split(" ");
    int count = 0;
    for (String word : words) {
      if (word.length() == length) {
        count++;
      }
    }
    return count;
  }

  public static List<String> wordsWithLength5(String inputString) {
    String[] words = inputString.split(" ");
    List<String> wordsWith5Length = new ArrayList<>();
    for (String word : words) {
      if (word.length() > 5) {
        wordsWith5Length.add(word);
      }
    }

    return wordsWith5Length;
  }

  public static void main(String[] args) {

  }

}
