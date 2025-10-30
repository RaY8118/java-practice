package com.ray8118.ipa.oops;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    // Test data
    private Course[] getSampleCourses() {
        return new Course[] {
                new Course("C001", "Math I", "Dr. Smith", 3, 30, 25, "Science"),
                new Course("C002", "Physics I", "Dr. Smith", 4, 25, 25, "Science"),
                new Course("C003", "Chemistry", "Dr. Jones", 3, 20, 18, "Science"),
                new Course("C004", "History", "Dr. Brown", 3, 40, 40, "Humanities"),
                new Course("C005", "Literature", "Dr. Brown", 3, 35, 30, "Humanities"),
                new Course("C006", "Computer Science I", "Dr. Smith", 4, 30, 20, "Engineering"),
                new Course("C007", "Data Structures", "Dr. Smith", 4, 20, 20, "Engineering"),
                new Course("C008", "Algorithms", "Dr. White", 3, 25, 10, "Engineering")
        };
    }

    @Test
    void testGetAvailableCourses_someAvailable() {
        Course[] courses = getSampleCourses();
        Course[] availableCourses = Course.getAvailableCourses(courses);

        assertNotNull(availableCourses);
        assertEquals(5, availableCourses.length); // C001, C003, C005, C006, C008
        // Verify sorting by available slots descending
        assertEquals("C008", availableCourses[0].getCourseId()); // 15 slots
        assertEquals("C006", availableCourses[1].getCourseId()); // 10 slots
        assertEquals("C001", availableCourses[2].getCourseId()); // 5 slots
        assertEquals("C005", availableCourses[3].getCourseId()); // 5 slots
        assertEquals("C003", availableCourses[4].getCourseId()); // 2 slots
    }

    @Test
    void testGetAvailableCourses_noAvailable() {
        Course[] courses = new Course[] {
                new Course("C001", "Math I", "Dr. Smith", 3, 30, 30, "Science"),
                new Course("C002", "Physics I", "Dr. Smith", 4, 25, 25, "Science")
        };
        Course[] availableCourses = Course.getAvailableCourses(courses);
        assertNotNull(availableCourses);
        assertEquals(0, availableCourses.length);
    }

    @Test
    void testGetAvailableCourses_emptyArray() {
        Course[] courses = {};
        Course[] availableCourses = Course.getAvailableCourses(courses);
        assertNotNull(availableCourses);
        assertEquals(0, availableCourses.length);
    }

    @Test
    void testGetCoursesByInstructorWorkload_withinMaxCredits() {
        Course[] courses = getSampleCourses();
        Course[] smithCourses = Course.getCoursesByInstructorWorkload(courses, "Dr. Smith", 16);

        assertNotNull(smithCourses);
        assertEquals(4, smithCourses.length); // C001 (3), C002 (4), C006 (4), C007 (4) = 15 credits
        assertEquals("C001", smithCourses[0].getCourseId());
        assertEquals("C002", smithCourses[1].getCourseId());
        assertEquals("C006", smithCourses[2].getCourseId());
        assertEquals("C007", smithCourses[3].getCourseId());
    }

    @Test
    void testGetCoursesByInstructorWorkload_exceedsMaxCredits() {
        Course[] courses = getSampleCourses();
        Course[] smithCourses = Course.getCoursesByInstructorWorkload(courses, "Dr. Smith", 10); // C001 (3), C002 (4),
                                                                                                 // C006 (4), C007 (4) =
                                                                                                 // 15 credits

        assertNotNull(smithCourses);
        assertEquals(0, smithCourses.length);
    }

    @Test
    void testGetCoursesByInstructorWorkload_noInstructorFound() {
        Course[] courses = getSampleCourses();
        Course[] unknownInstructorCourses = Course.getCoursesByInstructorWorkload(courses, "Dr. Zzz", 10);
        assertNotNull(unknownInstructorCourses);
        assertEquals(0, unknownInstructorCourses.length);
    }

    @Test
    void testGetCoursesByInstructorWorkload_emptyArray() {
        Course[] courses = {};
        Course[] result = Course.getCoursesByInstructorWorkload(courses, "Dr. Smith", 10);
        assertNotNull(result);
        assertEquals(0, result.length);
    }

}
