import services.TodoService;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    TodoService todoService = new TodoService();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("\n--- TODO LIST ---");
      System.out.println("1. Add Task");
      System.out.println("2. Remove Task");
      System.out.println("3. Update Task");
      System.out.println("4. Mark Task as Completed");
      System.out.println("5. Mark Task as Pending");
      System.out.println("6. List All Tasks");
      System.out.println("7. List Completed Tasks");
      System.out.println("8. List Pending Tasks");
      System.out.println("0. Exit");
      System.out.print("Enter choice: ");

      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1 -> {
          System.out.print("Title: ");
          String title = scanner.nextLine();
          System.out.print("Description: ");
          String desc = scanner.nextLine();
          todoService.addTask(title, desc);
          break;
        }
        case 2 -> {
          System.out.print("Task ID to remove: ");
          int removeId = scanner.nextInt();
          todoService.removeTask(removeId);
          break;
        }
        case 3 -> {
          System.out.print("Task ID to update: ");
          int updateId = scanner.nextInt();
          scanner.nextLine();
          System.out.print("New Title: ");
          String newTitle = scanner.nextLine();
          System.out.print("New Description: ");
          String newDesc = scanner.nextLine();
          todoService.updateTask(updateId, newTitle, newDesc);
          break;
        }
        case 4 -> {
          System.out.print("Task ID to mark complete: ");
          int completeId = scanner.nextInt();
          todoService.markTaskCompleted(completeId);
          break;
        }
        case 5 -> {
          System.out.print("Task ID to mark pending: ");
          int pendingId = scanner.nextInt();
          todoService.markTaskPending(pendingId);
          break;
        }
        case 6 -> {
          todoService.listAllTasks();
          break;
        }
        case 7 -> {
          todoService.listCompletedTasks();
          break;
        }
        case 8 -> {
          todoService.listPendingTasks();
          break;
        }
        case 0 -> {
          System.out.println("Goodbye!");
          scanner.close();
          return;
        }
        default -> System.out.println("Invalid choice.");
      }
    }
  }
}
