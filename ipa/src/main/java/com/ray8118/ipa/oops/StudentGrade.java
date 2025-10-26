// ### 🔷 **Problem 15 – Student Grade Calculator**

// Create a `Student` class with:

// * `name` (String)
// * `rollNumber` (int)
// * `marks` (int)
// * `grade` (String)

// Write:

// 1. A method `calculateGrade(Student[] students)` that assigns grades based on marks:
//    * A: 90-100
//    * B: 80-89
//    * C: 70-79
//    * D: 60-69
//    * F: below 60

//    Return an array of updated Student objects.
// 2. A method `getStudentsByGrade(Student[] students, String grade)` to return an array of students with the specified grade. Return an empty array if none found.
// 3. A method `getTopScorer(Student[] students)` to return the student with the highest marks. Return null if no students exist.
package com.ray8118.ipa.oops;

import java.util.ArrayList;
import java.util.List;

public class StudentGrade {
    private String name;
    private int rollNumber;
    private int marks;
    private String grade;

    public StudentGrade() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public StudentGrade[] calculateGrade(StudentGrade[] students) {
        for (StudentGrade student : students) {
            int marks = student.getMarks();
            if (marks < 100 && marks > 90) {
                student.setGrade("A");
            } else if (marks < 90 && marks > 80) {
                student.setGrade("B");
            } else if (marks < 80 && marks > 70) {
                student.setGrade("C");
            } else if (marks < 70 && marks > 60) {
                student.setGrade("D");
            } else if (marks < 60) {
                student.setGrade("F");
            }
        }
        return students;
    }

    public StudentGrade[] getStudentsByGrade(StudentGrade[] students, String grade) {
        List<StudentGrade> gradedStudents = new ArrayList<>();
        for (StudentGrade student : students) {
            if (student.getGrade().equals(grade)) {
                gradedStudents.add(student);
            }
        }

        return gradedStudents.toArray(new StudentGrade[0]);
    }

    public StudentGrade getTopScorer(StudentGrade[] students) {
        StudentGrade topStudent = null;
        for (StudentGrade student : students) {
            if (topStudent == null || student.getMarks() > topStudent.getMarks()) {
                topStudent = student;
            }
        }
        return topStudent;
    }
}
