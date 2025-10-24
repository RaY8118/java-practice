// ### 🔷 **Problem 8 – String: Word Length Filter**
//
// Read a string and print words with length greater than 5 characters. If no such words exist, print “No words with length > 5 found”.
//
package com.ray8118.ipa.dsa;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordLength {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String sentence = sc.nextLine();
    String[] words = sentence.split(" ");
    List<String> wordsWith5Length = new ArrayList<>();
    for (String word : words) {
      if (word.length() > 5) {
        wordsWith5Length.add(word);
      }
    }

    if (wordsWith5Length.size() != 0) {
      for (String word : wordsWith5Length) {
        System.out.println(word);
      }
    } else {
      System.out.println("No words with length > 5 found");
    }
    sc.close();
  }

  public static void runTests() throws Exception {
    String[][] tests = {
        { "I love programming in Java", "programming" },
        { "shot words only", "No words with length > 5 found" },
        { "Artifical Intelligence is amazing", "Artifical\nIntelligence" },
    };

    for (String[] test : tests) {
      String input = test[0];
      String expected = test[1];

      ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
      ByteArrayOutputStream out = new ByteArrayOutputStream();

      System.setIn(in);
      System.setOut(new PrintStream(out));

      main(new String[0]);

      String actual = out.toString().trim();
      System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

      System.out.println("Input: " + input);
      System.out.println("Expected: \n" + expected);
      System.out.println("Got: \n" + actual);
      System.out.println(actual.equals(expected) ? "Passed" : "Failed");
      System.out.println("-----");
    }
  }

  static {
    try {
      runTests();
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
