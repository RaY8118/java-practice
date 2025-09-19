-- Active: 1758215318870@@127.0.0.1@5432@todo
-- Create database (optional, if not created already)
CREATE DATABASE todo;

-- Switch to the desired schema/database (if needed)
\c todo

-- Main table for common user fields
DROP TABLE IF EXISTS tasks;

CREATE TABLE tasks (
    todo_id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL,
    isCompleted BOOLEAN DEFAULT FALSE
);