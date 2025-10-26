// ### 🔷 **Problem 6 – Uppercase Character Count**
//
// Write a program that reads a string and counts number of uppercase characters. If none are found, print “No uppercase characters present”.
//
package com.ray8118.ipa.dsa;

import java.util.Scanner;

import com.ray8118.ipa.TestHelper;

public class UppercaseCount {

  public static int countUppercase(String sentence) {
    if (sentence == null) return 0;
    int count = 0;
    for (Character ch : sentence.toCharArray()) {
      if (Character.isUpperCase(ch)) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String sentence = sc.nextLine();

    int count = 0;
    for (Character ch : sentence.toCharArray()) {
      if (Character.isUpperCase(ch)) {
        count++;
      }
    }

    if (count != 0) {
      System.out.println("The uppercase characters count is: " + count);
    } else {
      System.out.println("No uppercase characters found");
    }

    sc.close();
  }



}
