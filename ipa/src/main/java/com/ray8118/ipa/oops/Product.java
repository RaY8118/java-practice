// ### 🔷 **Problem 9 – Product Class and Inventory Management**
//
// Create a `Product` class with:
//
// * `productId` (String)
// * `productName` (String)
// * `category` (String)
// * `price` (double)
// * `stockQuantity` (int)
//
// Write:
//
// 1. A method `findProductsByCategory(Product[] products, String category)` to return an array of `Product` objects belonging to the given category. Return an empty array if no products are found.
// 2. A method `calculateTotalInventoryValue(Product[] products)` to return the total monetary value of all products in the inventory (sum of price * stockQuantity for all products).
// 3. A method `getLowStockProducts(Product[] products, int threshold)` to return an array of `Product` objects whose `stockQuantity` is below the given `threshold`. Return an empty array if no such products are found.

package com.ray8118.ipa.oops;

import java.util.ArrayList;
import java.util.List;

public class Product {

  private String productId;
  private String productName;
  private String category;
  private double price;
  private int stockQuantity;

  public Product(String productId, String productName, String category, double price, int stockQuantity) {
    this.productId = productId;
    this.productName = productName;
    this.category = category;
    this.price = price;
    this.stockQuantity = stockQuantity;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
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

  public int getStockQuantity() {
    return stockQuantity;
  }

  public void setStockQuantity(int stockQuantity) {
    this.stockQuantity = stockQuantity;
  }

  @Override
  public String toString() {
    return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category + ", price="
        + price + ", stockQuantity=" + stockQuantity + "]";
  }

  public static Product[] findProductsByCategory(Product[] products, String category) {
    List<Product> categoryProducts = new ArrayList<>();
    for (Product product : products) {
      if (product.getCategory().equals(category)) {
        categoryProducts.add(product);
      }
    }
    return categoryProducts.toArray(new Product[0]);
  }

  public static double calculateTotalInventoryValue(Product[] products) {
    double monetaryValue = 0;
    for (Product product : products) {
      monetaryValue += product.getPrice() * product.getStockQuantity();
    }
    return monetaryValue;
  }

  public static Product[] getLowStockProducts(Product[] products, int threshold) {
    List<Product> lowStockProducts = new ArrayList<>();
    for (Product product : products) {
      if (product.getStockQuantity() <= threshold) {
        lowStockProducts.add(product);
      }
    }
    return lowStockProducts.toArray(new Product[0]);
  }

  public static void main(String[] args) {

  }
}
