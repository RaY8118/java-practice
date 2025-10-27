// ### 🔷 **Problem 16 – String Case Converter**

// Write a program that reads a string and:

// * Converts all uppercase letters to lowercase
// * Converts all lowercase letters to uppercase
// * A method `toggleCase(String inputString)` that swaps the case of each letter in the string.

// Print the converted string.

// ---
package com.ray8118.ipa.dsa;

public class StringCaseConverter {

    public static String toggleCase(String inputString) {
        if (inputString == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (Character ch : inputString.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                result.append(Character.toUpperCase(ch));
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
