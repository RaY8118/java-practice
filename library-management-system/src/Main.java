import models.Book;
import models.User;
import services.LibraryService;
import services.UserService;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    LibraryService libraryService = new LibraryService();
    UserService userService = new UserService();

    while (true) {
      System.out.println("\n--- Library Management System ---");
      System.out.println("1. Add Book");
      System.out.println("2. Register User");
      System.out.println("3. Borrow Book");
      System.out.println("4. Return Book");
      System.out.println("5. List Available Books");
      System.out.println("6. List User Borrowed Books");
      System.out.println("7. Delete User");
      System.out.println("0. Exit");
      System.out.print("Choose an option: ");

      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1 -> {
          System.out.print("Enter book id: ");
          String id = scanner.nextLine();
          System.out.print("Enter title: ");
          String title = scanner.nextLine();
          System.out.print("Enter author: ");
          String author = scanner.nextLine();
          libraryService.addBook(new Book(id, title, author));
        }
        case 2 -> {
          System.out.print("Enter user id: ");
          String userId = scanner.nextLine();
          System.out.print("Enter name: ");
          String name = scanner.nextLine();
          userService.registerUser(new User(userId, name));
        }
        case 3 -> {
          System.out.print("Enter user id: ");
          String userId = scanner.nextLine();
          System.out.print("Enter book id: ");
          String bookId = scanner.nextLine();
          User user = userService.findUser(userId);
          if (user != null) {
            libraryService.borrowBook(bookId, user);
          } else {
            System.out.print("User not found!");
          }
        }
        case 4 -> {
          System.out.print("Enter user id: ");
          String userId = scanner.nextLine();
          System.out.print("Enter book id: ");
          String bookId = scanner.nextLine();
          User user = userService.findUser(userId);
          if (user != null) {
            libraryService.returnBook(bookId, user);
          } else {
            System.out.print("User not found!");
          }
        }
        case 5 -> libraryService.listAvailableBooks();
        case 6 -> {
          System.out.print("Enter user id: ");
          String userId = scanner.nextLine();
          User user = userService.findUser(userId);
          if (user != null) {
            userService.listBorrowedBooks(user);
          } else {
            System.out.print("User not found!");
          }
        }
        case 7 -> {
          System.out.print("Enter user id: ");
          String userId = scanner.nextLine();
          userService.deleteUser(userId);
        }
        case 0 -> {
          System.out.print("Exiting...");
          return;
        }
        default -> System.out.print("Invalid choice");
      }
    }
  }
}
