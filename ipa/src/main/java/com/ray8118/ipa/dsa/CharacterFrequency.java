// ### 🔷 **Problem 20 – String Character Frequency**

// Write a program that reads a string and finds the most frequent character (case-insensitive). If there are multiple characters with the same highest frequency, return any one of them. If the string is empty, return a space character.

// Add a method `getCharacterFrequency(String inputString, char character)` that returns the count of a specific character in the string (case-insensitive).

package com.ray8118.ipa.dsa;

import java.util.HashMap;
import java.util.Map;

public class CharacterFrequency {
    public static char findMostFrequentCharacter(String inputString) {
        char[] inputCharArray = inputString.toCharArray();
        HashMap<Character, Integer> characterFreq = new HashMap<>();
        for (char c : inputCharArray) {
            if (characterFreq.containsKey(c)) {
                characterFreq.put(c, characterFreq.get(c) + 1);
            } else {
                characterFreq.put(c, 0);
            }
        }

        char mostFrequentChar = ' ';
        int highestCount = 0;

        for (Map.Entry<Character, Integer> entry : characterFreq.entrySet()) {
            if (entry.getValue() > highestCount) {
                highestCount = entry.getValue();
                mostFrequentChar = entry.getKey();
            }
        }

        return mostFrequentChar;
    }

    // Required method for Problem 20 (Character Frequency Count)
    public static int getCharacterFrequency(String inputString, char character) {
        // Implementation will be done later, just defining the signature
        return 0;
    }
}