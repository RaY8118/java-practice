package com.ray8118.ipa.dsa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordReversalTest {

    @Test
    void testReverseWordsInSentence_basicSentence() {
        String input = "Hello World Java";
        String expected = "Java World Hello";
        assertEquals(expected, WordReversal.reverseWordsInSentence(input));
    }

    @Test
    void testReverseWordsInSentence_singleWord() {
        String input = "Programming";
        String expected = "Programming";
        assertEquals(expected, WordReversal.reverseWordsInSentence(input));
    }

    @Test
    void testReverseWordsInSentence_leadingTrailingSpaces() {
        String input = "  leading and trailing  ";
        String expected = "trailing and leading";
        assertEquals(expected, WordReversal.reverseWordsInSentence(input.trim())); // Assuming implementation handles trimming or test input is trimmed
    }

    @Test
    void testReverseWordsInSentence_multipleSpacesBetweenWords() {
        String input = "one   two three";
        String expected = "three two one";
        assertEquals(expected, WordReversal.reverseWordsInSentence(input));
    }

    @Test
    void testReverseWordsInSentence_emptyString() {
        String input = "";
        String expected = "";
        assertEquals(expected, WordReversal.reverseWordsInSentence(input));
    }

    @Test
    void testReverseWordsInSentence_punctuation() {
        String input = "Java is fun!";
        String expected = "fun! is Java";
        assertEquals(expected, WordReversal.reverseWordsInSentence(input));
    }
}