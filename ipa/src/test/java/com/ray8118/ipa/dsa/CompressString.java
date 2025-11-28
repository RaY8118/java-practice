// ### 🔷 **Problem 24 – Advanced String Compression and Decompression**

// Implement a string compression algorithm that:

// * Replaces consecutive repeated characters with the character followed by the count (e.g., "aaabbb" becomes "a3b3")
// * For single characters, just keep the character (no count)
// * A method `compressString(String inputString)` that returns the compressed version.

// Also implement the reverse:

// * A method `decompressString(String compressedString)` that converts back to the original string.

// Handle edge cases like empty strings, strings with no consecutive repeats, and invalid compressed formats.

// ---
package com.ray8118.ipa.dsa;

public class CompressString {
    public static String compressString(String inputString) {
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i <= inputString.length(); i++) {
            if (i < inputString.length() && inputString.charAt(i) == inputString.charAt(i - 1)) {
                count++;
            } else {
                result.append(inputString.charAt(i - 1));
                if (count > 1) result.append(count);
                    count = 1;
                
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String str = "aabb";
        String result = compressString(str);
        System.out.println(result);
    }
}
