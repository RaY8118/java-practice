// Scenario:
// A bank manages accounts with accountNumber, holderName, balance, and
// accountType (like "savings" or "current").
//
// Tasks:
//
// Create a BankAccount class.
//
// Write getTotalBalanceByType(String type) that returns the sum of balances for
// all accounts of that type.
//
// Write getHighestBalanceAccount() that returns the BankAccount object with the
// maximum balance.
//
package com.ray8118.ipa.oops;

import com.ray8118.ipa.TestHelper;

public class BankAccount {

  private int accountNumber;
  private String holderName;
  private int balance;
  private AccountType accountType;

  public enum AccountType {
    SAVINGS, CURRENT
  }

  public BankAccount(int accountNumber, String holderName, int balance, AccountType accountType) {
    this.accountNumber = accountNumber;
    this.holderName = holderName;
    this.balance = balance;
    this.accountType = accountType;
  }

  public int getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(int acccountNumber) {
    this.accountNumber = acccountNumber;
  }

  public String getHolderName() {
    return holderName;
  }

  public void setHolderName(String holderName) {
    this.holderName = holderName;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public AccountType getAccountType() {
    return accountType;
  }

  public void setAccountType(AccountType accountType) {
    this.accountType = accountType;
  }

  @Override
  public String toString() {
    return "Bank [acccountNumber=" + accountNumber + ", holderName=" + holderName + ", balance=" + balance
        + ", accountType=" + accountType + "]";
  }

  public static int getTotalBalanceByType(BankAccount[] accounts, AccountType accountType) {
    int totalBalance = 0;
    for (BankAccount bankAccount : accounts) {
      if (bankAccount.getAccountType() == accountType) {
        totalBalance += bankAccount.getBalance();
      }
    }
    return totalBalance;
  }

  public static BankAccount getHighestBalanceAccount(BankAccount[] accounts) {
    BankAccount highestBalanceAccount = null;
    for (BankAccount bankAccount : accounts) {
      if (highestBalanceAccount == null || bankAccount.getBalance() > highestBalanceAccount.getBalance()) {
        highestBalanceAccount = bankAccount;
      }
    }
    return highestBalanceAccount;
  }

  public static void main(String[] args) {
    BankAccount[] accounts = {
        new BankAccount(1, "John", 1000, AccountType.SAVINGS),
        new BankAccount(2, "Jane", 2000, AccountType.CURRENT),
        new BankAccount(3, "Bob", 3000, AccountType.SAVINGS),
        new BankAccount(4, "Alice", 4000, AccountType.CURRENT)
    };

    // Test getTotalBalanceByType
    TestHelper.assertEqual("Total balance for SAVINGS", getTotalBalanceByType(accounts, AccountType.SAVINGS), 4000);
    TestHelper.assertEqual("Total balance for CURRENT", getTotalBalanceByType(accounts, AccountType.CURRENT), 6000);

    // Test getHighestBalanceAccount
    BankAccount highestBalanceAccount = getHighestBalanceAccount(accounts);
    TestHelper.assertEqual("Highest balance account name", highestBalanceAccount.getHolderName(), "Alice");
    TestHelper.assertEqual("Highest balance account balance", highestBalanceAccount.getBalance(), 4000);

    BankAccount[] noAccounts = {
    };
    TestHelper.assertEqual("Highest balance account (none)", getHighestBalanceAccount(noAccounts), null);

  }
}
