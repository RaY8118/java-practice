package services;

import java.util.ArrayList;
import java.util.List;
import models.User;

public class UserService {

    private final List<User> users = new ArrayList<>();

    public void registerUser(User user) {
        users.add(user);
        System.out.println("User registered: " + user);
    }

    public void deleteUser(String userId) {
        users.removeIf(user -> user.getUserId().equals(userId));
        System.out.println("User removed with ID: " + userId);
    }

    public User findUser(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public void listBorrowedBooks(User user) {
        System.out.println("Books borrowed by " + user.getName() + ":");
        for (var book : user.getBorrowedBooks()) {
            System.out.println(book);
        }
    }

}
