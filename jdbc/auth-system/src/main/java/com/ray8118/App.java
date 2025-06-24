package com.ray8118;

import java.util.Scanner;

import com.ray8118.data.entity.User;
import com.ray8118.services.UserService;

public class App {

    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- USER AUTH SYSTEM ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Update Password");
            System.out.println("4. Delete User");
            System.out.println("5. Get User by Email");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter full name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    if (userService.register(name, email, password)) {
                        System.out.println("User registered.");
                    }
                }

                case 2 -> {
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    User user = userService.login(email, password);
                    if (user != null) {
                        System.out.println("Login successful! Welcome, " + user.getFullName());
                    } else {
                        System.out.println("Invalid credentials");
                    }
                }

                case 3 -> {
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.nextLine();

                    if (userService.updatePassword(email, newPassword)) {
                        System.out.println("Password updated successfully.");
                    }
                }

                case 4 -> {
                    System.out.print("Enter email to delete: ");
                    String email = scanner.nextLine();

                    if (userService.delete(email)) {
                        System.out.println("User deleted successfully.");
                    }
                }

                case 5 -> {
                    System.out.print("Enter email to fetch user: ");
                    String email = scanner.nextLine();
                    User user = userService.getByEmail(email);
                    if (user != null) {
                        System.out.println(user);
                    } else {
                        System.out.println("User not found.");
                    }
                }

                case 0 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }

                default ->
                    System.out.println("Invalid choice.");
            }
        }
    }
}
