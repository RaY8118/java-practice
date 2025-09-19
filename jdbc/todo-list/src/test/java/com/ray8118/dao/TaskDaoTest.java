package com.ray8118.dao;

import com.ray8118.exception.DaoException;
import com.ray8118.model.Task;
import com.ray8118.utils.DBConnection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class TaskDaoTest {

    private TaskDao taskDao;

    // This method runs before each test to set up the test environment.
    @Before
    public void setUp() throws SQLException {
        taskDao = new TaskDao();
        // Ensure the table is clean before each test
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("TRUNCATE TABLE tasks RESTART IDENTITY")) {
            statement.executeUpdate();
        }
    }

    // This method runs after each test to clean up the test environment.
    @After
    public void tearDown() throws SQLException {
        // Truncate table again to ensure clean state for subsequent runs if any test fails to clean up
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("TRUNCATE TABLE tasks RESTART IDENTITY")) {
            statement.executeUpdate();
        }
    }

    @Test
    public void testAddTask() {
        Task task = new Task("Test Add", "Description for add");
        taskDao.addTask(task);

        List<Task> tasks = taskDao.getAllTasks();
        assertFalse(tasks.isEmpty());
        assertEquals(1, tasks.size());
        assertEquals("Test Add", tasks.get(0).getTitle());
    }

    @Test
    public void testGetTaskById_Found() {
        Task task = new Task("Test Get", "Description for get");
        taskDao.addTask(task);

        // Assuming the ID will be 1 after the first insert due to RESTART IDENTITY
        Task foundTask = taskDao.getTaskById(1);
        assertNotNull(foundTask);
        assertEquals("Test Get", foundTask.getTitle());
        assertEquals("Description for get", foundTask.getDescription());
        assertFalse(foundTask.isCompleted());
    }

    @Test
    public void testGetTaskById_NotFound() {
        Task foundTask = taskDao.getTaskById(99);
        assertNull(foundTask);
    }

    @Test
    public void testGetAllTasks_Empty() {
        List<Task> tasks = taskDao.getAllTasks();
        assertTrue(tasks.isEmpty());
    }

    @Test
    public void testGetAllTasks_NotEmpty() {
        taskDao.addTask(new Task("Task 1", "Desc 1"));
        taskDao.addTask(new Task("Task 2", "Desc 2"));

        List<Task> tasks = taskDao.getAllTasks();
        assertEquals(2, tasks.size());
    }

    @Test
    public void testDeleteTaskById_Found() {
        taskDao.addTask(new Task("Task to Delete", "Desc"));
        List<Task> tasksBeforeDelete = taskDao.getAllTasks();
        assertEquals(1, tasksBeforeDelete.size());

        taskDao.deleteTaskById(1);

        List<Task> tasksAfterDelete = taskDao.getAllTasks();
        assertTrue(tasksAfterDelete.isEmpty());
    }

    @Test
    public void testDeleteTaskById_NotFound() {
        taskDao.addTask(new Task("Task to Keep", "Desc"));
        taskDao.deleteTaskById(99); // Try to delete non-existent task

        List<Task> tasks = taskDao.getAllTasks();
        assertEquals(1, tasks.size()); // Should still have the original task
    }

    @Test
    public void testUpdateStatus() {
        taskDao.addTask(new Task("Task to Update Status", "Desc"));
        Task originalTask = taskDao.getTaskById(1);
        assertFalse(originalTask.isCompleted());

        boolean updated = taskDao.updateStatus(1, true);
        assertTrue(updated);

        Task updatedTask = taskDao.getTaskById(1);
        assertTrue(updatedTask.isCompleted());
    }

    @Test
    public void testUpdateStatus_NotFound() {
        boolean updated = taskDao.updateStatus(99, true);
        assertFalse(updated);
    }

    @Test
    public void testUpdateTask() {
        taskDao.addTask(new Task("Original Title", "Original Desc"));
        Task taskToUpdate = taskDao.getTaskById(1);
        assertNotNull(taskToUpdate);

        taskToUpdate.setTitle("New Title");
        taskToUpdate.setDescription("New Desc");
        taskToUpdate.setCompleted(true);

        boolean updated = taskDao.updateTask(taskToUpdate);
        assertTrue(updated);

        Task retrievedTask = taskDao.getTaskById(1);
        assertEquals("New Title", retrievedTask.getTitle());
        assertEquals("New Desc", retrievedTask.getDescription());
        assertTrue(retrievedTask.isCompleted());
    }

    @Test
    public void testUpdateTask_NotFound() {
        Task nonExistentTask = new Task("Non Existent", "Desc");
        nonExistentTask.setTodo_id(99);
        boolean updated = taskDao.updateTask(nonExistentTask);
        assertFalse(updated);
    }

    @Test(expected = DaoException.class)
    public void testAddTask_DaoException() {
        // Simulate a scenario where DBConnection fails (e.g., wrong credentials)
        // This is harder to test directly without modifying DBConnection for testing purposes.
        // For now, we rely on DBConnection's own tests or integration tests to cover connection failures.
        // This test primarily ensures that if an SQLException occurs, it's wrapped in DaoException.
        // We can't easily force an SQLException here without breaking the connection for other tests.
        // A more robust approach would involve a test-specific DBConnection or mocking static methods.
        // For demonstration, we'll assume an underlying SQLException would lead to DaoException.
        // This test will pass if any SQLException during addTask is correctly wrapped.
        // (Note: This test might be brittle or require specific setup to reliably trigger an SQLException)
        taskDao.addTask(new Task(null, null)); // This might trigger a NOT NULL constraint violation, leading to SQLException
    }
}
