package com.ray8118.ipa.oops;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MobileTest {

    @Test
    void testFindAveragePriceByBrand_existingBrand() {
        Mobile[] mobiles = {
            new Mobile("Model X", "BrandA", 1000, true),
            new Mobile("Model Y", "BrandA", 800, false),
            new Mobile("Model Z", "BrandB", 1200, true)
        };
        assertEquals(900, Mobile.findAveragePriceByBrand(mobiles, "BrandA"));
    }

    @Test
    void testFindAveragePriceByBrand_caseInsensitive() {
        Mobile[] mobiles = {
            new Mobile("Model X", "BrandA", 1000, true),
            new Mobile("Model Y", "branda", 800, false)
        };
        assertEquals(900, Mobile.findAveragePriceByBrand(mobiles, "BRANDA"));
    }

    @Test
    void testFindAveragePriceByBrand_nonExistentBrand() {
        Mobile[] mobiles = {
            new Mobile("Model X", "BrandA", 1000, true),
            new Mobile("Model Y", "BrandB", 800, false)
        };
        assertEquals(0, Mobile.findAveragePriceByBrand(mobiles, "BrandC"));
    }

    @Test
    void testFindAveragePriceByBrand_emptyArray() {
        Mobile[] mobiles = {};
        assertEquals(0, Mobile.findAveragePriceByBrand(mobiles, "BrandA"));
    }

    @Test
    void testGetMostExpensive5GEnabledMobile_multiple5G() {
        Mobile[] mobiles = {
            new Mobile("Model X", "BrandA", 1000, true),
            new Mobile("Model Y", "BrandA", 800, false),
            new Mobile("Model Z", "BrandB", 1200, true)
        };
        Mobile mostExpensive = Mobile.getMostExpensive5GEnabledMobile(mobiles);
        assertNotNull(mostExpensive);
        assertEquals("Model Z", mostExpensive.getMobileName());
        assertEquals(1200, mostExpensive.getPrice());
    }

    @Test
    void testGetMostExpensive5GEnabledMobile_single5G() {
        Mobile[] mobiles = {
            new Mobile("Model X", "BrandA", 1000, true),
            new Mobile("Model Y", "BrandA", 800, false)
        };
        Mobile mostExpensive = Mobile.getMostExpensive5GEnabledMobile(mobiles);
        assertNotNull(mostExpensive);
        assertEquals("Model X", mostExpensive.getMobileName());
    }

    @Test
    void testGetMostExpensive5GEnabledMobile_no5G() {
        Mobile[] mobiles = {
            new Mobile("Model X", "BrandA", 1000, false),
            new Mobile("Model Y", "BrandA", 800, false)
        };
        Mobile mostExpensive = Mobile.getMostExpensive5GEnabledMobile(mobiles);
        assertNull(mostExpensive);
    }

    @Test
    void testGetMostExpensive5GEnabledMobile_emptyArray() {
        Mobile[] mobiles = {};
        Mobile mostExpensive = Mobile.getMostExpensive5GEnabledMobile(mobiles);
        assertNull(mostExpensive);
    }

    @Test
    void testCountMobilesByBrand_existingBrand() {
        Mobile[] mobiles = {
            new Mobile("Model X", "BrandA", 1000, true),
            new Mobile("Model Y", "BrandA", 800, false),
            new Mobile("Model Z", "BrandB", 1200, true)
        };
        assertEquals(2, Mobile.countMobilesByBrand(mobiles, "BrandA"));
    }

    @Test
    void testCountMobilesByBrand_nonExistentBrand() {
        Mobile[] mobiles = {
            new Mobile("Model X", "BrandA", 1000, true),
            new Mobile("Model Y", "BrandB", 800, false)
        };
        assertEquals(0, Mobile.countMobilesByBrand(mobiles, "BrandC"));
    }

    @Test
    void testCountMobilesByBrand_emptyArray() {
        Mobile[] mobiles = {};
        assertEquals(0, Mobile.countMobilesByBrand(mobiles, "BrandA"));
    }

    @Test
    void testCountMobilesByBrand_caseSensitive() {
        Mobile[] mobiles = {
            new Mobile("Model X", "BrandA", 1000, true),
            new Mobile("Model Y", "branda", 800, false)
        };
        assertEquals(1, Mobile.countMobilesByBrand(mobiles, "BrandA"));
        assertEquals(1, Mobile.countMobilesByBrand(mobiles, "branda"));
    }
}