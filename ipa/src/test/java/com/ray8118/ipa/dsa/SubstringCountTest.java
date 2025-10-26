package com.ray8118.ipa.dsa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubstringCountTest {

    @Test
    void testCountSubstring_basic() {
        SubstringCount s = new SubstringCount();
        Assertions.assertEquals(3, s.countSubstring("abcabcabc", "abc"));
    }

    @Test
    void testCountSubstring_partialOverlap() {
        SubstringCount s = new SubstringCount();
        Assertions.assertEquals(3, s.countSubstring("aaaa", "aa"));
    }

    @Test
    void testCountSubstring_notFound() {
        SubstringCount s = new SubstringCount();
        Assertions.assertEquals(0, s.countSubstring("abcdef", "xyz"));
    }

    @Test
    void testCountSubstring_caseSensitive() {
        SubstringCount s = new SubstringCount();
        Assertions.assertEquals(1, s.countSubstring("Hellohello", "Hello"));
    }

    @Test
    void testFindAllSubstringPositions_basic() {
        SubstringCount s = new SubstringCount();
        int[] result = s.findAllSubstringPositions("abcabcabc", "abc");
        Assertions.assertArrayEquals(new int[] { 0, 3, 6 }, result);
    }

    @Test
    void testFindAllSubstringPositions_notFound() {
        SubstringCount s = new SubstringCount();
        int[] result = s.findAllSubstringPositions("abcdef", "xyz");
        Assertions.assertArrayEquals(new int[] {}, result);
    }
}
