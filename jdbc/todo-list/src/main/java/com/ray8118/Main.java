package com.ray8118;

import com.ray8118.exception.DaoException;
import com.ray8118.model.Task;
import com.ray8118.service.TaskService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final TaskService taskService = new TaskService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the To-Do List Application!");
        mainLoop();
    }

    private static void mainLoop() {
        int choice;
        do {
            displayMenu();
            choice = getUserChoice();

            try {
                switch (choice) {
                    case 1:
                        addTask();
                        break;
                    case 2:
                        viewAllTasks();
                        break;
                    case 3:
                        viewTaskById();
                        break;
                    case 4:
                        updateTask();
                        break;
                    case 5:
                        deleteTask();
                        break;
                    case 6:
                        markTaskComplete();
                        break;
                    case 0:
                        System.out.println("Exiting application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (DaoException e) {
                System.err.println("Database error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("An unexpected error occurred: " + e.getMessage());
            }
            System.out.println(); // New line for better readability
        } while (choice != 0);
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("---- Menu ----");
        System.out.println("1. Add New Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. View Task by ID");
        System.out.println("4. Update Task");
        System.out.println("5. Delete Task");
        System.out.println("6. Mark Task Complete/Incomplete");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // consume the invalid input
            System.out.print("Enter your choice: ");
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return choice;
    }

    private static int getTaskIdInput() {
        System.out.print("Enter Task ID: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // consume the invalid input
            System.out.print("Enter Task ID: ");
        }
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return id;
    }

    private static void addTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        if (taskService.addTask(title, description)) {
            System.out.println("Task added successfully!");
        } else {
            System.out.println("Failed to add task.");
        }
    }

    private static void viewAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("---- All Tasks ----");
            tasks.forEach(System.out::println);
        }
    }

    private static void viewTaskById() {
        int id = getTaskIdInput();
        Task task = taskService.getTaskById(id);
        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task with ID " + id + " not found.");
        }
    }

    private static void updateTask() {
        int id = getTaskIdInput();
        Task task = taskService.getTaskById(id);

        if (task == null) {
            System.out.println("Task with ID " + id + " not found.");
            return;
        }

        System.out.println("Current Task: " + task);
        System.out.print("Enter new title (leave blank to keep current: '" + task.getTitle() + "'): ");
        String newTitle = scanner.nextLine();
        if (!newTitle.trim().isEmpty()) {
            task.setTitle(newTitle);
        }

        System.out.print("Enter new description (leave blank to keep current: '" + task.getDescription() + "'): ");
        String newDescription = scanner.nextLine();
        if (!newDescription.trim().isEmpty()) {
            task.setDescription(newDescription);
        }

        System.out.print("Mark as complete? (true/false, leave blank to keep current: '" + task.isCompleted() + "'): ");
        String completeInput = scanner.nextLine();
        if (!completeInput.trim().isEmpty()) {
            task.setCompleted(Boolean.parseBoolean(completeInput));
        }

        if (taskService.updateTask(task)) {
            System.out.println("Task updated successfully!");
        } else {
            System.out.println("Failed to update task.");
        }
    }

    private static void deleteTask() {
        int id = getTaskIdInput();
        System.out.print("Are you sure you want to delete task with ID " + id + "? (yes/no): ");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("yes")) {
            taskService.deleteTask(id);
            System.out.println("Task with ID " + id + " deleted (if it existed).");
        } else {
            System.out.println("Task deletion cancelled.");
        }
    }

    private static void markTaskComplete() {
        int id = getTaskIdInput();
        Task task = taskService.getTaskById(id);

        if (task == null) {
            System.out.println("Task with ID " + id + " not found.");
            return;
        }

        System.out.print("Mark task ID " + id + " as complete? (true/false, current: '" + task.isCompleted() + "'): ");
        String completeInput = scanner.nextLine();
        boolean newStatus = task.isCompleted(); // Default to current status
        if (!completeInput.trim().isEmpty()) {
            newStatus = Boolean.parseBoolean(completeInput);
        }

        if (taskService.updateStatus(id, newStatus)) {
            System.out.println("Task status updated successfully!");
        } else {
            System.out.println("Failed to update task status.");
        }
    }
}
