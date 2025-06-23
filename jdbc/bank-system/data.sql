-- Create database (optional, if not created already)
CREATE DATABASE bank_system;

-- Switch to the desired schema/database (if needed)
\c bank_system

-- Main table for common account fields
DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts (
  account_number SERIAL PRIMARY KEY,
  account_holder_name VARCHAR(100) NOT NULL,
  balance DECIMAL(10, 2) NOT NULL,
  account_type VARCHAR(20) NOT NULL,       -- 'savings' or 'current'
  interest_rate DECIMAL(5, 2),             -- only for savings
  overdraft_limit DECIMAL(10, 2)           -- only for current
);

