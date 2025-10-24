package com.ray8118.ipa.oops;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookTest {

    private Book[] books;

    @BeforeEach
    void setUp() {
        books = new Book[] {
                new Book("The Great Gatsby", "F. Scott Fitzgerald", 10, "Fiction", 3),
                new Book("To Kill a Mockingbird", "Harper Lee", 12, "Fiction", 5),
                new Book("Pride and Prejudice", "Jane Austen", 15, "Fiction", 4),
                new Book("The Catcher in the Rye", "J.D. Salinger", 13, "Fiction", 4),
                new Book("1984", "George Orwell", 6, "Fiction", 4),
                new Book("Animal Farm", "George Orwell", 20, "Fiction", 4)
        };
    }

    @Test
    void testGetAverageRatingByGenre_Fiction() {
        int avgRating = Book.getAverageRatingByGenre(books, "Fiction");
        assertEquals(4, avgRating, "Average rating for Fiction should be 4");
    }

    @Test
    void testGetAverageRatingByGenre_NonFiction() {
        int avgRating = Book.getAverageRatingByGenre(books, "Non-Fiction");
        assertEquals(0, avgRating, "Average rating for Non-Fiction should be 0 (no books)");
    }

    @Test
    void testGetMostExpensiveBookByAuthor_ExistingAuthor() {
        Book mostExpensive = Book.getMostExpensiveBookByAuthor(books, "George Orwell");
        assertNotNull(mostExpensive, "Should return a book for existing author");
        assertEquals("Animal Farm", mostExpensive.getTitle(), "Most expensive book should be 'Animal Farm'");
        assertEquals(20, mostExpensive.getPrice(), "Price should match the most expensive one");
    }

    @Test
    void testGetMostExpensiveBookByAuthor_SingleBookAuthor() {
        Book mostExpensive = Book.getMostExpensiveBookByAuthor(books, "J.D. Salinger");
        assertNotNull(mostExpensive, "Should return a book for J.D. Salinger");
        assertEquals("The Catcher in the Rye", mostExpensive.getTitle(), "Only one book should be returned");
        assertEquals(13, mostExpensive.getPrice(), "Price should be 13");
    }

    @Test
    void testGetMostExpensiveBookByAuthor_NoBooks() {
        Book[] noBooks = {};
        Book result = Book.getMostExpensiveBookByAuthor(noBooks, "J.D. Salinger");
        assertNull(result, "Should return null when no books exist");
    }

    @Test
    void testGetMostExpensiveBookByAuthor_NoMatchingAuthor() {
        Book result = Book.getMostExpensiveBookByAuthor(books, "Unknown Author");
        assertNull(result, "Should return null for an author with no books");
    }
}
