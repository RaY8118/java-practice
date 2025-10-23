// ### 🔷 **Problem 6 – Uppercase Character Count**
//
// Write a program that reads a string and counts number of uppercase characters. If none are found, print “No uppercase characters present”.
//

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class UppercaseCount {

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
  }

  static {
    String[][] tests = {
        { "I love programming in Java", "The uppercase characters count is: 2" },
        { "shot words only", "No uppercase characters found" },
        { "Artifical Intelligence is Amazing", "The uppercase characters count is: 3" },
    };

    TestHelper.runTests(UppercaseCount::main, tests);
    System.exit(0);
  }

}
