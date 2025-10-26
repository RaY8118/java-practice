package com.ray8118.ipa.dsa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeadSetsTest {

    @Test
    void testFindTotalPriceForGivenBrand_existingBrand() {
        HeadSets[] headSets = {
            new HeadSets("Model A", "Sony", 100, true),
            new HeadSets("Model B", "Sony", 200, false),
            new HeadSets("Model C", "Bose", 300, true)
        };
        assertEquals(300, HeadSets.findTotalPriceForGivenBrand(headSets, "Sony"));
    }

    @Test
    void testFindTotalPriceForGivenBrand_caseInsensitive() {
        HeadSets[] headSets = {
            new HeadSets("Model A", "Sony", 100, true),
            new HeadSets("Model B", "SONY", 200, false)
        };
        assertEquals(300, HeadSets.findTotalPriceForGivenBrand(headSets, "sony"));
    }

    @Test
    void testFindTotalPriceForGivenBrand_noMatchingBrand() {
        HeadSets[] headSets = {
            new HeadSets("Model A", "Sony", 100, true),
            new HeadSets("Model B", "Bose", 200, false)
        };
        assertEquals(0, HeadSets.findTotalPriceForGivenBrand(headSets, "JBL"));
    }

    @Test
    void testFindTotalPriceForGivenBrand_emptyArray() {
        HeadSets[] headSets = {};
        assertEquals(0, HeadSets.findTotalPriceForGivenBrand(headSets, "Sony"));
    }

    @Test
    void testFindAvailableHeadsetWithSecondMinPrice_multipleAvailable() {
        HeadSets[] headSets = {
            new HeadSets("Model A", "Sony", 100, true),
            new HeadSets("Model B", "Sony", 200, true),
            new HeadSets("Model C", "Bose", 150, true),
            new HeadSets("Model D", "Bose", 300, false)
        };
        HeadSets result = HeadSets.findAvailableHeadsetWithSecondMinPrice(headSets);
        assertNotNull(result);
        assertEquals(150, result.getPrice());
        assertEquals("Model C", result.getHeadSetName());
    }

    @Test
    void testFindAvailableHeadsetWithSecondMinPrice_onlyOneAvailable() {
        HeadSets[] headSets = {
            new HeadSets("Model A", "Sony", 100, true),
            new HeadSets("Model B", "Sony", 200, false)
        };
        HeadSets result = HeadSets.findAvailableHeadsetWithSecondMinPrice(headSets);
        assertNull(result);
    }

    @Test
    void testFindAvailableHeadsetWithSecondMinPrice_noAvailable() {
        HeadSets[] headSets = {
            new HeadSets("Model A", "Sony", 100, false),
            new HeadSets("Model B", "Sony", 200, false)
        };
        HeadSets result = HeadSets.findAvailableHeadsetWithSecondMinPrice(headSets);
        assertNull(result);
    }

    @Test
    void testFindAvailableHeadsetWithSecondMinPrice_emptyArray() {
        HeadSets[] headSets = {};
        HeadSets result = HeadSets.findAvailableHeadsetWithSecondMinPrice(headSets);
        assertNull(result);
    }
}