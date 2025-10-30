// ### 🔷 **Problem 23 – University Course Management**
//
// Create a `Course` class with:
//
// * `courseId` (String)
// * `courseName` (String)
// * `instructor` (String)
// * `credits` (int)
// * `maxCapacity` (int)
// * `enrolledStudents` (int)
// * `department` (String)
//
// Write:
//
// 1. A method `getAvailableCourses(Course[] courses)` that returns courses where enrolledStudents < maxCapacity, sorted by available slots descending. Return empty array if none found.
//
// 2. A method `getCoursesByInstructorWorkload(Course[] courses, String instructor, int maxCredits)` that returns courses taught by the instructor where total credits across all their courses <= maxCredits. Return empty array if none found.
//
// 3. A method `optimizeCourseAssignment(Course[] courses)` that redistributes students from over-capacity courses to under-capacity courses in the same department, ensuring no course exceeds maxCapacity. Return the optimized courses array.
//
// ---
package com.ray8118.ipa.oops;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseId;
    private String courseName;
    private String instructor;
    private int credits;
    private int maxCapacity;
    private int enrolledStudents;
    private String department;

    public Course(String courseId, String courseName, String instructor, int credits, int maxCapacity,
            int enrolledStudents, String department) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.credits = credits;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = enrolledStudents;
        this.department = department;
    }

    public Course() {
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(int enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public static Course[] getAvailableCourses(Course[] courses) {
        List<Course> availableCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.getEnrolledStudents() < course.maxCapacity) {
                availableCourses.add(course);
            }
        }

        Course[] sortedCourse = availableCourses.toArray(new Course[0]);

        for (int i = 0; i < sortedCourse.length - 1; i++) {
            for (int j = 0; j < sortedCourse.length - i - 1; j++) {
                int availableSlots1 = sortedCourse[j].getMaxCapacity() - sortedCourse[j].getEnrolledStudents();
                int availableSlots2 = sortedCourse[j + 1].getMaxCapacity() - sortedCourse[j + 1].getEnrolledStudents();
                if (availableSlots1 < availableSlots2) {
                    Course temp = sortedCourse[j];
                    sortedCourse[j] = sortedCourse[j + 1];
                    sortedCourse[j + 1] = temp;
                }
            }
        }

        return sortedCourse;

    }

    public static Course[] getCoursesByInstructorWorkload(Course[] courses, String instructor, int maxCredits) {
        List<Course> instructorCourses = new ArrayList<>();
        int totalCredits = 0;
        for (Course course : courses) {
            if (course.getInstructor().equals(instructor)) {
                instructorCourses.add(course);
                totalCredits += course.getCredits();
            }
        }
        return (totalCredits <= maxCredits) ? instructorCourses.toArray(new Course[0]) : new Course[0];
    }

}
