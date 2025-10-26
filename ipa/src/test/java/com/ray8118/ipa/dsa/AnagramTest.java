package com.ray8118.ipa.dsa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnagramTest {

    @Test
    void testIsAnagram_basicAnagram() {
        assertEquals(true, Anagram.isAnagram("listen", "silent"));
    }

    @Test
    void testIsAnagram_differentCase() {
        assertEquals(true, Anagram.isAnagram("Listen", "Silent"));
    }

    @Test
    void testIsAnagram_withSpaces() {
        assertEquals(true, Anagram.isAnagram("A gentleman", "Elegant man"));
    }

    @Test
    void testIsAnagram_withPunctuation() {
        assertEquals(true, Anagram.isAnagram("Debit card", "Bad credit"));
    }

    @Test
    void testIsAnagram_notAnagrams() {
        assertEquals(false, Anagram.isAnagram("hello", "world"));
    }

    @Test
    void testIsAnagram_differentLength() {
        assertEquals(false, Anagram.isAnagram("abc", "abcd"));
    }

    @Test
    void testIsAnagram_emptyStrings() {
        assertEquals(true, Anagram.isAnagram("", ""));
    }

    @Test
    void testIsAnagram_oneEmptyString() {
        assertEquals(false, Anagram.isAnagram("a", ""));
    }

    @Test
    void testIsAnagram_nullStrings() {
        assertEquals(false, Anagram.isAnagram(null, "abc"));
        assertEquals(false, Anagram.isAnagram("abc", null));
        assertEquals(false, Anagram.isAnagram(null, null));
    }

    @Test
    void testIsAnagram_sameString() {
        assertEquals(true, Anagram.isAnagram("abc", "abc"));
    }

    @Test
    void testIsAnagram_numbersAndLetters() {
        assertEquals(true, Anagram.isAnagram("123abc", "cba321"));
    }
}