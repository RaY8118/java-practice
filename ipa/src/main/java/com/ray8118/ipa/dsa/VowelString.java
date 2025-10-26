//  In the main method, read a string and find the count of words starting with 
// 
//  vowel in the string. If no words
// are present in the String value then it should print "No String found".
package com.ray8118.ipa.dsa;

import java.util.Scanner;

public class VowelString {

  public static void main(String[] args) {
    System.out.print("Enter a string: ");
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    int count = countVowels(str);

    if (count == 0) {
      System.out.println("No string found");
    } else {
      System.out.println(count);
    }
    sc.close();
  }

  public static int countVowels(String str) {
    if (str == null) {
      return 0;
    }
    int count = 0;
    for (char ch : str.toCharArray()) {
      if ("aeiou".indexOf(Character.toLowerCase(ch)) != -1) {
        count++;
      }
    }
    return count;
  }
}
