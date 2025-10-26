package com.ray8118.ipa.oops;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    void testGetAverageMarksByDepartment_existingDepartment() {
        Student[] students = {
            new Student("Alice", 1, 90, "CS"),
            new Student("Bob", 2, 80, "CS"),
            new Student("Charlie", 3, 70, "IT")
        };
        assertEquals(85, Student.getAverageMarksByDepartment(students, "CS"));
    }

    @Test
    void testGetAverageMarksByDepartment_singleStudent() {
        Student[] students = {
            new Student("Alice", 1, 90, "CS")
        };
        assertEquals(90, Student.getAverageMarksByDepartment(students, "CS"));
    }

    @Test
    void testGetAverageMarksByDepartment_nonExistentDepartment() {
        Student[] students = {
            new Student("Alice", 1, 90, "CS"),
            new Student("Bob", 2, 80, "IT")
        };
        assertEquals(0, Student.getAverageMarksByDepartment(students, "ECE"));
    }

    @Test
    void testGetAverageMarksByDepartment_emptyArray() {
        Student[] students = {};
        assertEquals(0, Student.getAverageMarksByDepartment(students, "CS"));
    }

    @Test
    void testGetTopper_multipleStudents() {
        Student[] students = {
            new Student("Alice", 1, 90, "CS"),
            new Student("Bob", 2, 95, "CS"),
            new Student("Charlie", 3, 85, "IT")
        };
        Student topper = Student.getTopper(students);
        assertNotNull(topper);
        assertEquals("Bob", topper.getName());
        assertEquals(95, topper.getMarks());
    }

    @Test
    void testGetTopper_singleStudent() {
        Student[] students = {
            new Student("Alice", 1, 90, "CS")
        };
        Student topper = Student.getTopper(students);
        assertNotNull(topper);
        assertEquals("Alice", topper.getName());
        assertEquals(90, topper.getMarks());
    }

    @Test
    void testGetTopper_emptyArray() {
        Student[] students = {};
        Student topper = Student.getTopper(students);
        assertNull(topper);
    }

    @Test
    void testGetTopper_nullArray() {
        Student[] students = null;
        Student topper = Student.getTopper(students);
        assertNull(topper);
    }

    @Test
    void testGetTopper_tieInMarks() {
        Student[] students = {
            new Student("Alice", 1, 90, "CS"),
            new Student("Bob", 2, 90, "IT")
        };
        Student topper = Student.getTopper(students);
        assertNotNull(topper);
        assertEquals(90, topper.getMarks());
        // Should return the first one encountered
        assertEquals("Alice", topper.getName());
    }
}