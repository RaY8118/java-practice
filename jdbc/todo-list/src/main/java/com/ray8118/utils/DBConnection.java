package com.ray8118.utils;

import com.ray8118.exception.DaoException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class DBConnection {
    private static final Properties PROPERTIES = new Properties();
    private static final Logger LOGGER = Logger.getLogger(DBConnection.class.getName());
    private static final String exceptionFormat = "exception in %s, message: %s, code: %s";

    static {
        try (InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                LOGGER.severe("Sorry, unable to find db.properties");
                throw new DaoException("Unable to find db.properties");
            }
            PROPERTIES.load(input);
        } catch (IOException ex) {
            LOGGER.severe("Error loading db.properties: " + ex.getMessage());
            throw new DaoException("Error loading db.properties", new SQLException(ex));
        }
    }

    public static Connection getConnection() {
        try {
            String url = PROPERTIES.getProperty("db.url");
            String username = PROPERTIES.getProperty("db.username");
            String password = PROPERTIES.getProperty("db.password");
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            handleSqlException("DBConnection.getConnection", e, LOGGER);
            return null;
        }
    }

    public static void handleSqlException(String method, SQLException e, Logger log) {
        if (e != null) {
            log.warning(String.format(
                    exceptionFormat,
                    method,
                    e.getMessage(),
                    e.getSQLState() + " / " + e.getErrorCode()));
        } else {
            log.warning(String.format("Exception in %s but SQLException was null", method));
        }
        throw new DaoException("Database operation failed in " + method, e);
    }

}
