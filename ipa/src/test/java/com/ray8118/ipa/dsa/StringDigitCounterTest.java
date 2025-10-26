package com.ray8118.ipa.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringDigitCounterTest {

    @Test
    @DisplayName("Count digits and letters in a mixed string")
    public void testCountDigitsAndLetters_MixedString() {
        String input = "Hello123World";
        StringDigitCounter counter = new StringDigitCounter();
        assertEquals(10, counter.countLetters(input));
        assertEquals(3, counter.countDigits(input));
    }

    @Test
    @DisplayName("String with only digits")
    public void testOnlyDigits() {
        String input = "987654";
        StringDigitCounter counter = new StringDigitCounter();
        assertEquals(0, counter.countLetters(input));
        assertEquals(6, counter.countDigits(input));
    }

    @Test
    @DisplayName("String with only letters")
    public void testOnlyLetters() {
        String input = "OpenAI";
        StringDigitCounter counter = new StringDigitCounter();
        assertEquals(6, counter.countLetters(input));
        assertEquals(0, counter.countDigits(input));
    }

    @Test
    @DisplayName("String with symbols and spaces")
    public void testWithSymbolsAndSpaces() {
        String input = "H3llo W0rld! @2025";
        StringDigitCounter counter = new StringDigitCounter();
        assertEquals(8, counter.countLetters(input));
        assertEquals(6, counter.countDigits(input));
    }

    @Test
    @DisplayName("Remove non-alphanumeric characters")
    public void testRemoveNonAlphanumeric() {
        String input = "H3llo_World!@2025";
        StringDigitCounter counter = new StringDigitCounter();
        assertEquals("H3lloWorld2025", counter.removeNonAlphanumeric(input));
    }

    @Test
    @DisplayName("Empty string case")
    public void testEmptyString() {
        String input = "";
        StringDigitCounter counter = new StringDigitCounter();
        assertEquals(0, counter.countLetters(input));
        assertEquals(0, counter.countDigits(input));
        assertEquals("", counter.removeNonAlphanumeric(input));
    }

    @Test
    @DisplayName("String with only special characters")
    public void testOnlySpecialCharacters() {
        String input = "!@#$%^&*()";
        StringDigitCounter counter = new StringDigitCounter();
        assertEquals(0, counter.countLetters(input));
        assertEquals(0, counter.countDigits(input));
        assertEquals("", counter.removeNonAlphanumeric(input));
    }
}
