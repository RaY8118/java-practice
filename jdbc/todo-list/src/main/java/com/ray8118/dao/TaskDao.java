package com.ray8118.dao;

import com.ray8118.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.ray8118.model.Task;
import com.ray8118.utils.DBConnection;

public class TaskDao {
    private static final Logger LOGGER = Logger.getLogger(TaskDao.class.getName());
    private static final String INSERT = "INSERT into tasks (title, description) values (?, ?)";
    private static final String GET = "SELECT * from tasks WHERE todo_id = ?";
    private static final String GETALL = "SELECT * from tasks";
    private static final String DELETE = "DELETE FROM tasks where todo_id = ?";
    private static final String UPDATESTATUS = "UPDATE tasks SET iscompleted =? where todo_id = ?";
    private static final String UPDATETASK = "UPDATE tasks set title = ?, description = ?, isCompleted = ? WHERE todo_id = ?";

    public void addTask(Task task) {
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setString(2, task.getDescription());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Error adding task", e);
        }
    }

    public Task getTaskById(int id) {
        Task task = null;
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(GET)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    task = new Task();
                    task.setTodo_id(rs.getInt("todo_id"));
                    task.setTitle(rs.getString("title"));
                    task.setDescription(rs.getString("description"));
                    task.setCompleted(rs.getBoolean("iscompleted"));
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error getting task by id", e);
        }
        return task;
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(GETALL)) {
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    Task task = new Task();
                    task.setTodo_id(rs.getInt("todo_id"));
                    task.setTitle(rs.getString("title"));
                    task.setDescription(rs.getString("description"));
                    task.setCompleted(rs.getBoolean("iscompleted"));

                    tasks.add(task);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Error getting all tasks", e);
        }

        return tasks;
    }

    public void deleteTaskById(int id) {
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, id);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                LOGGER.info("Task deleted successfully: " + id);
            } else {
                LOGGER.info("Tasks with provided id doesn't exist");
            }
        } catch (SQLException e) {
            throw new DaoException("Error deleting task by id", e);
        }
    }

    public boolean updateStatus(int id, boolean status) {
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATESTATUS)) {
            preparedStatement.setBoolean(1, status);
            preparedStatement.setInt(2, id);

            int rowsUpdated = preparedStatement.executeUpdate();

            return rowsUpdated > 0;

        } catch (SQLException e) {
            throw new DaoException("Error updating task status", e);
        }
    }

    public boolean updateTask(Task task) {
        try (Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATETASK)) {
            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setBoolean(3, task.isCompleted());
            preparedStatement.setInt(4, task.getTodo_id());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            throw new DaoException("Error updating task", e);
        }
    }

}
