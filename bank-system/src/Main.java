
import java.util.Scanner;
import services.BankService;

public class Main {

    public static void main(String[] args) {
        BankService bank = new BankService();
        try (Scanner scanner = new Scanner(System.in)) {
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
                            bank.createSavingsAccount(name, deposit, rate);
                            System.out.println("Savings account created.");
                        }
                        case 2 -> {
                            System.out.print("Enter name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter initial deposit: ");
                            double deposit = scanner.nextDouble();
                            System.out.print("Enter overdraft limit: ");
                            double limit = scanner.nextDouble();
                            bank.createCurrentAccount(name, deposit, limit);
                            System.out.println("Current account created.");
                        }
                        case 3 -> {
                            System.out.print("Enter account number: ");
                            int accNo = scanner.nextInt();
                            System.out.print("Enter deposit amount: ");
                            double amt = scanner.nextDouble();
                            bank.deposit(accNo, amt);
                            System.out.println("Amount deposited.");
                        }
                        case 4 -> {
                            System.out.print("Enter account number: ");
                            int accNo = scanner.nextInt();
                            System.out.print("Enter withdrawal amount: ");
                            double amt = scanner.nextDouble();
                            bank.withdraw(accNo, amt);
                            System.out.println("Amount withdrawn.");
                        }
                        case 5 -> {
                            System.out.print("Enter account number: ");
                            int accNo = scanner.nextInt();
                            bank.displayAccountDetails(accNo);
                        }
                        case 6 -> {
                            bank.listAllAccount();
                        }
                        case 0 -> {
                            System.out.println("Exiting...");
                            return;
                        }
                        default ->
                            System.out.println("Invalid choice.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}
