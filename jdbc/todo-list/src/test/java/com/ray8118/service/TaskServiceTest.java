package com.ray8118.service;

import com.ray8118.dao.TaskDao;
import com.ray8118.exception.DaoException;
import com.ray8118.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TaskServiceTest {

    // @Mock creates a mock instance of TaskDao
    @Mock
    private TaskDao taskDao;

    // @InjectMocks injects the mocked TaskDao into TaskService
    // Now that TaskService has a constructor for TaskDao, Mockito can inject it.
    @InjectMocks
    private TaskService taskService;

    // This method runs before each test. It initializes the mocks.
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddTask_Success() {
        // Arrange: Define the behavior of the mocked TaskDao
        // When taskDao.addTask is called with any Task object, do nothing (void method)
        doNothing().when(taskDao).addTask(any(Task.class));

        // Act: Call the method under test
        boolean result = taskService.addTask("Test Title", "Test Description");

        // Assert: Verify the outcome
        assertTrue(result);
        // Verify that taskDao.addTask was called exactly once with any Task object
        verify(taskDao, times(1)).addTask(any(Task.class));
    }

    @Test(expected = DaoException.class)
    public void testAddTask_DaoException() {
        // Arrange: Simulate a DaoException when taskDao.addTask is called
        doThrow(new DaoException("DB Error")).when(taskDao).addTask(any(Task.class));

        // Act & Assert: Expect a DaoException to be thrown when calling addTask
        taskService.addTask("Test Title", "Test Description");
    }

    @Test
    public void testGetTaskById_Found() {
        // Arrange: Create a sample task and define mock behavior
        Task expectedTask = new Task("Test Title", "Test Description");
        expectedTask.setTodo_id(1);
        when(taskDao.getTaskById(1)).thenReturn(expectedTask);

        // Act
        Task result = taskService.getTaskById(1);

        // Assert
        assertNotNull(result);
        assertEquals(expectedTask.getTodo_id(), result.getTodo_id());
        assertEquals(expectedTask.getTitle(), result.getTitle());
        verify(taskDao, times(1)).getTaskById(1);
    }

    @Test
    public void testGetTaskById_NotFound() {
        // Arrange: Define mock behavior for a non-existent ID
        when(taskDao.getTaskById(99)).thenReturn(null);

        // Act
        Task result = taskService.getTaskById(99);

        // Assert
        assertNull(result);
        verify(taskDao, times(1)).getTaskById(99);
    }

    @Test
    public void testGetAllTasks_NotEmpty() {
        // Arrange: Create a list of sample tasks
        List<Task> expectedTasks = Arrays.asList(
                new Task("Task 1", "Desc 1"),
                new Task("Task 2", "Desc 2")
        );
        when(taskDao.getAllTasks()).thenReturn(expectedTasks);

        // Act
        List<Task> result = taskService.getAllTasks();

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        verify(taskDao, times(1)).getAllTasks();
    }

    @Test
    public void testGetAllTasks_Empty() {
        // Arrange: Define mock behavior for an empty list
        when(taskDao.getAllTasks()).thenReturn(Collections.emptyList());

        // Act
        List<Task> result = taskService.getAllTasks();

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(taskDao, times(1)).getAllTasks();
    }

    @Test
    public void testDeleteTask_Success() {
        // Arrange
        doNothing().when(taskDao).deleteTaskById(1);

        // Act
        taskService.deleteTask(1);

        // Assert
        verify(taskDao, times(1)).deleteTaskById(1);
    }

    @Test
    public void testUpdateStatus_Success() {
        // Arrange
        when(taskDao.updateStatus(1, true)).thenReturn(true);

        // Act
        boolean result = taskService.updateStatus(1, true);

        // Assert
        assertTrue(result);
        verify(taskDao, times(1)).updateStatus(1, true);
    }

    @Test
    public void testUpdateStatus_Failure() {
        // Arrange
        when(taskDao.updateStatus(1, false)).thenReturn(false);

        // Act
        boolean result = taskService.updateStatus(1, false);

        // Assert
        assertFalse(result);
        verify(taskDao, times(1)).updateStatus(1, false);
    }

    @Test
    public void testUpdateTask_Success() {
        // Arrange
        Task taskToUpdate = new Task("Old Title", "Old Desc");
        taskToUpdate.setTodo_id(1);
        when(taskDao.updateTask(any(Task.class))).thenReturn(true);

        // Act
        boolean result = taskService.updateTask(taskToUpdate);

        // Assert
        assertTrue(result);
        verify(taskDao, times(1)).updateTask(any(Task.class));
    }

    @Test
    public void testUpdateTask_Failure() {
        // Arrange
        Task taskToUpdate = new Task("Old Title", "Old Desc");
        taskToUpdate.setTodo_id(1);
        when(taskDao.updateTask(any(Task.class))).thenReturn(false);

        // Act
        boolean result = taskService.updateTask(taskToUpdate);

        // Assert
        assertFalse(result);
        verify(taskDao, times(1)).updateTask(any(Task.class));
    }
}
