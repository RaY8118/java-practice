// 🔷 Problem 1 – Mobile Class and Price Calculation
//
// Create a class Mobile with:
//     mobileName (String)
//     brand (String)
//     price (int)
//     is5GEnabled (boolean)
//
// Write:
//     A method findAveragePriceByBrand(Mobile[] mobiles, String brand) to return average price of mobiles from the given brand.
//     If no mobiles with the brand exist, return 0.
//     A method getMostExpensive5GEnabledMobile(Mobile[] mobiles) to return the Mobile object with highest price among 5G-enabled mobiles.
//     Return null if none found.
//

import java.util.Scanner;

/**
 * Mobile
 */
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
    for (int i = 0; i < mobiles.length; i++) {
      for (int j = i + 1; j < mobiles.length; j++) {
        if (mobiles[i].getPrice() > mobiles[j].getPrice()) {
          Mobile temp = mobiles[i];
          mobiles[i] = mobiles[j];
          mobiles[j] = temp;
        }
      }
    }
    return mobiles[mobiles.length - 1];
  }

  @Override
  public String toString() {
    return "Mobile Name: " + mobileName + "\nBrand: " + brand + "\nPrice: " + price + "\n5G Enabled: " + is5GEnabled;
  }

  public static void main(String[] args) {
    Mobile[] mobiles = new Mobile[4];
    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < mobiles.length; i++) {
      String mobileName = sc.nextLine();
      String brand = sc.nextLine();
      int price = sc.nextInt();
      boolean is5GEnabled = sc.nextBoolean();

      sc.nextLine();

      mobiles[i] = new Mobile(mobileName, brand, price, is5GEnabled);
    }

    String newBrand = sc.nextLine();
    int avgPrice = findAveragePriceByBrand(mobiles, newBrand);

    System.out.println(avgPrice);

    Mobile mobile = getMostExpensive5GEnabledMobile(mobiles);
    if (mobile != null) {
      System.out.println(mobile.toString());
    } else {
      System.out.println("No mobile found");
    }

    sc.close();
  }
}
