package services;

import java.util.HashMap;

import models.User;

public class AuthService {
  private HashMap<String, User> users;

  public AuthService() {
    users = new HashMap<>();
  }

  public boolean register(String username, String password, String email) {
    if (users.containsKey(username)) {
      System.out.println("Username already exists.");
      return false;
    }
    for (User user : users.values()) {
      if (user.getEmail().equalsIgnoreCase(email)) {
        System.out.println("EMail already registered.");
        return false;
      }
    }
    users.put(username, new User(username, password, email));
    System.out.println("User registered successfully");
    return true;
  }

  public boolean login(String username, String password) {
    User user = users.get(username);
    if (user != null && user.getPassword().equals(password)) {
      System.out.println("Login successful. Welcome , " + username + "!");
      return true;
    }
    System.out.println("Invalid username or password.");
    return false;
  }

  public boolean updatePassword(String username, String oldPassword, String newPassword) {
    User user = users.get(username);
    if (user != null && user.getPassword().equals(oldPassword)) {
      user.setPassword(newPassword);
      System.out.println("Password updated successfully");
      return true;
    }
    System.out.println("Invalid username or old password.");
    return false;
  }

  public boolean deleteUser(String username, String password) {
    User user = users.get(username);
    if (user != null && user.getPassword().equals(password)) {
      users.remove(username);
      System.out.println("User deleted successfully");
      return true;
    }
    System.out.println("Invalid username or password.");
    return false;
  }

  public void listUsers() {
    if (users.isEmpty()) {
      System.out.println("No registered users.");
    } else {
      System.out.println("Registerd users: ");
      for (User user : users.values()) {
        System.out.println(user);
      }
    }
  }
}
