package com.ray8118.ipa.oops;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void testGetTotalBalanceByType_Savings() {
        BankAccount[] accounts = {
            new BankAccount(1, "John", 1000, BankAccount.AccountType.SAVINGS),
            new BankAccount(2, "Jane", 2000, BankAccount.AccountType.CURRENT),
            new BankAccount(3, "Bob", 3000, BankAccount.AccountType.SAVINGS)
        };
        assertEquals(4000, BankAccount.getTotalBalanceByType(accounts, BankAccount.AccountType.SAVINGS));
    }

    @Test
    void testGetTotalBalanceByType_Current() {
        BankAccount[] accounts = {
            new BankAccount(1, "John", 1000, BankAccount.AccountType.SAVINGS),
            new BankAccount(2, "Jane", 2000, BankAccount.AccountType.CURRENT),
            new BankAccount(3, "Bob", 3000, BankAccount.AccountType.SAVINGS),
            new BankAccount(4, "Alice", 4000, BankAccount.AccountType.CURRENT)
        };
        assertEquals(6000, BankAccount.getTotalBalanceByType(accounts, BankAccount.AccountType.CURRENT));
    }

    @Test
    void testGetTotalBalanceByType_NoAccountsOfType() {
        BankAccount[] accounts = {
            new BankAccount(1, "John", 1000, BankAccount.AccountType.SAVINGS),
            new BankAccount(2, "Jane", 2000, BankAccount.AccountType.SAVINGS)
        };
        assertEquals(0, BankAccount.getTotalBalanceByType(accounts, BankAccount.AccountType.CURRENT));
    }

    @Test
    void testGetTotalBalanceByType_EmptyArray() {
        BankAccount[] accounts = {};
        assertEquals(0, BankAccount.getTotalBalanceByType(accounts, BankAccount.AccountType.SAVINGS));
    }

    @Test
    void testGetHighestBalanceAccount_multipleAccounts() {
        BankAccount[] accounts = {
            new BankAccount(1, "John", 1000, BankAccount.AccountType.SAVINGS),
            new BankAccount(2, "Jane", 2000, BankAccount.AccountType.CURRENT),
            new BankAccount(3, "Bob", 3000, BankAccount.AccountType.SAVINGS),
            new BankAccount(4, "Alice", 4000, BankAccount.AccountType.CURRENT)
        };
        BankAccount highest = BankAccount.getHighestBalanceAccount(accounts);
        assertNotNull(highest);
        assertEquals("Alice", highest.getHolderName());
        assertEquals(4000, highest.getBalance());
    }

    @Test
    void testGetHighestBalanceAccount_singleAccount() {
        BankAccount[] accounts = {
            new BankAccount(1, "John", 1000, BankAccount.AccountType.SAVINGS)
        };
        BankAccount highest = BankAccount.getHighestBalanceAccount(accounts);
        assertNotNull(highest);
        assertEquals("John", highest.getHolderName());
        assertEquals(1000, highest.getBalance());
    }

    @Test
    void testGetHighestBalanceAccount_emptyArray() {
        BankAccount[] accounts = {};
        BankAccount highest = BankAccount.getHighestBalanceAccount(accounts);
        assertNull(highest);
    }

    @Test
    void testGetHighestBalanceAccount_tieInBalance() {
        BankAccount[] accounts = {
            new BankAccount(1, "John", 2000, BankAccount.AccountType.SAVINGS),
            new BankAccount(2, "Jane", 2000, BankAccount.AccountType.CURRENT)
        };
        BankAccount highest = BankAccount.getHighestBalanceAccount(accounts);
        assertNotNull(highest);
        assertEquals(2000, highest.getBalance());
        // Should return the first one encountered
        assertEquals("John", highest.getHolderName());
    }

    @Test
    void testDeposit_existingAccount() {
        BankAccount[] accounts = {
            new BankAccount(1, "John", 1000, BankAccount.AccountType.SAVINGS),
            new BankAccount(2, "Jane", 2000, BankAccount.AccountType.CURRENT)
        };
        BankAccount.deposit(accounts, 1, 500);
        assertEquals(1500, accounts[0].getBalance());
        assertEquals(2000, accounts[1].getBalance());
    }

    @Test
    void testDeposit_nonExistingAccount() {
        BankAccount[] accounts = {
            new BankAccount(1, "John", 1000, BankAccount.AccountType.SAVINGS)
        };
        BankAccount.deposit(accounts, 99, 500);
        assertEquals(1000, accounts[0].getBalance()); // Balance should be unchanged
    }

    @Test
    void testWithdraw_sufficientFunds() {
        BankAccount[] accounts = {
            new BankAccount(1, "John", 1000, BankAccount.AccountType.SAVINGS)
        };
        BankAccount.withdraw(accounts, 1, 300);
        assertEquals(700, accounts[0].getBalance());
    }

    @Test
    void testWithdraw_insufficientFunds() {
        BankAccount[] accounts = {
            new BankAccount(1, "John", 1000, BankAccount.AccountType.SAVINGS)
        };
        BankAccount.withdraw(accounts, 1, 1500);
        assertEquals(1000, accounts[0].getBalance()); // Balance should be unchanged
    }

    @Test
    void testWithdraw_nonExistingAccount() {
        BankAccount[] accounts = {
            new BankAccount(1, "John", 1000, BankAccount.AccountType.SAVINGS)
        };
        BankAccount.withdraw(accounts, 99, 500);
        assertEquals(1000, accounts[0].getBalance()); // Balance should be unchanged
    }

    @Test
    void testGetAccountsByType_Savings() {
        BankAccount[] accounts = {
            new BankAccount(1, "John", 1000, BankAccount.AccountType.SAVINGS),
            new BankAccount(2, "Jane", 2000, BankAccount.AccountType.CURRENT),
            new BankAccount(3, "Bob", 3000, BankAccount.AccountType.SAVINGS)
        };
        BankAccount[] savingsAccounts = BankAccount.getAccountsByType(accounts, BankAccount.AccountType.SAVINGS);
        assertEquals(2, savingsAccounts.length);
        assertTrue(savingsAccounts[0].getHolderName().equals("John") || savingsAccounts[1].getHolderName().equals("John"));
    }

    @Test
    void testGetAccountsByType_nonExistingType() {
        BankAccount[] accounts = {
            new BankAccount(1, "John", 1000, BankAccount.AccountType.SAVINGS)
        };
        BankAccount[] currentAccounts = BankAccount.getAccountsByType(accounts, BankAccount.AccountType.CURRENT);
        assertEquals(0, currentAccounts.length);
    }
}