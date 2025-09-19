package com.ray8118.exception;

import java.sql.SQLException;

public class DaoException extends RuntimeException {

    public DaoException(String message, SQLException cause) {
        super(message, cause);
    }

    public DaoException(String message) {
        super(message);
    }
}