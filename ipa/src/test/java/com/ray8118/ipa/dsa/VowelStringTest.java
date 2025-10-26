package com.ray8118.ipa.dsa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VowelStringTest {

    @Test
    void testCountVowels_basicCase() {
        assertEquals(5, VowelString.countVowels("aeiou"));
    }

    @Test
    void testCountVowels_mixedCase() {
        assertEquals(5, VowelString.countVowels("AEIOU"));
    }

    @Test
    void testCountVowels_withConsonants() {
        assertEquals(3, VowelString.countVowels("Hello World")); // e, o, o
    }

    @Test
    void testCountVowels_noVowels() {
        assertEquals(0, VowelString.countVowels("rhythm"));
    }

    @Test
    void testCountVowels_emptyString() {
        assertEquals(0, VowelString.countVowels(""));
    }

    @Test
    void testCountVowels_nullString() {
        assertEquals(0, VowelString.countVowels(null));
    }
}
