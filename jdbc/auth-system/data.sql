-- Create database (optional, if not created already)
CREATE DATABASE auth_system;

-- Switch to the desired schema/database (if needed)
\c auth_system

-- Main table for common user fields
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password_hash TEXT NOT NULL,
    is_active BOOLEAN DEFAULT TRUE
);
