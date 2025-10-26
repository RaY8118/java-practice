package com.ray8118.ipa.dsa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeCountTest {

    @Test
    void testCountPalindromes_singlePalindrome() {
        assertEquals(1, PalindromeCount.countPalindromes("HeeH"));
    }

    @Test
    void testCountPalindromes_noPalindromes() {
        assertEquals(0, PalindromeCount.countPalindromes("Hello World"));
    }

    @Test
    void testCountPalindromes_multiplePalindromes() {
        assertEquals(3, PalindromeCount.countPalindromes("radar level madam hello"));
    }

    @Test
    void testCountPalindromes_mixedCase() {
        assertEquals(1, PalindromeCount.countPalindromes("Radar"));
    }

    @Test
    void testCountPalindromes_emptyString() {
        assertEquals(0, PalindromeCount.countPalindromes(""));
    }

    @Test
    void testCountPalindromes_nullString() {
        assertEquals(0, PalindromeCount.countPalindromes(null));
    }

    @Test
    void testCountPalindromes_singleWordPalindrome() {
        assertEquals(1, PalindromeCount.countPalindromes("radar"));
    }

    @Test
    void testCountPalindromes_singleWordNotPalindrome() {
        assertEquals(0, PalindromeCount.countPalindromes("hello"));
    }

    @Test
    void testCountPalindromes_withPunctuation() {
        assertEquals(3, PalindromeCount.countPalindromes("A man, a plan, a canal: Panama"));
    }

    @Test
    void testCountPalindromes_multipleSpaces() {
        assertEquals(2, PalindromeCount.countPalindromes("radar   level    test"));
    }
}