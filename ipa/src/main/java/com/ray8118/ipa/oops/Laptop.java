// ### 🔷 **Problem 11 – Laptop Class: Performance Analysis**

// Create a `Laptop` class with:

// * `model` (String)
// * `brand` (String)
// * `price` (int)
// * `ram` (int) - in GB
// * `storage` (int) - in GB

// Write:

// 1. A method `findLaptopsByRam(Laptop[] laptops, int minRam)` to return an array of laptops with RAM greater than or equal to `minRam`. Return an empty array if none found.
// 2. A method `getAveragePriceByBrand(Laptop[] laptops, String brand)` to return the average price of laptops from the given brand. Return 0 if no laptops from the brand exist.
// 3. A method `getLaptopWithMaxStorage(Laptop[] laptops)` to return the laptop with the highest storage capacity. Return null if no laptops exist.

package com.ray8118.ipa.oops;

import java.util.ArrayList;
import java.util.List;

public class Laptop {
    private String model;
    private String brand;
    private int price;
    private int ram;
    private int storage;

    public Laptop() {

    }

    public Laptop(String model, String brand, int price, int ram, int storage) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.ram = ram;
        this.storage = storage;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public Laptop[] findLaptopsByRam(Laptop[] laptops, int minRam) {
        List<Laptop> minRamLaptops = new ArrayList<>();
        if (laptops == null) {
            return new Laptop[0];
        }
        for (Laptop laptop : laptops) {
            if (laptop.getRam() >= minRam) {
                minRamLaptops.add(laptop);
            }
        }
        return minRamLaptops.toArray(new Laptop[0]);
    }

    public int getAveragePriceByBrand(Laptop[] laptops, String brand) {
        if (laptops == null) {
            return 0;
        }

        int totalPrice = 0;
        int count = 0;
        for (Laptop laptop : laptops) {
            if (laptop.getBrand().equals(brand)) {
                totalPrice += laptop.getPrice();
                count++;
            }
        }

        return count == 0 ? 0 : (totalPrice / count);
    }

    public Laptop getLaptopWithMaxStorage(Laptop[] laptops) {
        Laptop maxStoragelaptop = null;
        for (Laptop laptop : laptops) {
            if (maxStoragelaptop == null || laptop.getStorage() > maxStoragelaptop.getStorage()) {
                maxStoragelaptop = laptop;
            }
        }
        return maxStoragelaptop;
    }
}
