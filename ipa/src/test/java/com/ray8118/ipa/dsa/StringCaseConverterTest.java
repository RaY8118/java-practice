package com.ray8118.ipa.dsa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StringCaseConverterTest {

    @Test
    void testToggleCase_mixedCase() {
        assertEquals("hELLO wORLD", StringCaseConverter.toggleCase("Hello World"));
    }

    @Test
    void testToggleCase_allUppercase() {
        assertEquals("hello", StringCaseConverter.toggleCase("HELLO"));
    }

    @Test
    void testToggleCase_allLowercase() {
        assertEquals("WORLD", StringCaseConverter.toggleCase("world"));
    }

    @Test
    void testToggleCase_withNumbersAndSymbols() {
        assertEquals("tEST 123!@#", StringCaseConverter.toggleCase("Test 123!@#"));
    }

    @Test
    void testToggleCase_emptyString() {
        assertEquals("", StringCaseConverter.toggleCase(""));
    }

    @Test
    void testToggleCase_nullInput() {
        assertNull(StringCaseConverter.toggleCase(null));
    }
}