package com.ray8118.ipa.oops;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class DishTest {

    private final Dish[] dishes = {
        new Dish("Butter Chicken", "Indian", 15.50, false),
        new Dish("Palak Paneer", "Indian", 12.00, true),
        new Dish("Taco", "Mexican", 5.00, false),
        new Dish("Enchilada", "Mexican", 8.50, true),
        new Dish("Salad", "Continental", 7.00, true)
    };

    @Test
    void testFindDishesByCuisine_existingCuisine() {
        Dish[] result = Dish.findDishesByCuisine(dishes, "Indian");
        assertEquals(2, result.length);
        assertTrue(Arrays.stream(result).anyMatch(d -> d.getDishName().equals("Butter Chicken")));
        assertTrue(Arrays.stream(result).anyMatch(d -> d.getDishName().equals("Palak Paneer")));
    }

    @Test
    void testFindDishesByCuisine_nonExistingCuisine() {
        Dish[] result = Dish.findDishesByCuisine(dishes, "Italian");
        assertEquals(0, result.length);
    }

    @Test
    void testFindDishesByCuisine_emptyArray() {
        Dish[] result = Dish.findDishesByCuisine(new Dish[0], "Indian");
        assertEquals(0, result.length);
    }

    @Test
    void testGetAveragePriceByCuisine_existingCuisine() {
        double average = Dish.getAveragePriceByCuisine(dishes, "Mexican");
        assertEquals(6.75, average, 0.01); // (5.00 + 8.50) / 2 = 6.75
    }

    @Test
    void testGetAveragePriceByCuisine_nonExistingCuisine() {
        double average = Dish.getAveragePriceByCuisine(dishes, "Chinese");
        assertEquals(0.0, average, 0.01);
    }

    @Test
    void testGetVegetarianDishes_multipleVeg() {
        Dish[] result = Dish.getVegetarianDishes(dishes);
        assertEquals(3, result.length);
        assertTrue(Arrays.stream(result).allMatch(Dish::isVegetarian));
    }

    @Test
    void testGetVegetarianDishes_noVeg() {
        Dish[] nonVegDishes = {
            new Dish("Steak", "American", 25.00, false),
            new Dish("Burger", "American", 10.00, false)
        };
        Dish[] result = Dish.getVegetarianDishes(nonVegDishes);
        assertEquals(0, result.length);
    }
}