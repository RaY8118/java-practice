//
// ### 🔷 **Problem 3 – Book Class with Sorting**
//
// Create a `Book` class with:
//
// * `bookName` (String)
// * `author` (String)
// * `price` (int)
//
// Write:
//
// 1. A method `getBooksSortedByPrice(Book[] books)` that returns an array of
// books sorted by their price in ascending order.
//

import java.util.List;
import java.util.Scanner;

public class Book {
  private String bookName;
  private String author;
  private int price;

  public Book(String bookName, String author, int price) {
    this.bookName = bookName;
    this.author = author;
    this.price = price;
  }

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
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

  @Override
  public String toString() {
    return "Book [bookName=" + bookName + ", author=" + author + ", price=" + price + "]";
  }

  public static Book[] getBooksSortedByPrice(Book[] books) {
    Book[] copiedBooks = books.clone();
    for (int i = 0; i < copiedBooks.length - 1; i++) {
      for (int j = 0; j < copiedBooks.length - i - 1; j++) {
        if (copiedBooks[j].getPrice() > copiedBooks[j + 1].getPrice()) {
          Book temp = copiedBooks[j];
          copiedBooks[j] = copiedBooks[j + 1];
          copiedBooks[j + 1] = temp;
        }
      }
    }
    return copiedBooks;
  }

  public static void main(String[] args) {
    Book[] books = new Book[4];
    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < books.length; i++) {
      String bookName = sc.nextLine();
      String author = sc.nextLine();
      int price = sc.nextInt();

      sc.nextLine();

      books[i] = new Book(bookName, author, price);
    }

    Book[] sortedBooks = getBooksSortedByPrice(books);
    for (Book book : sortedBooks) {
      System.out.println(book);
    }

    sc.close();

  }

}
