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

}
