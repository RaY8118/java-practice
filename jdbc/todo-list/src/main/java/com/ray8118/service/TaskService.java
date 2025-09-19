package com.ray8118.service;

import java.util.List;

import com.ray8118.dao.TaskDao;
import com.ray8118.model.Task;

public class TaskService {
    private final TaskDao taskDao;

    public TaskService(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public TaskService() {
        this.taskDao = new TaskDao();
    }

    public boolean addTask(String title, String description) {
        Task task = new Task(title, description);
        taskDao.addTask(task);
        return true;
    }

    public Task getTaskById(int id) {
        Task task = taskDao.getTaskById(id);
        return task;
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = taskDao.getAllTasks();
        return tasks;
    }

    public void deleteTask(int id) {
        taskDao.deleteTaskById(id);
    }

    public boolean updateStatus(int id, boolean status) {
        return taskDao.updateStatus(id, status);
    }

    public boolean updateTask(Task task) {
        return taskDao.updateTask(task);
    }
}
