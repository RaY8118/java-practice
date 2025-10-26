package com.ray8118.ipa.oops;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LaptopTest {

    @Test
    @DisplayName("Find laptops with RAM greater than or equal to minimum requirement")
    public void testFindLaptopsByRam() {
        Laptop[] laptops = {
                new Laptop("XPS 15", "Dell", 120000, 16, 512),
                new Laptop("MacBook Air", "Apple", 110000, 8, 256),
                new Laptop("ThinkPad X1", "Lenovo", 90000, 32, 1024)
        };

        Laptop utils = new Laptop();
        Laptop[] result = utils.findLaptopsByRam(laptops, 16);

        assertEquals(2, result.length);
        assertEquals("XPS 15", result[0].getModel());
        assertEquals("ThinkPad X1", result[1].getModel());
    }

    @Test
    @DisplayName("Return empty array when no laptops meet RAM criteria")
    public void testFindLaptopsByRam_NoMatch() {
        Laptop[] laptops = {
                new Laptop("MacBook Air", "Apple", 110000, 8, 256)
        };

        Laptop utils = new Laptop();
        Laptop[] result = utils.findLaptopsByRam(laptops, 16);

        assertEquals(0, result.length);
    }

    @Test
    @DisplayName("Get average price for a given brand")
    public void testGetAveragePriceByBrand() {
        Laptop[] laptops = {
                new Laptop("XPS 15", "Dell", 120000, 16, 512),
                new Laptop("Inspiron 14", "Dell", 80000, 8, 256),
                new Laptop("MacBook Air", "Apple", 110000, 8, 256)
        };

        Laptop utils = new Laptop();
        double avg = utils.getAveragePriceByBrand(laptops, "Dell");

        assertEquals(100000.0, avg);
    }

    @Test
    @DisplayName("Return 0 when no laptops found for brand")
    public void testGetAveragePriceByBrand_NoMatch() {
        Laptop[] laptops = {
                new Laptop("MacBook Air", "Apple", 110000, 8, 256)
        };

        Laptop utils = new Laptop();
        double avg = utils.getAveragePriceByBrand(laptops, "HP");

        assertEquals(0.0, avg);
    }

    @Test
    @DisplayName("Get laptop with maximum storage")
    public void testGetLaptopWithMaxStorage() {
        Laptop[] laptops = {
                new Laptop("XPS 15", "Dell", 120000, 16, 512),
                new Laptop("ThinkPad X1", "Lenovo", 90000, 32, 1024),
                new Laptop("MacBook Air", "Apple", 110000, 8, 256)
        };

        Laptop utils = new Laptop();
        Laptop maxStorageLaptop = utils.getLaptopWithMaxStorage(laptops);

        assertEquals("ThinkPad X1", maxStorageLaptop.getModel());
        assertEquals(1024, maxStorageLaptop.getStorage());
    }

    @Test
    @DisplayName("Return null when no laptops exist")
    public void testGetLaptopWithMaxStorage_Empty() {
        Laptop[] laptops = {};

        Laptop utils = new Laptop();
        Laptop maxStorageLaptop = utils.getLaptopWithMaxStorage(laptops);

        assertEquals(null, maxStorageLaptop);
    }
}
