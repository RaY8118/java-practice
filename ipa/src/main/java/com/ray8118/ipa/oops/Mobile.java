// ### 🔷 **Problem 1 – Mobile Class and Price Calculation**
//
// Create a class `Mobile` with:
//
// * `mobileName` (String)
// * `brand` (String)
// * `price` (int)
// * `is5GEnabled` (boolean)
//
// Write:
//
// 1. A method `findAveragePriceByBrand(Mobile[] mobiles, String brand)` to return average price of mobiles from the given brand. If no mobiles with the brand exist, return 0.
// 2. A method `getMostExpensive5GEnabledMobile(Mobile[] mobiles)` to return the `Mobile` object with highest price among 5G-enabled mobiles. Return null if none found.
// 3. A method `countMobilesByBrand(Mobile[] mobiles, String brand)` to return the number of mobiles for a given brand. If no mobiles with the brand exist, return 0.
//

package com.ray8118.ipa.oops;

import com.ray8118.ipa.TestHelper;

public class Mobile {

  private String mobileName;
  private String brand;
  private int price;
  private boolean is5GEnabled;

  public Mobile(String mobileName, String brand, int price, boolean is5GEnabled) {
    this.mobileName = mobileName;
    this.brand = brand;
    this.price = price;
    this.is5GEnabled = is5GEnabled;
  }

  public String getMobileName() {
    return mobileName;
  }

  public void setMobileName(String mobileName) {
    this.mobileName = mobileName;
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

  public boolean isIs5GEnabled() {
    return is5GEnabled;
  }

  public void setIs5GEnabled(boolean is5gEnabled) {
    is5GEnabled = is5gEnabled;
  }

  public static int findAveragePriceByBrand(Mobile[] mobiles, String brand) {
    int totalPrice = 0;
    int count = 0;
    int avgPrice = 0;

    for (Mobile mobile : mobiles) {
      if (mobile.getBrand().equalsIgnoreCase(brand)) {
        totalPrice += mobile.getPrice();
        count++;
      }
    }
    if (count > 0) {
      avgPrice = totalPrice / count;
    }

    return avgPrice;
  }

  public static Mobile getMostExpensive5GEnabledMobile(Mobile[] mobiles) {
    Mobile mostExpensive = null;
    for (Mobile mobile : mobiles) {
      if (mobile.isIs5GEnabled()) {
        if (mostExpensive == null || mobile.getPrice() > mostExpensive.getPrice()) {
          mostExpensive = mobile;
        }
      }
    }
    return mostExpensive;
  }

  public static int countMobilesByBrand(Mobile[] mobiles, String brand) {
    int count = 0;
    for (Mobile mobile : mobiles) {
      if (mobile.getBrand().equals(brand)) {
        count++;
      }
    }
    return count;
  }

  @Override
  public String toString() {
    return "Mobile Name: " + mobileName + "\nBrand: " + brand + "\nPrice: " + price + "\n5G Enabled: " + is5GEnabled;
  }

  public static void main(String[] args) {
    Mobile[] mobiles = {
        new Mobile("Model X", "BrandA", 1000, true),
        new Mobile("Model Y", "BrandA", 800, false),
        new Mobile("Model Z", "BrandB", 1200, true),
        new Mobile("Model W", "BrandC", 500, false),
        new Mobile("Model V", "BrandA", 900, true)
    };

    // Test findAveragePriceByBrand
    TestHelper.assertEqual("Average price for BrandA", findAveragePriceByBrand(mobiles, "BrandA"), 900);
    TestHelper.assertEqual("Average price for BrandB", findAveragePriceByBrand(mobiles, "BrandB"), 1200);
    TestHelper.assertEqual("Average price for BrandC", findAveragePriceByBrand(mobiles, "BrandC"), 500);
    TestHelper.assertEqual("Average price for BrandD (non-existent)", findAveragePriceByBrand(mobiles, "BrandD"), 0);

    // Test getMostExpensive5GEnabledMobile
    Mobile mostExpensive5G = getMostExpensive5GEnabledMobile(mobiles);
    TestHelper.assertEqual("Most expensive 5G enabled mobile name", mostExpensive5G.getMobileName(), "Model Z");
    TestHelper.assertEqual("Most expensive 5G enabled mobile brand", mostExpensive5G.getBrand(), "BrandB");
    TestHelper.assertEqual("Most expensive 5G enabled mobile price", mostExpensive5G.getPrice(), 1200);

    // Test countMobilesByBrand
    TestHelper.assertEqual("Count of mobiles for BrandA", countMobilesByBrand(mobiles, "BrandA"), 3);
    TestHelper.assertEqual("Count of mobiles for BrandB", countMobilesByBrand(mobiles, "BrandB"), 1);
    TestHelper.assertEqual("Count of mobiles for BrandC", countMobilesByBrand(mobiles, "BrandC"), 1);
    TestHelper.assertEqual("Count of mobiles for BrandD (non-existent)", countMobilesByBrand(mobiles, "BrandD"), 0);

    Mobile[] no5GMobiles = {
        new Mobile("Old Phone", "BrandX", 300, false),
        new Mobile("Another Old Phone", "BrandY", 200, false)
    };
    TestHelper.assertEqual("Most expensive 5G enabled mobile (none)",

        getMostExpensive5GEnabledMobile(no5GMobiles),
        null);
  }
}
