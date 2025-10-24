// Scenario:
// You’re given data for multiple students (name, roll number, marks, department).
//
// Tasks:
//
// Create a Student class with these attributes and appropriate getters/setters.
//
// Write a method getAverageMarksByDepartment(String dept) that returns the average marks of all students in that department.
//
// Write another method getTopper() that returns the Student object with the highest marks overall.

package com.ray8118.ipa.oops;

import com.ray8118.ipa.TestHelper;

public class Student {

  private String name;
  private int rollNumber;
  private int marks;
  private String department;

  public Student(String name, int rollNumber, int marks, String department) {
    this.name = name;
    this.rollNumber = rollNumber;
    this.marks = marks;
    this.department = department;
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

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  @Override
  public String toString() {
    return "Student [name=" + name + ", rollNumber=" + rollNumber + ", marks=" + marks + ", department=" + department
        + "]";
  }

  public static int getAverageMarksByDepartment(Student[] students, String department) {
    int totalMarks = 0;
    int deptStudents = 0;

    for (Student student : students) {
      if (student.getDepartment().equals(department)) {
        totalMarks += student.getMarks();
        deptStudents++;
      }
    }
    return deptStudents == 0 ? 0 : (totalMarks / deptStudents);
  }

  public static void main(String[] args) {
    Student[] students = {
        new Student("Alice", 1, 90, "CS"),
        new Student("Bob", 2, 80, "CS"),
        new Student("Charlie", 3, 70, "IT"),
        new Student("Diana", 4, 85, "CS")
    };

    TestHelper.assertEqual("CS average", getAverageMarksByDepartment(students, "CS"), 85);
    TestHelper.assertEqual("IT average", getAverageMarksByDepartment(students, "IT"), 70);
    TestHelper.assertEqual("ECE average (none)", getAverageMarksByDepartment(students, "ECE"), 0);
    // runTests();
  }

  public static void runTests() {
    Student[] students = {
        new Student("Alice", 1, 90, "CS"),
        new Student("Bob", 1, 80, "CS"),
        new Student("Charlie", 3, 70, "IT"),
        new Student("Diana", 4, 85, "CS")
    };

    test("CS average", getAverageMarksByDepartment(students, "CS"), 85);
    test("IT average", getAverageMarksByDepartment(students, "IT"), 70);
    test("ECE average (no students)", getAverageMarksByDepartment(students, "ECE"), 0);

  }

  public static void test(String testName, int actual, int expected) {
    if (actual == expected) {
      System.out.println("✅ " + testName + " passed (" + actual + ")");
    } else {
      System.out.println("❌ " + testName + " failed — expected " + expected + ", got " + actual);
    }
  }
}
