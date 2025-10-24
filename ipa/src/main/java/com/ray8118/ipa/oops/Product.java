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

import com.ray8118.ipa.TestHelper;

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
    // Sample Product data
    Product[] products = {
        new Product("P001", "Laptop", "Electronics", 1200.00, 10),
        new Product("P002", "Mouse", "Electronics", 25.00, 50),
        new Product("P003", "Keyboard", "Electronics", 75.00, 20),
        new Product("P004", "Desk Chair", "Furniture", 150.00, 5),
        new Product("P005", "Monitor", "Electronics", 300.00, 15),
        new Product("P006", "Table", "Furniture", 200.00, 8),
        new Product("P007", "Webcam", "Electronics", 50.00, 0) // Zero stock
    };

    // Test findProductsByCategory
    System.out.println("--- Testing findProductsByCategory ---");
    Product[] electronicsProducts = Product.findProductsByCategory(products, "Electronics");
    TestHelper.assertEqual("findProductsByCategory - Electronics", 5, electronicsProducts.length);

    Product[] furnitureProducts = Product.findProductsByCategory(products, "Furniture");
    TestHelper.assertEqual("findProductsByCategory - Furniture", 2, furnitureProducts.length);

    Product[] nonExistentCategory = Product.findProductsByCategory(products, "Books");
    TestHelper.assertEqual("findProductsByCategory - Non-existent", 0, nonExistentCategory.length);

    Product[] emptyProducts = {};
    Product[] resultFromEmpty = Product.findProductsByCategory(emptyProducts, "Electronics");
    TestHelper.assertEqual("findProductsByCategory - Empty array", 0, resultFromEmpty.length);

    // Test calculateTotalInventoryValue
    System.out.println("\n--- Testing calculateTotalInventoryValue ---");
    double totalValue = Product.calculateTotalInventoryValue(products);
    // (1200*10) + (25*50) + (75*20) + (150*5) + (300*15) + (200*8) + (50*0)
    // 12000 + 1250 + 1500 + 750 + 4500 + 1600 + 0 = 21600
    TestHelper.assertEqual("calculateTotalInventoryValue - All products", 21600.00, totalValue);

    double emptyValue = Product.calculateTotalInventoryValue(emptyProducts);
    TestHelper.assertEqual("calculateTotalInventoryValue - Empty array", 0.00, emptyValue);

    // Test getLowStockProducts
    System.out.println("\n--- Testing getLowStockProducts ---");
    Product[] lowStockThreshold10 = Product.getLowStockProducts(products, 10);
    // Mouse (50), Desk Chair (5), Table (8), Webcam (0)
    TestHelper.assertEqual("getLowStockProducts - Threshold 10", 4, lowStockThreshold10.length);

    Product[] lowStockThreshold5 = Product.getLowStockProducts(products, 5);
    // Desk Chair (5), Webcam (0)
    TestHelper.assertEqual("getLowStockProducts - Threshold 5", 2, lowStockThreshold5.length);

    Product[] noLowStock = Product.getLowStockProducts(products, 0);
    TestHelper.assertEqual("getLowStockProducts - Threshold 0", 1, noLowStock.length);

    Product[] lowStockEmpty = Product.getLowStockProducts(emptyProducts, 10);
    TestHelper.assertEqual("getLowStockProducts - Empty array", 0, lowStockEmpty.length);

  }
}
