package com.ray8118.ipa.dsa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UppercaseCountTest {

    @Test
    void testCountUppercase_basicString() {
        assertEquals(2, UppercaseCount.countUppercase("I love programming in Java"));
    }

    @Test
    void testCountUppercase_allUppercase() {
        assertEquals(3, UppercaseCount.countUppercase("ABC"));
    }

    @Test
    void testCountUppercase_allLowercase() {
        assertEquals(0, UppercaseCount.countUppercase("short words only"));
    }

    @Test
    void testCountUppercase_mixedCase() {
        assertEquals(3, UppercaseCount.countUppercase("Artifical Intelligence is Amazing"));
    }

    @Test
    void testCountUppercase_emptyString() {
        assertEquals(0, UppercaseCount.countUppercase(""));
    }

    @Test
    void testCountUppercase_nullString() {
        assertEquals(0, UppercaseCount.countUppercase(null));
    }

    @Test
    void testCountUppercase_numbersAndSymbols() {
        assertEquals(6, UppercaseCount.countUppercase("ABC123def!@#GHI"));
    }

    @Test
    void testCountUppercase_onlySymbols() {
        assertEquals(0, UppercaseCount.countUppercase("!@#$%^&*()"));
    }

    @Test
    void testCountUppercase_singleUppercase() {
        assertEquals(1, UppercaseCount.countUppercase("A"));
    }

    @Test
    void testCountUppercase_singleLowercase() {
        assertEquals(0, UppercaseCount.countUppercase("a"));
    }
}