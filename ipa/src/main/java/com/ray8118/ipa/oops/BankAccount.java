// ### 🔷 **Problem 19 – Bank Account Class: Transaction Management**

// Create a `BankAccount` class with:

// * `accountNumber` (String)
// * `holderName` (String)
// * `balance` (double)
// * `accountType` (AccountType enum) - SAVINGS or CURRENT

// Write:

// 1. A method `deposit(BankAccount[] accounts, String accountNumber, double amount)` that adds the amount to the specified account's balance. Return the updated accounts array.
// 2. A method `withdraw(BankAccount[] accounts, String accountNumber, double amount)` that subtracts the amount from the specified account's balance (if sufficient funds). Return the updated accounts array.
// 3. A method `getAccountsByType(BankAccount[] accounts, AccountType type)` to return an array of accounts of the specified type. Return an empty array if none found.

// ---
package com.ray8118.ipa.oops;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    private AccountType accountType;

    public enum AccountType {
        SAVINGS,
        CURRENT
    }

    public BankAccount() {
    }

    public BankAccount(String accountNumber, String holderName, double balance, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public static BankAccount[] deposit(BankAccount[] accounts, String accountNumber, double amount) {
        if (accounts == null || accountNumber == null) {
            return new BankAccount[0];
        }
        for (BankAccount bankAccount : accounts) {
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                bankAccount.setBalance(bankAccount.getBalance() + amount);
            }
        }

        return accounts;
    }

    public static BankAccount[] withdraw(BankAccount[] accounts, String accountNumber, double amount) {
        if (accounts == null || accountNumber == null) {
            return new BankAccount[0];
        }
        for (BankAccount bankAccount : accounts) {
            if (bankAccount.getAccountNumber().equals(accountNumber) && bankAccount.getBalance() > amount) {
                bankAccount.setBalance(bankAccount.getBalance() - amount);
            }
        }

        return accounts;
    }

    public static BankAccount[] getAccountsByType(BankAccount[] accounts, AccountType type) {
        List<BankAccount> bankAccounts = new ArrayList<>();
        for (BankAccount bankAccount : accounts) {
            if (bankAccount.getAccountType() == type) {
                bankAccounts.add(bankAccount);
            }
        }
        return bankAccounts.toArray(new BankAccount[0]);

    }
}
