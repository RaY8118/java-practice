package com.ray8118.ipa.dsa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class WordLengthTest {

    @Test
    public void testWordsWithLength5_mixedWords() {
        String input = "I love programming in Java";
        List<String> expected = Arrays.asList("programming");
        List<String> result = WordLength.wordsWithLength5(input);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    public void testWordsWithLength5_noLongWords() {
        String input = "short words only";
        List<String> result = WordLength.wordsWithLength5(input);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testWordsWithLength5_multipleLongWords() {
        String input = "Artificial Intelligence is amazing";
        List<String> expected = Arrays.asList("Artificial", "Intelligence", "amazing");
        List<String> result = WordLength.wordsWithLength5(input);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    public void testWordsWithLength5_emptyString() {
        String input = "";
        List<String> result = WordLength.wordsWithLength5(input);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testWordsWithLength5_singleLongWord() {
        String input = "programming";
        List<String> expected = Arrays.asList("programming");
        List<String> result = WordLength.wordsWithLength5(input);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    public void testWordsWithLength5_singleShortWord() {
        String input = "code";
        List<String> result = WordLength.wordsWithLength5(input);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testCountWordsWithLength_multipleMatches() {
        String input = "the cat sat on the mat";
        int count = WordLength.countWordsWithLength(input, 3);
        assertEquals(5, count); // the, cat, sat, mat
    }

    @Test
    public void testCountWordsWithLength_noMatches() {
        String input = "the cat sat on the mat";
        int count = WordLength.countWordsWithLength(input, 5);
        assertEquals(0, count);
    }

    @Test
    public void testCountWordsWithLength_emptyString() {
        int count = WordLength.countWordsWithLength("", 3);
        assertEquals(0, count);
    }

    @Test
    public void testCountWordsWithLength_singleWordMatch() {
        int count = WordLength.countWordsWithLength("hello", 5);
        assertEquals(1, count);
    }
}