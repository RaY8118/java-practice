// ### 🔷 **Problem 12 – String Digit and Letter Counter**

// Write a program that reads a string and:

// * Counts the number of digits (0-9)
// * Counts the number of letters (a-z, A-Z)
// * A method `removeNonAlphanumeric(String inputString)` that returns the string with all non-alphanumeric characters removed.

// Print both counts. If there are no digits or no letters, print an appropriate message.

// ---
package com.ray8118.ipa.dsa;

public class StringDigitCounter {
    public int countLetters(String inputString) {
        if (inputString == null) {
            return 0;
        }

        int count = 0;
        for (Character ch : inputString.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                count++;
            }
        }
        return count;
    }

    public int countDigits(String inputString) {
        if (inputString == null) {
            return 0;
        }

        int count = 0;
        for (Character ch : inputString.toCharArray()) {
            if (Character.isDigit(ch)) {
                count++;
            }
        }
        return count;
    }

    public String removeNonAlphanumeric(String inputString) {
        if (inputString == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : inputString.toCharArray()) {
            if (Character.isAlphabetic(ch) || Character.isDigit(ch)) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
