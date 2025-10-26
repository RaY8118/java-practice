package com.ray8118.ipa.oops;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResortTest {

    @Test
    void testFindAvgPriceByCategory_existingCategory() {
        Resort[] resorts = {
            new Resort(1, "Beach Resort", "Luxury", 500.0, 4.5),
            new Resort(2, "Mountain Resort", "Luxury", 400.0, 4.2),
            new Resort(3, "City Hotel", "Business", 300.0, 4.0),
            new Resort(4, "Lake Resort", "Luxury", 600.0, 4.8)
        };
        assertEquals(500, Resort.findAvgPriceByCategory(resorts, "Luxury"));
    }

    @Test
    void testFindAvgPriceByCategory_caseInsensitive() {
        Resort[] resorts = {
            new Resort(1, "Beach Resort", "luxury", 500.0, 4.5),
            new Resort(2, "Mountain Resort", "LUXURY", 400.0, 4.2)
        };
        assertEquals(450, Resort.findAvgPriceByCategory(resorts, "Luxury"));
    }

    @Test
    void testFindAvgPriceByCategory_noHighRatedResorts() {
        Resort[] resorts = {
            new Resort(1, "Beach Resort", "Luxury", 500.0, 3.5),
            new Resort(2, "Mountain Resort", "Luxury", 400.0, 4.0)
        };
        assertEquals(0, Resort.findAvgPriceByCategory(resorts, "Luxury"));
    }

    @Test
    void testFindAvgPriceByCategory_noMatchingCategory() {
        Resort[] resorts = {
            new Resort(1, "Beach Resort", "Luxury", 500.0, 4.5),
            new Resort(2, "Mountain Resort", "Business", 400.0, 4.2)
        };
        assertEquals(0, Resort.findAvgPriceByCategory(resorts, "Budget"));
    }

    @Test
    void testFindAvgPriceByCategory_emptyArray() {
        Resort[] resorts = {};
        assertEquals(0, Resort.findAvgPriceByCategory(resorts, "Luxury"));
    }

    @Test
    void testFindAvgPriceByCategory_singleResort() {
        Resort[] resorts = {
            new Resort(1, "Beach Resort", "Luxury", 500.0, 4.5)
        };
        assertEquals(500, Resort.findAvgPriceByCategory(resorts, "Luxury"));
    }

    @Test
    void testFindAvgPriceByCategory_ratingExactly4() {
        Resort[] resorts = {
            new Resort(1, "Beach Resort", "Luxury", 500.0, 4.0)
        };
        assertEquals(0, Resort.findAvgPriceByCategory(resorts, "Luxury"));
    }
}