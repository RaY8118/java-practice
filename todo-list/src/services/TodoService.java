package services;

import java.util.HashMap;
import models.Task;

public class TodoService {

    private final HashMap<Integer, Task> tasks;
    private int nextId = 1;

    public TodoService() {
        tasks = new HashMap<>();
    }

    public void addTask(String title, String description) {
        Task task = new Task(nextId++, title, description);
        tasks.put(task.getId(), task);
    }

    public void removeTask(int id) {
        tasks.remove(id);
    }

    public void updateTask(int id, String title, String description) {
        Task task = tasks.get(id);
        if (task != null) {
            task.setTitle(title);
            task.setDescription(description);
        }
    }

    public void markTaskCompleted(int id) {
        Task task = tasks.get(id);
        if (task != null) {
            task.markAsCompleted();
        }
    }

    public void markTaskPending(int id) {
        Task task = tasks.get(id);
        if (task != null) {
            task.markAsPending();
        }
    }

    public void listAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available");
        }
        for (Task task : tasks.values()) {
            System.out.println(task);
        }
    }

    public void listCompletedTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available");
        }
        if (tasks.values().stream().noneMatch(Task::isCompleted)) {
            System.out.println("No completed tasks available");
            return;
        }
        for (Task task : tasks.values()) {
            if (task.isCompleted()) {
                System.out.println(task);
            }
        }
    }

    public void listPendingTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available");
        }
        if (tasks.values().stream().noneMatch(task -> !task.isCompleted())) {
            System.out.println("No pending tasks available");
            return;
        }
        for (Task task : tasks.values()) {
            if (!task.isCompleted()) {
                System.out.println(task);
            }
        }
    }

}
