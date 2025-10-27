package com.ray8118.ipa.dsa;

public class WordReversal {
    public static String reverseWordsInSentence(String sentence) {
        if (sentence.length() == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        String reversedSentence = reverse(sentence);
        for (String word : reversedSentence.split("\\s+")) {
            result.append(reverse(word));
            result.append(" ");
        }

        return result.toString().trim();
    }

    public static String reverse(String word) {
        StringBuilder result = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            result.append(word.charAt(i));
        }
        return result.toString();
    }


    public static void main(String[] args) {
        String result = reverseWordsInSentence("Hello World");
        System.out.println(result);
    }
}