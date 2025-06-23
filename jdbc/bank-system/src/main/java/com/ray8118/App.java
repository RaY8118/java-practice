package com.ray8118;

import java.util.List;
import java.util.Scanner;

import com.ray8118.data.dao.AccountDao;
import com.ray8118.data.entity.Account;
import com.ray8118.data.entity.CurrentAccount;
import com.ray8118.data.entity.SavingsAccount;

public class App {

    public static void main(String[] args) {
        AccountDao dao = new AccountDao();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- BANK SYSTEM ---");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Display Account Details");
            System.out.println("6. List All Accounts");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter initial deposit: ");
                        double deposit = scanner.nextDouble();
                        System.out.print("Enter interest rate: ");
                        double rate = scanner.nextDouble();
                        SavingsAccount sa = new SavingsAccount(0, name, deposit, rate);
                        dao.create(sa);
                        System.out.println("Savings account created.");
                    }
                    case 2 -> {
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter initial deposit: ");
                        double deposit = scanner.nextDouble();
                        System.out.print("Enter overdraft limit: ");
                        double limit = scanner.nextDouble();
                        CurrentAccount ca = new CurrentAccount(0, name, deposit, limit);
                        dao.create(ca);
                        System.out.println("Current account created.");
                    }
                    case 3 -> {
                        System.out.print("Enter account number: ");
                        int accNo = scanner.nextInt();
                        System.out.print("Enter deposit amount: ");
                        double amt = scanner.nextDouble();
                        dao.deposit(accNo, amt);
                        System.out.println("Amount deposited.");
                    }
                    case 4 -> {
                        System.out.print("Enter account number: ");
                        int accNo = scanner.nextInt();
                        System.out.print("Enter withdrawal amount: ");
                        double amt = scanner.nextDouble();
                        dao.withdraw(accNo, amt);
                        System.out.println("Amount withdrawn.");
                    }
                    case 5 -> {
                        System.out.print("Enter account number: ");
                        int accNo = scanner.nextInt();
                        Account acc = dao.getOne(accNo);
                        System.out.println(acc != null ? acc : "Account not found.");
                    }
                    case 6 -> {
                        List<Account> all = dao.getAll();
                        all.forEach(System.out::println);
                    }
                    case 0 -> {
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
