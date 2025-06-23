package com.ray8118.data.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.ray8118.data.entity.Account;
import com.ray8118.data.entity.CurrentAccount;
import com.ray8118.data.entity.SavingsAccount;
import com.ray8118.data.util.DatabaseUtils;

public class AccountDao {

    private static final Logger LOGGER = Logger.getLogger(AccountDao.class.getName());
    private static final String INSERT = "insert into accounts (account_holder_name, balance, account_type, interest_rate, overdraft_limit) values (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "select * from accounts";
    private static final String SELECT_ONE = "select * from accounts where account_number = ?";
    private static final String UPDATE = "update accounts set account_holder_name = ?, balance = ?, where account_number = ?";
    private static final String DELETE = "delete from accounts where account_number = ?";
    private static final String DEPOSIT = "update accounts set balance = balance + ? where account_number = ?";
    private static final String WITHDRAW = "update accounts set balance = balance - ? where account_number = ? and balance >= ?";

    public void create(Account account) {
        try (PreparedStatement statement = DatabaseUtils.getConnection().prepareStatement(INSERT)) {

            statement.setString(1, account.getAccountHolderName());
            statement.setBigDecimal(2, BigDecimal.valueOf(account.getBalance()));

            if (account instanceof SavingsAccount sa) {
                statement.setString(3, "savings");
                statement.setBigDecimal(4, BigDecimal.valueOf(sa.getInterestRate()));
                statement.setNull(5, Types.DECIMAL);
            } else if (account instanceof CurrentAccount ca) {
                statement.setString(3, "current");
                statement.setNull(4, Types.DECIMAL);
                statement.setBigDecimal(5, BigDecimal.valueOf(ca.getOverdraftLimit()));
            } else {
                throw new IllegalArgumentException("Unsupported account type");
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            DatabaseUtils.handleSqlException("AccountDao.create", e, LOGGER);
        }
    }

    public List<Account> getAll() {
        List<Account> accounts = new ArrayList<>();

        try (Connection connection = DatabaseUtils.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL);

            while (rs.next()) {
                int accountNumber = rs.getInt("account_number");
                String name = rs.getString("account_holder_name");
                double balance = rs.getDouble("balance");
                String type = rs.getString("account_type");

                if ("savings".equalsIgnoreCase(type)) {
                    double interestRate = rs.getDouble("interest_rate");
                    accounts.add(new SavingsAccount(accountNumber, name, balance, interestRate));
                } else if ("current".equalsIgnoreCase(type)) {
                    double overdraft = rs.getDouble("overdraft_limit");
                    accounts.add(new CurrentAccount(accountNumber, name, balance, overdraft));
                }
            }
        } catch (SQLException e) {
            DatabaseUtils.handleSqlException("AccountDao.getAll", e, LOGGER);
        }
        return accounts;
    }

    public Account getOne(int account_number) {
        Account account = null;

        try (PreparedStatement statement = DatabaseUtils.getConnection().prepareStatement(SELECT_ONE)) {
            statement.setInt(1, account_number);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                account = new Account();
                account.setAccountHolderName(rs.getString("account_holder_name"));
                account.setAccountNumber(rs.getInt("account_number"));
                account.setBalance(rs.getDouble("balance"));
            }

        } catch (SQLException e) {
            DatabaseUtils.handleSqlException("AccountDao.getAll", e, LOGGER);
        }

        return account;
    }

    public Account update(Account account) {

        try (PreparedStatement statement = DatabaseUtils.getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, account.getAccountHolderName());
            statement.setDouble(2, account.getBalance());
            statement.setInt(3, account.getAccountNumber());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Account updated successfully.");
                return account;
            } else {
                System.out.println("No account found to update.");
                return null;
            }

        } catch (SQLException e) {
            DatabaseUtils.handleSqlException("AccountDao.update", e, Logger.getLogger(AccountDao.class.getName()));
            return null;
        }
    }

    public void delete(int account_number) {
        try (PreparedStatement statement = DatabaseUtils.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, account_number);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Account deleted successfully");
            } else {
                System.out.println("No account found with that number");
            }
        } catch (SQLException e) {
            DatabaseUtils.handleSqlException("AccountDao.delete", e, LOGGER);
        }
    }

    public void deposit(int account_number, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Depoist amount must be positive");
        }
        try (PreparedStatement statement = DatabaseUtils.getConnection().prepareStatement(DEPOSIT)) {
            statement.setDouble(1, amount);
            statement.setInt(2, account_number);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("No account found with ID: " + account_number);
            }
        } catch (SQLException e) {
            DatabaseUtils.handleSqlException("AccountDao.deposit", e, LOGGER);
        }

    }

    public void withdraw(int account_number, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }

        try (PreparedStatement statement = DatabaseUtils.getConnection().prepareStatement(WITHDRAW)) {
            statement.setDouble(1, amount);
            statement.setInt(2, account_number);
            statement.setDouble(3, amount);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 0) {
                System.out.println("Withdraw failed: either account not found or insufficient balance");
            }
        } catch (SQLException e) {
            DatabaseUtils.handleSqlException("AccountDao.withdraw", e, LOGGER);
        }
    }

}
