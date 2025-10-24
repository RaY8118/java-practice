// Create a class Resort with the below attributes:
// resortld- int
// resortName - String
// category - String
// price- double
// rating - double
// The above attributes should be private, write getters, setters and
// parameterized constructor as required.
// Implement a static method - findAvgPriceByCategory in Solution class.
// findAvgPriceByCategory method:
// This method will take two input parameters - array of Resort objects and
// String parameter.
// The method will return the average price of Resort(as int value) from array
// of Resort objects for the given
// category(String parameter passed) and whose rating is greater than 4.
// If no Resort with the above condition is present in the array of Resort
// objects, then the method should return
// o.
// Note : All the searches should be case insensitive.
// The above mentioned static method should be called from the main method.
// For findAvgPriceByCategory method - The main method should print the returned
// average price of Resort as it
// is, if the returned value is greater than 0 otherwise it should print "There
// are no such available resort"

package com.ray8118.ipa.oops;

import java.util.Scanner;

/**
 * Resort
 */
public class Resort {

  private int resortId;
  private String resortName;
  private String category;
  private double price;
  private double rating;

  public Resort(int resortId, String resortName, String category, double price, double rating) {
    this.resortId = resortId;
    this.resortName = resortName;
    this.category = category;
    this.price = price;
    this.rating = rating;
  }

  public int getResortId() {
    return resortId;
  }

  public void setResortId(int resortId) {
    this.resortId = resortId;
  }

  public String getResortName() {
    return resortName;
  }

  public void setResortName(String resortName) {
    this.resortName = resortName;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public static int findAvgPriceByCategory(Resort[] resorts, String category) {
    int avgAmount = 0;
    int count = 0;
    int totalPrice = 0;

    for (Resort resort : resorts) {
      if (resort.getCategory().equalsIgnoreCase(category) && resort.getRating() > 4) {
        count++;
        totalPrice += resort.getPrice();
      }
    }
    if (count > 0) {
      avgAmount = totalPrice / count;
    }

    return avgAmount;
  }

  public static void main(String[] args) {
    Resort[] resorts = new Resort[4];
    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < resorts.length; i++) {
      int resortId = sc.nextInt();
      sc.nextLine();
      String resortName = sc.nextLine();
      String category = sc.nextLine();
      double price = sc.nextDouble();
      double rating = sc.nextDouble();
      sc.nextLine();
      resorts[i] = new Resort(resortId, resortName, category, price, rating);
    }
    String importantCategory = sc.nextLine();
    int avgPrice = findAvgPriceByCategory(resorts, importantCategory);
    if (avgPrice > 0) {
      System.out.println("Average price of the category:" + avgPrice);
    } else {
      System.out.println("There is no such availlable resort");
    }
    sc.close();
  }
}
