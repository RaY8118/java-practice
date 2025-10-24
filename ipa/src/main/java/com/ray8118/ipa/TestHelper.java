package com.ray8118.ipa;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

public class TestHelper {
  public static void runTests(Consumer<String[]> mainMethod, String[][] tests) {
    for (int i = 0; i < tests.length; i++) {
      String input = tests[i][0];
      String expected = tests[i][1];

      try {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setIn(in);
        System.setOut(new PrintStream(out));

        mainMethod.accept(new String[0]);

        String actual = out.toString().trim();

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        System.out.println("Test #" + (i + 1));
        System.out.println("Input:\n" + input);
        System.out.println("Expected:\n" + expected);
        System.out.println("Got:\n" + actual);

        if (actual.equals(expected)) {
          System.out.println("✅ Passed");
        } else {
          System.out.println("❌ Failed");
        }

        System.out.println("-----------------");

      } catch (Exception e) {
        e.printStackTrace();
      }

    }
  }

  public static <T> void assertEqual(String testName, T actual, T expected) {
    if ((actual == null && expected == null) ||
        (actual != null && actual.equals(expected))) {
      System.out.println("✅ " + testName + " passed (" + actual + ")");
    } else {
      System.out.println("❌ " + testName + " failed — expected " + expected + ", got " + actual);
    }
  }
}
