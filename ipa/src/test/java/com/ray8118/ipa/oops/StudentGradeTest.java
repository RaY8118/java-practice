package com.ray8118.ipa.oops;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentGradeTest {

    private StudentGrade createStudent(String name, int roll, int marks) {
        StudentGrade s = new StudentGrade();
        s.setName(name);
        s.setRollNumber(roll);
        s.setMarks(marks);
        return s;
    }

    @Test
    void testCalculateGrade_AssignsCorrectGrades() {
        StudentGrade[] students = {
                createStudent("Alice", 1, 95),
                createStudent("Bob", 2, 85),
                createStudent("Charlie", 3, 75),
                createStudent("David", 4, 65),
                createStudent("Eve", 5, 50)
        };

        StudentGrade sg = new StudentGrade();
        StudentGrade[] updated = sg.calculateGrade(students);

        assertEquals("A", updated[0].getGrade(), "Alice should have A grade");
        assertEquals("B", updated[1].getGrade(), "Bob should have B grade");
        assertEquals("C", updated[2].getGrade(), "Charlie should have C grade");
        assertEquals("D", updated[3].getGrade(), "David should have D grade");
        assertEquals("F", updated[4].getGrade(), "Eve should have F grade");
    }

    @Test
    void testCalculateGrade_EmptyArray_ReturnsEmptyArray() {
        StudentGrade sg = new StudentGrade();
        StudentGrade[] result = sg.calculateGrade(new StudentGrade[0]);
        assertEquals(0, result.length);
    }

    @Test
    void testGetStudentsByGrade_ReturnsCorrectStudents() {
        StudentGrade[] students = {
                createStudent("Alice", 1, 95),
                createStudent("Bob", 2, 85),
                createStudent("Charlie", 3, 75),
                createStudent("David", 4, 88)
        };

        StudentGrade sg = new StudentGrade();
        sg.calculateGrade(students); // must assign grades first

        StudentGrade[] bStudents = sg.getStudentsByGrade(students, "B");

        assertEquals(2, bStudents.length);
        assertEquals("Bob", bStudents[0].getName());
        assertEquals("David", bStudents[1].getName());
    }

    @Test
    void testGetStudentsByGrade_NoMatch_ReturnsEmptyArray() {
        StudentGrade[] students = {
                createStudent("Alice", 1, 95),
                createStudent("Bob", 2, 85)
        };

        StudentGrade sg = new StudentGrade();
        sg.calculateGrade(students);

        StudentGrade[] cStudents = sg.getStudentsByGrade(students, "C");
        assertEquals(0, cStudents.length);
    }

    @Test
    void testGetTopScorer_ReturnsHighestMarksStudent() {
        StudentGrade[] students = {
                createStudent("Alice", 1, 90),
                createStudent("Bob", 2, 95),
                createStudent("Charlie", 3, 85)
        };

        StudentGrade sg = new StudentGrade();
        StudentGrade top = sg.getTopScorer(students);

        assertNotNull(top);
        assertEquals("Bob", top.getName());
        assertEquals(95, top.getMarks());
    }

    @Test
    void testGetTopScorer_EmptyArray_ReturnsNull() {
        StudentGrade sg = new StudentGrade();
        StudentGrade top = sg.getTopScorer(new StudentGrade[0]);
        assertNull(top);
    }
}
