// ### 🔷 **Problem 17 – Restaurant Class: Menu Analysis**

// Create a `Dish` class with:

// * `dishName` (String)
// * `cuisine` (String)
// * `price` (double)
// * `isVegetarian` (boolean)

// Write:

// 1. A method `findDishesByCuisine(Dish[] dishes, String cuisine)` to return an array of dishes from the given cuisine. Return an empty array if none found.
// 2. A method `getAveragePriceByCuisine(Dish[] dishes, String cuisine)` to return the average price of dishes from the given cuisine. Return 0 if no dishes from the cuisine exist.
// 3. A method `getVegetarianDishes(Dish[] dishes)` to return an array of all vegetarian dishes. Return an empty array if none found.

// ---

package com.ray8118.ipa.oops;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    private String dishName;
    private String cuisine;
    private double price;
    private boolean isVegetarian;

    public Dish() {
    }

    public Dish(String dishName, String cuisine, double price, boolean isVegetarian) {
        this.dishName = dishName;
        this.cuisine = cuisine;
        this.price = price;
        this.isVegetarian = isVegetarian;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean isVegetarian) {
        this.isVegetarian = isVegetarian;
    }

    public static Dish[] findDishesByCuisine(Dish[] dishes, String cuisine) {
        if (dishes == null) {
            return new Dish[0];
        }
        List<Dish> cuisineDishes = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.getCuisine().equals(cuisine)) {
                cuisineDishes.add(dish);
            }
        }
        return cuisineDishes.toArray(new Dish[0]);
    }

    public static double getAveragePriceByCuisine(Dish[] dishes, String cuisine) {
        double totalPrice = 0;
        double count = 0;
        for (Dish dish : dishes) {
            if (dish.getCuisine().equals(cuisine)) {
                totalPrice += dish.getPrice();
                count++;
            }
        }

        return count == 0 ? 0 : (totalPrice / count);
    }

    public static Dish[] getVegetarianDishes(Dish[] dishes) {
        if (dishes == null) {
            return new Dish[0];
        }
        List<Dish> vegetarianDishes = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.isVegetarian()) {
                vegetarianDishes.add(dish);
            }
        }
        return vegetarianDishes.toArray(new Dish[0]);

    }
}
