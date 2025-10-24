// In the main method, read a String value and print the count of lower case characters
// present in the input String value. If no lower case characters are present in the String value
// then it should print "No lower case characters present" as a String.

package com.ray8118.ipa;

import java.util.Scanner;

/**
 * LowerString
 */
public class LowerString {

  public static void main(String[] args) {
    int count = 0;
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the string");
    String s = sc.nextLine();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch >= 'a' && ch <= 'z') {
        count++;
      }
    }

    if (count > 0) {
      System.out.println(count);
    } else {
      System.out.println("No lower case characters present");
    }

    sc.close();
  }
}
