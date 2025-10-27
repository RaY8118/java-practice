package com.ray8118.ipa.dsa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CharacterFrequencyTest {

    @Test
    void testFindMostFrequentCharacter_basicCase() {
        // 'a' is most frequent
        assertEquals('a', CharacterFrequency.findMostFrequentCharacter("banana"));
    }

    @Test
    void testFindMostFrequentCharacter_caseInsensitive() {
        // 'a'/'A' is most frequent
        char result = CharacterFrequency.findMostFrequentCharacter("aAbBcCa");
        assertTrue(result == 'a' || result == 'A');
    }

    @Test
    void testFindMostFrequentCharacter_tie() {
        // 'a' and 'b' are tied (2 each), should return one of them
        String input = "aabbc";
        char result = CharacterFrequency.findMostFrequentCharacter(input);
        assertTrue(result == 'a' || result == 'b');
    }

    @Test
    void testFindMostFrequentCharacter_emptyString() {
        // Should return a space character
        assertEquals(' ', CharacterFrequency.findMostFrequentCharacter(""));
    }

    @Test
    void testGetCharacterFrequency_basicCount() {
        assertEquals(3, CharacterFrequency.getCharacterFrequency("programming", 'g'));
    }

    @Test
    void testGetCharacterFrequency_caseInsensitive() {
        assertEquals(4, CharacterFrequency.getCharacterFrequency("Mississippi", 's'));
        assertEquals(2, CharacterFrequency.getCharacterFrequency("aAbBcCa", 'A'));
    }

    @Test
    void testGetCharacterFrequency_nonExistent() {
        assertEquals(0, CharacterFrequency.getCharacterFrequency("hello", 'z'));
    }

    @Test
    void testGetCharacterFrequency_emptyString() {
        assertEquals(0, CharacterFrequency.getCharacterFrequency("", 'a'));
    }
}