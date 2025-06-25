import services.AuthService;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    AuthService authService = new AuthService();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("\n=== Auth System ===");
      System.out.println("1. Register");
      System.out.println("2. Login");
      System.out.println("3. Update Password");
      System.out.println("4. Delete Account");
      System.out.println("5. List Users");
      System.out.println("0. Exit");
      System.out.print("Enter choice: ");

      int choice = scanner.nextInt();
      scanner.nextLine();

      switch (choice) {
        case 1 -> {
          System.out.print("Username: ");
          String Username = scanner.nextLine();
          System.out.print("Email: ");
          String Email = scanner.nextLine();
          System.out.print("Password: ");
          String Password = scanner.nextLine();
          System.out.print("Confirm Password: ");
          String confirmPassword = scanner.nextLine();
          if (!Password.equals(confirmPassword)) {
            System.out.println("Passwords do not match. Try again.");
            break;
          }
          authService.register(Username, Password, Email);
          break;
        }
        case 2 -> {
          System.out.print("Username: ");
          String loginUsername = scanner.nextLine();
          System.out.print("Password: ");
          String loginPassword = scanner.nextLine();
          authService.login(loginUsername, loginPassword);
          break;
        }
        case 3 -> {
          System.out.print("Username: ");
          String updUsername = scanner.nextLine();
          System.out
              .print("Current Password: ");
          String currentPassword = scanner.nextLine();
          System.out
              .print("New Password: ");
          String newPassword = scanner.nextLine();
          authService.updatePassword(updUsername,
              currentPassword, newPassword);
          break;
        }
        case 4 -> {
          System.out.print("Username: ");
          String delUsername = scanner.nextLine();
          System.out
              .print("Password: ");
          String delPassword = scanner.nextLine();
          authService.deleteUser(delUsername,
              delPassword);
          break;
        }
        case 5 -> {
          authService.listUsers();
          break;
        }
        case 0 -> {
          System.out.println("Exiting... Bye!");
          scanner.close();
          return;
        }
        default -> {
          System.out.println("Invalid choice. Try again.");
        }
      }
    }
  }
}
