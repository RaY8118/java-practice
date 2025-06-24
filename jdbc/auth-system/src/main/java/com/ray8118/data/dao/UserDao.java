package com.ray8118.data.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.mindrot.jbcrypt.BCrypt;

import com.ray8118.data.entity.User;
import com.ray8118.data.util.DatabaseUtils;

public class UserDao {

    private static final Logger LOGGER = Logger.getLogger(UserDao.class.getName());
    private static final String REGISTER = "insert into users (full_name, email, password_hash, is_active) values(?, ?, ?, ?)";
    private static final String SELECT_BY_EMAIL = "select * from users where email = ?";
    private static final String DELETE = "delete from users where email = ?";
    private static final String UPDATE = "update users set password_hash = ? where email = ?";

    public void register(User user) {
        try (PreparedStatement statement = DatabaseUtils.getConnection().prepareStatement(REGISTER)) {
            String hashedPassword = BCrypt.hashpw(user.getPasswordHash(), BCrypt.gensalt());
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getEmail());
            statement.setString(3, hashedPassword);
            statement.setBoolean(4, user.isActive());

            statement.executeUpdate();

        } catch (SQLException e) {
            DatabaseUtils.handleSqlException("UserDao.create", e, LOGGER);
        }
    }

    public User getByEmail(String email) {
        User user = null;
        try (PreparedStatement statement = DatabaseUtils.getConnection().prepareStatement(SELECT_BY_EMAIL)) {
            statement.setString(1, email);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setPasswordHash("password_hash");
                user.setActive(rs.getBoolean("is_active"));
            }

        } catch (SQLException e) {
            DatabaseUtils.handleSqlException("UserDao.getByEmail", e, LOGGER);
        }
        return user;
    }

    public User login(String email, String password) {
        User user = null;

        try (PreparedStatement statement = DatabaseUtils.getConnection().prepareStatement(SELECT_BY_EMAIL)) {
            statement.setString(1, email);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String storedHash = rs.getString("password_hash");
                if (BCrypt.checkpw(password, storedHash)) {
                    user = new User();
                    user.setUserId(rs.getInt("user_id"));
                    user.setFullName(rs.getString("full_name"));
                    user.setEmail(rs.getString("email"));
                    user.setActive(rs.getBoolean("is_active"));
                }
            }
        } catch (SQLException e) {
            DatabaseUtils.handleSqlException("UserDao.login", e, LOGGER);
        }
        return user;
    }

    public void delete(String email) {
        try (PreparedStatement statement = DatabaseUtils.getConnection().prepareStatement(DELETE)) {
            statement.setString(1, email);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User deleted successfully");
            } else {
                System.out.println("No user found with this email");
            }
        } catch (SQLException e) {
            DatabaseUtils.handleSqlException("UserDao.delete", e, LOGGER);
        }
    }

    public boolean update(String email, String newPassword) {
        User user = getByEmail(email);
        if (user == null) {
            System.out.println("No user found with this email");
            return false;
        }

        String hash = BCrypt.hashpw(newPassword, BCrypt.gensalt());
        try (PreparedStatement statement = DatabaseUtils.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, hash);
            statement.setString(2, email);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Password updated successfully!");
                return true;
            } else {
                System.out.println("Password update failed.");
                return false;
            }
        } catch (SQLException e) {
            DatabaseUtils.handleSqlException("UserDao.updatePassword", e, LOGGER);
            return false;
        }
    }

}
