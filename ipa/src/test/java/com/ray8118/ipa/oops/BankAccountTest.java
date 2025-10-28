package com.ray8118.ipa.oops;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void testDeposit_existingAccount() {
        BankAccount[] accounts = {
                new BankAccount("1", "John", 1000.0, BankAccount.AccountType.SAVINGS),
                new BankAccount("2", "Jane", 2000.0, BankAccount.AccountType.CURRENT)
        };
        BankAccount[] updated = BankAccount.deposit(accounts, "1", 500.0);
        assertEquals(1500.0, updated[0].getBalance());
        assertEquals(2000.0, updated[1].getBalance());
    }

    @Test
    void testDeposit_nonExistingAccount() {
        BankAccount[] accounts = {
                new BankAccount("1", "John", 1000.0, BankAccount.AccountType.SAVINGS)
        };
        BankAccount[] updated = BankAccount.deposit(accounts, "99", 500.0);
        assertEquals(1000.0, updated[0].getBalance());
    }

    @Test
    void testDeposit_zeroAmount() {
        BankAccount[] accounts = {
                new BankAccount("1", "John", 1000.0, BankAccount.AccountType.SAVINGS)
        };
        BankAccount[] updated = BankAccount.deposit(accounts, "1", 0.0);
        assertEquals(1000.0, updated[0].getBalance());
    }

    @Test
    void testWithdraw_sufficientFunds() {
        BankAccount[] accounts = {
                new BankAccount("1", "John", 1000.0, BankAccount.AccountType.SAVINGS)
        };
        BankAccount[] updated = BankAccount.withdraw(accounts, "1", 300.0);
        assertEquals(700.0, updated[0].getBalance());
    }

    @Test
    void testWithdraw_insufficientFunds() {
        BankAccount[] accounts = {
                new BankAccount("1", "John", 1000.0, BankAccount.AccountType.SAVINGS)
        };
        BankAccount[] updated = BankAccount.withdraw(accounts, "1", 1500.0);
        assertEquals(1000.0, updated[0].getBalance());
    }

    @Test
    void testWithdraw_nonExistingAccount() {
        BankAccount[] accounts = {
                new BankAccount("1", "John", 1000.0, BankAccount.AccountType.SAVINGS)
        };
        BankAccount[] updated = BankAccount.withdraw(accounts, "99", 500.0);
        assertEquals(1000.0, updated[0].getBalance());
    }

    @Test
    void testWithdraw_zeroAmount() {
        BankAccount[] accounts = {
                new BankAccount("1", "John", 1000.0, BankAccount.AccountType.SAVINGS)
        };
        BankAccount[] updated = BankAccount.withdraw(accounts, "1", 0.0);
        assertEquals(1000.0, updated[0].getBalance());
    }

    @Test
    void testGetAccountsByType_Savings() {
        BankAccount[] accounts = {
                new BankAccount("1", "John", 1000.0, BankAccount.AccountType.SAVINGS),
                new BankAccount("2", "Jane", 2000.0, BankAccount.AccountType.CURRENT),
                new BankAccount("3", "Bob", 3000.0, BankAccount.AccountType.SAVINGS)
        };
        BankAccount[] savingsAccounts = BankAccount.getAccountsByType(accounts, BankAccount.AccountType.SAVINGS);
        assertEquals(2, savingsAccounts.length);
        // Check that both are Savings
        for (BankAccount acc : savingsAccounts) {
            assertEquals(BankAccount.AccountType.SAVINGS, acc.getAccountType());
        }
    }

    @Test
    void testGetAccountsByType_Current() {
        BankAccount[] accounts = {
                new BankAccount("1", "John", 1000.0, BankAccount.AccountType.SAVINGS),
                new BankAccount("2", "Jane", 2000.0, BankAccount.AccountType.CURRENT),
                new BankAccount("3", "Bob", 3000.0, BankAccount.AccountType.SAVINGS),
                new BankAccount("4", "Alice", 4000.0, BankAccount.AccountType.CURRENT)
        };
        BankAccount[] currentAccounts = BankAccount.getAccountsByType(accounts, BankAccount.AccountType.CURRENT);
        assertEquals(2, currentAccounts.length);
        for (BankAccount acc : currentAccounts) {
            assertEquals(BankAccount.AccountType.CURRENT, acc.getAccountType());
        }
    }

    @Test
    void testGetAccountsByType_noAccountsOfType() {
        BankAccount[] accounts = {
                new BankAccount("1", "John", 1000.0, BankAccount.AccountType.SAVINGS),
                new BankAccount("2", "Jane", 2000.0, BankAccount.AccountType.SAVINGS)
        };
        BankAccount[] currentAccounts = BankAccount.getAccountsByType(accounts, BankAccount.AccountType.CURRENT);
        assertEquals(0, currentAccounts.length);
    }

    @Test
    void testGetAccountsByType_emptyArray() {
        BankAccount[] accounts = {};
        BankAccount[] savingsAccounts = BankAccount.getAccountsByType(accounts, BankAccount.AccountType.SAVINGS);
        assertEquals(0, savingsAccounts.length);
    }
}