// ### 🔷 **Problem 14 – String Substring Frequency**

// Read a string and a substring. Count how many times the substring appears in the string (case-sensitive). If the substring is not found, print "Substring not found".

// Add a method `findAllSubstringPositions(String inputString, String substring)` that returns an array of integers representing the starting positions of all occurrences of the substring.

// ---
package com.ray8118.ipa.dsa;

import java.util.ArrayList;
import java.util.List;

public class SubstringCount {

    public int countSubstring(String inputString, String subString) {
        int strLen = inputString.length();
        int subStrLen = subString.length();
        int count = 0;
        for (int i = 0; i <= strLen - subStrLen; i++) {
            if (inputString.substring(i, i + subStrLen).equals(subString)) {
                count++;
            }
        }

        return count;
    }

    public int[] findAllSubstringPositions(String inputString, String substring) {
        int strLen = inputString.length();
        int subStrLen = substring.length();
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i <= strLen - subStrLen; i++) {
            if (inputString.substring(i, i + subStrLen).equals(substring)) {
                positions.add(i);
            }
        }

        return positions.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {
        SubstringCount subtringCount = new SubstringCount();
        int count = subtringCount.countSubstring("abcabcabcaabc", "abc");
        if (count != 0) {
            System.out.println(count);
        } else {
            System.out.println("Substring not found");
        }
    }
}
