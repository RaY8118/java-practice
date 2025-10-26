package com.ray8118.ipa.dsa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LowerStringTest {

    @Test
    void testCountLowercase_basicString() {
        assertEquals(8, LowerString.countLowercase("Hello World"));
    }

    @Test
    void testCountLowercase_allLowercase() {
        assertEquals(10, LowerString.countLowercase("hello world"));
    }

    @Test
    void testCountLowercase_mixedCase() {
        assertEquals(4, LowerString.countLowercase("HeLLo WoRLd"));
    }

    @Test
    void testCountLowercase_allLowercase() {
        assertEquals(11, LowerString.countLowercase("hello world"));
    }

    @Test
    void testCountLowercase_allUppercase() {
        assertEquals(0, LowerString.countLowercase("HELLO WORLD"));
    }

    @Test
    void testCountLowercase_mixedCase() {
        assertEquals(8, LowerString.countLowercase("HeLLo WoRLd"));
    }

    @Test
    void testCountLowercase_emptyString() {
        assertEquals(0, LowerString.countLowercase(""));
    }

    @Test
    void testCountLowercase_nullString() {
        assertEquals(0, LowerString.countLowercase(null));
    }

    @Test
    void testCountLowercase_numbersAndSymbols() {
        assertEquals(3, LowerString.countLowercase("abc123!@#DEF"));
    }

    @Test
    void testCountLowercase_onlySymbols() {
        assertEquals(0, LowerString.countLowercase("!@#$%^&*()"));
    }
}