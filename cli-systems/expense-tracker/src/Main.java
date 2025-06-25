import java.time.LocalDate;
import java.util.Scanner;
import services.ExpenseService;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ExpenseService service = new ExpenseService();

    while (true) {
      System.out.println("\n--- EXPENSE TRACKER ---");
      System.out.println("1. Add Expense");
      System.out.println("2. Remove Expense");
      System.out.println("3. List All Expenses");
      System.out.println("4. List Expenses by Category");
      System.out.println("5. Show Total Spent");
      System.out.println("0. Exit");
      System.out.print("Enter choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine(); // consume newline

      switch (choice) {
        case 1 -> {
            System.out.print("Description: ");
            String description = scanner.nextLine();
            System.out.print("Amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // consume newline
            System.out.print("Category: ");
            String category = scanner.nextLine();
            System.out.print("Date (yyyy-mm-dd): ");
            String dateInput = scanner.nextLine();
            LocalDate date = LocalDate.parse(dateInput);
            service.addExpense(description, amount, category, date);
            System.out.println("Expense added.");
            }

        case 2 -> {
            System.out.print("Enter ID to remove: ");
            int removeId = scanner.nextInt();
            service.removeExpense(removeId);
            System.out.println("Expense removed.");
            }

        case 3 -> service.listAllExpenses();

        case 4 -> {
            System.out.print("Enter category: ");
            String filterCategory = scanner.nextLine();
            service.listExpensesByCategory(filterCategory);
            }

        case 5 -> System.out.println("Total Spent: " + service.getTotalSpent());

        case 0 -> {
            System.out.println("Exiting...");
            scanner.close();
            return;
            }

        default -> System.out.println("Invalid choice.");
      }
    }
  }
}
