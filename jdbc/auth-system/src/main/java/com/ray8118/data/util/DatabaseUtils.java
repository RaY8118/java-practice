package com.ray8118.data.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseUtils {

    private static final String URL = "jdbc:postgresql://localhost:5432/auth_system";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "oggy2112";
    private static final Logger LOGGER = Logger.getLogger(DatabaseUtils.class.getName());
    private static final String exceptionFormat = "exception in %s, message: %s, code: %s";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            handleSqlException("DatabaseUtils.getConnection", e, LOGGER);
            return null;
        }
    }

    public static void handleSqlException(String method, SQLException e, Logger log) {
        log.warning(String.format(exceptionFormat, method, e, log));
        throw new RuntimeException();
    }
}
