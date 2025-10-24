// Scenario:
// A library keeps track of Book objects having title, author, price, genre, and
// rating.
//
// Tasks:
//
// Create the Book class.
//
// Write getAverageRatingByGenre(String genre) that returns the average rating
// for books of that genre.
//
// Write getMostExpensiveBookByAuthor(String author) that returns the Book
// object with the highest price for that author.
package com.ray8118.ipa;

public class Book {

  private String title;
  private String author;
  private int price;
  private String genre;
  private int rating;

  public Book(String title, String author, int price, String genre, int rating) {
    this.title = title;
    this.author = author;
    this.price = price;
    this.genre = genre;
    this.rating = rating;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  @Override
  public String toString() {
    return "Library [title=" + title + ", author=" + author + ", price=" + price + ", genre=" + genre + ", rating="
        + rating + "]";
  }

  public static int getAverageRatingByGenre(Book[] books, String genre) {
    int totalRating = 0;
    int ratingCount = 0;

    for (Book book : books) {
      if (book.getGenre().equals(genre)) {
        totalRating += book.getRating();
        ratingCount++;
      }
    }
    return ratingCount == 0 ? 0 : (totalRating / ratingCount);
  }

  public static Book getMostExpensiveBookByAuthor(Book[] books, String author) {
    Book expensiveBook = null;
    for (Book book : books) {
      if (book.getAuthor().equals(author)) {
        if (expensiveBook == null || book.getPrice() > expensiveBook.getPrice()) {
          expensiveBook = book;
        }
      }
    }
    return expensiveBook;
  }

  public static void main(String[] args) {
    Book[] books = {
        new Book("The Great Gatsby", "F. Scott Fitzgerald", 10, "Fiction", 3),
        new Book("To Kill a Mockingbird", "Harper Lee", 12, "Fiction", 5),
        new Book("Pride and Prejudice", "Jane Austen", 15, "Fiction", 4),
        new Book("The Catcher in the Rye", "J.D. Salinger", 13, "Fiction", 4),
        new Book("1984", "George Orwell", 6, "Fiction", 4),
        new Book("Animal Farm", "George Orwell", 20, "Fiction", 4),
    };

    // Test getAverageRatingByGenre
    TestHelper.assertEqual("Average rating for Fiction", getAverageRatingByGenre(books, "Fiction"), 4);
    TestHelper.assertEqual("Average rating for Non-Fiction", getAverageRatingByGenre(books, "Non-Fiction"), 0);

    // Test getMostExpensiveBookByAuthor
    Book mostExpensiveBook = getMostExpensiveBookByAuthor(books, "J.D. Salinger");
    TestHelper.assertEqual("Most expensive book by author", mostExpensiveBook.getTitle(), "The Catcher in the Rye");
    TestHelper.assertEqual("Most expensive book by author price", mostExpensiveBook.getPrice(), 13);

    Book[] noBooks = {
    };
    TestHelper.assertEqual("Most expensive book by author (none)",
        getMostExpensiveBookByAuthor(noBooks, "J.D. Salinger"),
        null);
  }
}
