// ### 🔷 **Problem 7 – Car Class: Lowest and Highest Price**
//
// Create `Car` class with:
//
// * `modelName` (String)
// * `brand` (String)
// * `price` (int)
//
// Write:
//
// 1. A method to return the `Car` object with **lowest price**.
// 2. A method to return the `Car` object with **highest price**.
// 3. A method `filterCarsByBrand(Car[] cars, String brand)` that returns an
// array of cars for a given brand. Return an empty array if no cars for the
// brand are found.
//
// If no cars exist, return null.

package com.ray8118.ipa.oops;

import java.util.ArrayList;
import java.util.List;

import com.ray8118.ipa.TestHelper;

public class Car {

  private String modelName;
  private String brand;
  private int price;

  public Car(String modelName, String brand, int price) {
    this.modelName = modelName;
    this.brand = brand;
    this.price = price;
  }

  public String getModelName() {
    return modelName;
  }

  public void setModelName(String modelName) {
    this.modelName = modelName;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Car [modelName=" + modelName + ", brand=" + brand + ", price=" + price + "]";
  }

  public static Car getLowestPricedCar(Car[] cars) {
    if (cars == null) {
      return null;
    }
    Car lowestPricedCar = null;
    for (Car car : cars) {
      if (lowestPricedCar == null || car.getPrice() < lowestPricedCar.getPrice()) {
        lowestPricedCar = car;
      }
    }
    return lowestPricedCar;
  }

  public static Car getHighestPricedCar(Car[] cars) {
    if (cars == null) {
      return null;
    }
    Car highestPricedCar = null;
    for (Car car : cars) {
      if (highestPricedCar == null || car.getPrice() > highestPricedCar.getPrice()) {
        highestPricedCar = car;
      }
    }
    return highestPricedCar;
  }

  public static Car[] filterCarsByBrand(Car[] cars, String brand) {
    if (cars == null) {
      return new Car[0];
    }
    List<Car> filteredCars = new ArrayList<>();
    for (Car car : cars) {
      if (car.getBrand().equals(brand)) {
        filteredCars.add(car);
      }
    }
    return filteredCars.toArray(new Car[0]);
  }

  public static void main(String[] args) {
    // Test data
    Car[] cars = {
        new Car("Model S", "Tesla", 80000),
        new Car("Mustang", "Ford", 55000),
        new Car("Civic", "Honda", 25000),
        new Car("Accord", "Honda", 30000)
    };

    // 1️⃣ Test getLowestPriceCar
    Car lowestPriceCar = getLowestPricedCar(cars);
    TestHelper.assertEqual("Lowest price car is Civic", lowestPriceCar.getModelName(), "Civic");
    TestHelper.assertEqual("Lowest price car price is 25000", lowestPriceCar.getPrice(), 25000);

    // 2️⃣ Test getHighestPriceCar
    Car highestPriceCar = getHighestPricedCar(cars);
    TestHelper.assertEqual("Highest price car is Model S", highestPriceCar.getModelName(), "Model S");
    TestHelper.assertEqual("Highest price car price is 80000", highestPriceCar.getPrice(), 80000);

    // 3️⃣ Test filterCarsByBrand
    Car[] hondaCars = filterCarsByBrand(cars, "Honda");
    TestHelper.assertEqual("Number of Honda cars", hondaCars.length, 2);
    TestHelper.assertEqual("First Honda car is Civic", hondaCars[0].getModelName(), "Civic");
    TestHelper.assertEqual("Second Honda car is Accord", hondaCars[1].getModelName(), "Accord");

    Car[] fordCars = filterCarsByBrand(cars, "Ford");
    TestHelper.assertEqual("Number of Ford cars", fordCars.length, 1);
    TestHelper.assertEqual("Ford car is Mustang", fordCars[0].getModelName(), "Mustang");

    Car[] bmwCars = filterCarsByBrand(cars, "BMW");
    TestHelper.assertEqual("No BMW cars", bmwCars.length, 0);

    // 4️⃣ Edge case: empty array
    Car[] emptyCars = {};
    TestHelper.assertEqual("Lowest price car from empty array", getLowestPricedCar(emptyCars), null);
    TestHelper.assertEqual("Highest price car from empty array", getHighestPricedCar(emptyCars), null);
    Car[] emptyFiltered = Car.filterCarsByBrand(emptyCars, "Tesla");
    TestHelper.assertEqual("Filtered cars from empty array", emptyFiltered.length, 0);

    // 5️⃣ Edge case: null input (optional, if your methods handle null)
    TestHelper.assertEqual("Lowest price car from null", getLowestPricedCar(null), null);
    TestHelper.assertEqual("Highest price car from null", getHighestPricedCar(null), null);
    Car[] nullFiltered = filterCarsByBrand(null, "Honda");
    TestHelper.assertEqual("Filtered cars from null input", nullFiltered.length, 0);
  }
}
