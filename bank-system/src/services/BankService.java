package services;

import java.util.HashMap;
import models.*;

public class BankService {

    private final HashMap<Integer, Account> accounts = new HashMap<>();
    private int nextAccountNumber = 1;

    public void createSavingsAccount(String name, double initialDeposit, double interestRate) {
        if (initialDeposit < 0) {
            throw new IllegalArgumentException("Initial must be positive");
        }
        SavingsAccount account = new SavingsAccount(nextAccountNumber, name, initialDeposit, interestRate);
        accounts.put(nextAccountNumber, account);
        nextAccountNumber++;
    }

    public void createCurrentAccount(String name, double initialDeposit, double overdraftLimit) {
        if (initialDeposit < 0) {
            throw new IllegalArgumentException("Initial must be positive");
        }
        CurrentAccount account = new CurrentAccount(nextAccountNumber, name, initialDeposit, overdraftLimit);
        accounts.put(nextAccountNumber, account);
        nextAccountNumber++;
    }

    public void deposit(int accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }
        account.deposit(amount);
    }

    public void withdraw(int accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }
        account.withdraw(amount);
    }

    public void displayAccountDetails(int accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }
        System.out.println("Account Number:" + account.getAccountNumber());
        System.out.println("Account Holder:" + account.getAccountHolderName());
        System.out.println("Account Balance:" + account.getBalance());

        if (account instanceof SavingsAccount savingAccount) {
            System.out.println("Interest Rate: " + savingAccount.getInterestRate() + "%");
        }

        if (account instanceof CurrentAccount currentAccount) {
            System.out.println("Overdraft Limit: " + currentAccount.getOverdraftLimit());
        }
    }

    public void listAllAccount() {
        if (accounts.isEmpty()) {
            throw new IllegalArgumentException("No accounts found");
        }
        for (Account account : accounts.values()) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Holder Name: " + account.getAccountHolderName());

        }
    }

}
