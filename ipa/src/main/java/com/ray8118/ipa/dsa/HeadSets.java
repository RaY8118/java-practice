// Create a class HeadSets with below attributes:
// headsetName - String
// brand-String
// price - int
// available- boolean
// The above attributes should be private, write getters, setters and parameterized constructor
// as required,
// Create class Solution with main method.
// Implement two static methods - findTotalPriceForGivenBrand and
// findAvailableHeadsetWithSecondMinPrice in Solution class.
// findTotalPriceForGivenBrand method:
// The method will return the total price of Headsets from array of Headset objects for the
// given brand(String parameter passed).
// If no Headsets with the given brand is present in the array of Headsets objects, then the
// method should return O.
// findAvailableHeadsetWithSecondMinPrice method:
// This method will take array of Headset objects as an input parameter and returns the
// available Headset Object With the second lowest/minimum price from the given array Of
// objects,
// If no Headsets with the above condition is present in the array of Headsets objects, then the
// method should return null,

package com.ray8118.ipa.dsa;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * HeadSets
 */
public class HeadSets {
  private String headSetName;
  private String brand;
  private int price;
  private boolean available;

  public HeadSets(String headSetName, String brand, int price, boolean available) {
    this.headSetName = headSetName;
    this.brand = brand;
    this.price = price;
    this.available = available;
  }

  public String getHeadSetName() {
    return headSetName;
  }

  public void setHeadSetName(String headSetName) {
    this.headSetName = headSetName;
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

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public static int findTotalPriceForGivenBrand(HeadSets[] headSets, String brand) {
    int totalPrice = 0;

    for (HeadSets headSet : headSets) {
      if (headSet.getBrand().equalsIgnoreCase(brand)) {
        totalPrice += headSet.getPrice();
      }
    }
    return totalPrice;
  }

  public static HeadSets findAvailableHeadsetWithSecondMinPrice(HeadSets[] headSets) {
    // int count = 0;
    //
    // for (HeadSets headSet : headSets) {
    // if (headSet.isAvailable()) {
    // count++;
    // }
    // }
    //
    // HeadSets[] newHeadSets = new HeadSets[count];
    // int k = 0;
    // for (int i = 0; i < headSets.length; i++) {
    // if (headSets[i].isAvailable()) {
    // newHeadSets[k] = headSets[i];
    // k++;
    // }
    // }
    //
    // for (int i = 0; i < newHeadSets.length; i++) {
    // for (int j = i + 1; j < newHeadSets.length; j++) {
    // if (newHeadSets[i].getPrice() > newHeadSets[j].getPrice()) {
    // HeadSets temp = newHeadSets[i];
    // newHeadSets[i] = newHeadSets[j];
    // newHeadSets[j] = temp;
    // }
    // }
    // }
    // if (count > 0) {
    // return newHeadSets[1];
    // } else {
    // return null;
    // }

    List<HeadSets> availableSets = new ArrayList<>();

    for (HeadSets headSet : headSets) {
      if (headSet.isAvailable()) {
        availableSets.add(headSet);
      }
    }

    availableSets.sort(Comparator.comparingInt(HeadSets::getPrice));
    return availableSets.get(1);

  }

  public static void main(String[] args) {
    HeadSets[] headSets = new HeadSets[4];
    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < headSets.length; i++) {
      String headSetName = sc.nextLine();
      String brand = sc.nextLine();
      int price = sc.nextInt();
      boolean available = sc.nextBoolean();

      sc.nextLine();
      headSets[i] = new HeadSets(headSetName, brand, price, available);
    }

    String newBrand = sc.nextLine();
    int sum = findTotalPriceForGivenBrand(headSets, newBrand);
    if (sum > 0) {
      System.out.println(sum);
    } else {
      System.out.println("No headsets available with the given brand name");
    }

    HeadSets headSets2 = findAvailableHeadsetWithSecondMinPrice(headSets);
    if (headSets2 != null) {
      System.out.println(headSets2.getHeadSetName());
      System.out.println(headSets2.getPrice());
    } else {
      System.out.println("No headsets available");
    }
    sc.close();
  }
}
