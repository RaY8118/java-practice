package com.ray8118.ipa.oops;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car[] cars;

    @BeforeEach
    void setUp() {
        cars = new Car[] {
                new Car("Model S", "Tesla", 80000),
                new Car("Mustang", "Ford", 55000),
                new Car("Civic", "Honda", 25000),
                new Car("Accord", "Honda", 30000)
        };
    }

    // Test getLowestPriceCar
    @Test
    void testGetLowestPricedCar() {
        Car lowestPricedCar = Car.getLowestPricedCar(cars);
        assertEquals("Civic", lowestPricedCar.getModelName(), "Lowest priced car is Civic");
        assertEquals(25000, lowestPricedCar.getPrice(), "Lowest price car price is 25000");
    }

    // Test getHighestPriceCar
    @Test
    void testGetHighestPricedCar() {
        Car highestPricedCar = Car.getHighestPricedCar(cars);
        assertEquals("Model S", highestPricedCar.getModelName(), "Highest priced car is Model S");
        assertEquals(80000, highestPricedCar.getPrice(), "Lowest price car price is 80000");
    }

    // Test filterCarsByBrand
    @Test
    void testFilterCarsByBrand_Honda() {
        Car[] hondaCars = Car.filterCarsByBrand(cars, "Honda");
        assertEquals(2, hondaCars.length, "Number of Honda cars");
        assertEquals("Civic", hondaCars[0].getModelName(), "First Honda car is Civic");
        assertEquals("Accord", hondaCars[1].getModelName(), "Second Honda car is Accord");
    }

    @Test
    void testFilterCarsByBrand_Ford() {
        Car[] fordCars = Car.filterCarsByBrand(cars, "Ford");
        assertEquals(1, fordCars.length, "Number of Ford cars");
        assertEquals("Mustang", fordCars[0].getModelName(), "Ford car is Mustang");
    }

    @Test
    void testFilterCarsByBrand_BMW() {
        Car[] bmwCars = Car.filterCarsByBrand(cars, "BMW");
        assertEquals(0, bmwCars.length, "No BMW car");
    }

    // Edge case: empty array
    @Test
    void testEmptyArray() {
        Car[] emptyCars = {};
        assertEquals(null, Car.getLowestPricedCar(emptyCars), "Lowest price frm empty array");
        assertEquals(null, Car.getHighestPricedCar(emptyCars), "Lowest price frm empty array");
        Car[] emptyFiltered = Car.filterCarsByBrand(emptyCars, "Tesla");
        assertEquals(0, emptyFiltered.length, "Filtered cars from empty array");
    }

    // Edge case: null input
    @Test
    void testNullInput() {
        assertEquals(null, Car.getLowestPricedCar(null), "Lowest price car frm null");
        assertEquals(null, Car.getHighestPricedCar(null), "Highest price car frm null");
        Car[] nullFiltered = Car.filterCarsByBrand(null, "Honda");
        assertEquals(0, nullFiltered.length, "Filtered cars from null input");

    }
}
