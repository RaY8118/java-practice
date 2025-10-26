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
}