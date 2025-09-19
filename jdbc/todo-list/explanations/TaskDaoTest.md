# Explanation for `TaskDaoTest.java`

This file contains unit tests for the `TaskDao` class, which is responsible for interacting with the database to perform CRUD (Create, Read, Update, Delete) operations on `Task` objects. These tests ensure that the `TaskDao` methods correctly store, retrieve, modify, and delete task data in the database.

## Key Components and Concepts:

*   **`TaskDao taskDao;`**: An instance of the `TaskDao` class is created to be tested.
*   **`@Before` Annotation (`setUp()` method)**:
    *   This method runs *before each* test method in this class.
    *   **Purpose**: To set up a clean and consistent environment for every test. This is crucial for test isolation, meaning one test's actions don't affect another's.
    *   **Actions**: It initializes `taskDao` and, most importantly, executes a `TRUNCATE TABLE tasks RESTART IDENTITY` SQL command. This command deletes all data from the `tasks` table and resets the auto-incrementing ID counter, ensuring that each test starts with an empty table and predictable IDs (usually starting from 1).
*   **`@After` Annotation (`tearDown()` method)**:
    *   This method runs *after each* test method in this class.
    *   **Purpose**: To clean up any resources or data created during the test, further ensuring test isolation and preventing side effects on subsequent test runs.
    *   **Actions**: It also truncates the `tasks` table, acting as a safeguard in case a test fails before its intended cleanup, or if there are any lingering effects.
*   **Imports**: You'll see imports for `Task` (the data model), `DaoException` (for error handling), `DBConnection` (for database connectivity), and various JUnit assertions (`assertEquals`, `assertTrue`, `assertFalse`, `assertNull`, `assertNotNull`).

## Individual Test Methods (`@Test`):

Each method annotated with `@Test` represents a single test case. They generally follow the **Arrange-Act-Assert (AAA)** pattern:

1.  **Arrange**: Set up the necessary data and conditions for the test.
2.  **Act**: Call the method of the `TaskDao` that you want to test.
3.  **Assert**: Verify that the outcome of the action is as expected using JUnit assertion methods.

Let's look at some examples:

*   **`testAddTask()`**:
    *   **Arranges**: Creates a new `Task` object.
    *   **Acts**: Calls `taskDao.addTask(task)` to save it to the database.
    *   **Asserts**: Retrieves all tasks from the database (`getAllTasks()`) and then uses `assertFalse(tasks.isEmpty())` to check if the list is not empty, `assertEquals(1, tasks.size())` to ensure exactly one task was added, and `assertEquals("Test Add", tasks.get(0).getTitle())` to verify the title of the added task.

*   **`testGetTaskById_Found()`**:
    *   **Arranges**: Adds a task to the database first to ensure there's something to retrieve.
    *   **Acts**: Calls `taskDao.getTaskById(1)` to fetch the task by its ID.
    *   **Asserts**: Uses `assertNotNull(foundTask)` to confirm a task was returned, and then `assertEquals` to verify its title, description, and completion status.

*   **`testGetTaskById_NotFound()`**:
    *   **Arranges**: No tasks are added, or a non-existent ID is chosen.
    *   **Acts**: Calls `taskDao.getTaskById(99)` for an ID that definitely doesn't exist.
    *   **Asserts**: Uses `assertNull(foundTask)` to confirm that no task was returned, as expected.

*   **`testGetAllTasks_Empty()`**:
    *   **Arranges**: The `setUp()` method ensures the table is empty.
    *   **Acts**: Calls `taskDao.getAllTasks()`.
    *   **Asserts**: Uses `assertTrue(tasks.isEmpty())` to confirm the returned list is empty.

*   **`testDeleteTaskById_Found()`**:
    *   **Arranges**: Adds a task.
    *   **Acts**: Calls `taskDao.deleteTaskById(1)`.
    *   **Asserts**: Checks that the task list is now empty, confirming the deletion.

*   **`testUpdateStatus()`**:
    *   **Arranges**: Adds a task, then retrieves it to check its initial status.
    *   **Acts**: Calls `taskDao.updateStatus(1, true)` to mark it as completed.
    *   **Asserts**: Checks that the `updateStatus` method returned `true` (indicating success) and then retrieves the task again to verify its `isCompleted()` status is now `true`.

*   **`testUpdateTask()`**:
    *   **Arranges**: Adds a task, then retrieves it.
    *   **Acts**: Modifies the retrieved task's properties and then calls `taskDao.updateTask(taskToUpdate)`.
    *   **Asserts**: Checks for successful update and then retrieves the task again to verify all updated properties.

*   **`testAddTask_DaoException()`**:
    *   **`@Test(expected = DaoException.class)`**: This is a special annotation. It tells JUnit that this test is expected to throw a `DaoException`. If the `DaoException` is thrown, the test passes. If no exception is thrown, or a different exception is thrown, the test fails.
    *   **Purpose**: To verify that the `addTask` method correctly handles error conditions (like a `SQLException` from the database) by wrapping them in a `DaoException` and re-throwing them. The comment explains that directly simulating a database connection failure in a simple unit test can be tricky, but the goal is to ensure the exception handling mechanism works.

## Why these tests are important:

*   **Reliability**: They ensure that the `TaskDao` correctly interacts with the database as expected.
*   **Regression Prevention**: If changes are made to the `TaskDao` or the database schema, these tests can quickly catch if existing functionality has been broken.
*   **Documentation**: The tests serve as living documentation of how the `TaskDao` methods are supposed to behave.
*   **Confidence**: Passing tests give developers confidence that their code is working correctly.