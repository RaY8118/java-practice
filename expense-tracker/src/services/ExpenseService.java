package services;

import java.time.LocalDate;
import java.util.HashMap;

import models.Expense;

public class ExpenseService {
  private HashMap<Integer, Expense> expenses = new HashMap<>();
  private int nextId = 1;

  public void addExpense(String description, double amount, String category, LocalDate date) {
    Expense expense = new Expense(nextId++, description, amount, category, date);
    expenses.put(expense.getId(), expense);
  }

  public void removeExpense(int id) {
    expenses.remove(id);
  }

  public void listAllExpenses() {
    for (Expense expense : expenses.values()) {
      System.out.println("ID: " + expense.getId() + ", Description: " + expense.getDescription() +
          ", Amount: " + expense.getAmount() + ", Category: " + expense.getCategory() +
          ", Date: " + expense.getDate());
    }
  }

  public void listExpensesByCategory(String category) {
    for (Expense expense : expenses.values()) {
      if (expense.getCategory().equalsIgnoreCase(category)) {
        System.out.println("ID: " + expense.getId() + ", Description: " + expense.getDescription() +
            ", Amount: " + expense.getAmount() + ", Date: " + expense.getDate());
      }
    }
  }

  public double getTotalSpent() {
    double total = 0;
    for (Expense expense : expenses.values()) {
      total += expense.getAmount();
    }
    return total;
  }
}
