package services;

import models.Book;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
  private List<Book> books = new ArrayList<>();

  public void addBook(Book book) {
    books.add(book);
    System.out.println("Book added: " + book);
  }

  public void removeBook(String bookId) {
    books.removeIf(book -> book.getId().equals(bookId));
    System.out.println("Book removedf with ID: " + bookId);
  }

  public void listAvailableBooks() {
    System.out.println("Avaiable Books:");
    for (Book book : books) {
      if (book.isAvailable()) {
        System.out.println(book);
      }
    }
  }

  public void borrowBook(String bookId, User user) {
    for (Book book : books) {
      if (book.getId().equals(bookId) && book.isAvailable()) {
        book.setAvailable(false);
        user.borrowBook(book);
        System.out.println(user.getName() + " borrowed:" + book.getTitle());
      }
    }
    System.out.println("Book not available for borrowing!");
  }

  public void returnBook(String bookId, User user) {
    for (Book book : user.getBorrowedBooks()) {
      if (book.getId().equals(bookId)) {
        book.setAvailable(true);
        user.returnBook(book);
        System.out.println(user.getName() + " returned: " + book.getTitle());
        return;
      }
    }
    System.out.println("Book not found in user's borrowed list!");
  }
}
