package com.ray8118.ipa.oops;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    void testFindProductsByCategory_existingCategory() {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics", 1200.00, 10),
            new Product("P002", "Mouse", "Electronics", 25.00, 50),
            new Product("P003", "Keyboard", "Electronics", 75.00, 20),
            new Product("P004", "Desk Chair", "Furniture", 150.00, 5)
        };
        Product[] electronics = Product.findProductsByCategory(products, "Electronics");
        assertEquals(3, electronics.length);
    }

    @Test
    void testFindProductsByCategory_nonExistentCategory() {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics", 1200.00, 10),
            new Product("P002", "Mouse", "Electronics", 25.00, 50)
        };
        Product[] books = Product.findProductsByCategory(products, "Books");
        assertEquals(0, books.length);
    }

    @Test
    void testFindProductsByCategory_emptyArray() {
        Product[] products = {};
        Product[] result = Product.findProductsByCategory(products, "Electronics");
        assertEquals(0, result.length);
    }

    @Test
    void testCalculateTotalInventoryValue_multipleProducts() {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics", 1200.00, 10),
            new Product("P002", "Mouse", "Electronics", 25.00, 50),
            new Product("P003", "Keyboard", "Electronics", 75.00, 20)
        };
        double totalValue = Product.calculateTotalInventoryValue(products);
        assertEquals(1200*10 + 25*50 + 75*20, totalValue);
    }

    @Test
    void testCalculateTotalInventoryValue_emptyArray() {
        Product[] products = {};
        double totalValue = Product.calculateTotalInventoryValue(products);
        assertEquals(0.0, totalValue);
    }

    @Test
    void testCalculateTotalInventoryValue_zeroStock() {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics", 1200.00, 0)
        };
        double totalValue = Product.calculateTotalInventoryValue(products);
        assertEquals(0.0, totalValue);
    }

    @Test
    void testGetLowStockProducts_threshold10() {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics", 1200.00, 10),
            new Product("P002", "Mouse", "Electronics", 25.00, 50),
            new Product("P003", "Keyboard", "Electronics", 75.00, 20),
            new Product("P004", "Desk Chair", "Furniture", 150.00, 5),
            new Product("P005", "Monitor", "Electronics", 300.00, 15),
            new Product("P006", "Table", "Furniture", 200.00, 8),
            new Product("P007", "Webcam", "Electronics", 50.00, 0)
        };
        Product[] lowStock = Product.getLowStockProducts(products, 10);
        assertEquals(4, lowStock.length);
    }

    @Test
    void testGetLowStockProducts_threshold5() {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics", 1200.00, 10),
            new Product("P004", "Desk Chair", "Furniture", 150.00, 5),
            new Product("P007", "Webcam", "Electronics", 50.00, 0)
        };
        Product[] lowStock = Product.getLowStockProducts(products, 5);
        assertEquals(2, lowStock.length);
    }

    @Test
    void testGetLowStockProducts_noLowStock() {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics", 1200.00, 20),
            new Product("P002", "Mouse", "Electronics", 25.00, 50)
        };
        Product[] lowStock = Product.getLowStockProducts(products, 10);
        assertEquals(0, lowStock.length);
    }

    @Test
    void testGetLowStockProducts_emptyArray() {
        Product[] products = {};
        Product[] lowStock = Product.getLowStockProducts(products, 10);
        assertEquals(0, lowStock.length);
    }
}