package models;

import java.util.ArrayList;
import java.util.List;

public class User {
  private String userId;
  private String name;
  private List<Book> borrowedBooks;

  public User(String userId, String name) {
    this.userId = userId;
    this.name = name;
    this.borrowedBooks = new ArrayList<>();
  }

  public String getUserId() {
    return userId;
  }

  public String getName() {
    return name;
  }

  public List<Book> getBorrowedBooks() {
    return borrowedBooks;
  }

  public void borrowBook(Book book) {
    borrowedBooks.add(book);
  }

  public void returnBook(Book book) {
    borrowedBooks.remove(book);
  }

  @Override
  public String toString() {
    return userId + " | " + name + " | Borrowed Books: " + borrowedBooks.size();
  }

}
