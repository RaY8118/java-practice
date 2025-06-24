package com.ray8118.services;

import com.ray8118.data.dao.UserDao;
import com.ray8118.data.entity.User;
import com.ray8118.data.util.InputValidator;

public class UserService {

    private final UserDao dao = new UserDao();

    public boolean register(String name, String email, String password) {
        if (!InputValidator.isValidName(name) || !InputValidator.isValidEmail(email) || !InputValidator.isValidPassword(password)) {
            System.out.println("Invalid input");
            return false;
        }
        if (dao.getByEmail(email) != null) {
            System.out.println("Email already exists");
            return false;
        }
        User user = new User(0, name, email, password, false);
        dao.register(user);
        return true;
    }

    public User login(String email, String password) {
        if (!InputValidator.isValidEmail(email)) {
            System.out.println("Invalid email.");
            return null;
        }
        return dao.login(email, password);
    }

    public boolean updatePassword(String email, String newPassword) {
        if (dao.getByEmail(email) == null) {
            System.out.println("No user with that email.");
            return false;
        }
        return dao.update(email, newPassword);
    }

    public User getByEmail(String email) {
        return dao.getByEmail(email);
    }

    public boolean delete(String email) {
        if (dao.getByEmail(email) == null) {
            System.out.println("No user with that email.");
            return false;
        }
        dao.delete(email);
        return true;
    }
}
