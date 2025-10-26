package com.ray8118.ipa.oops;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    void testCalculateBonus_experienceGreaterThan5() {
        Employee[] employees = {
            new Employee("Alice", 50000, 6),
            new Employee("Bob", 40000, 2)
        };
        Employee[] updated = Employee.calculateBonus(employees);
        assertEquals(60000, updated[0].getSalary()); // 50000 + 20% bonus
        assertEquals(44000, updated[1].getSalary()); // 40000 + 10% bonus
    }

    @Test
    void testCalculateBonus_experienceEqualTo5() {
        Employee[] employees = {
            new Employee("Charlie", 30000, 5)
        };
        Employee[] updated = Employee.calculateBonus(employees);
        assertEquals(33000, updated[0].getSalary()); // 30000 + 10% bonus
    }

    @Test
    void testCalculateBonus_multipleEmployees() {
        Employee[] employees = {
            new Employee("Alice", 50000, 6),
            new Employee("Bob", 40000, 2),
            new Employee("Charlie", 60000, 8)
        };
        Employee[] updated = Employee.calculateBonus(employees);
        assertEquals(60000, updated[0].getSalary());
        assertEquals(44000, updated[1].getSalary());
        assertEquals(72000, updated[2].getSalary());
    }

    @Test
    void testCalculateBonus_emptyArray() {
        Employee[] employees = {};
        Employee[] updated = Employee.calculateBonus(employees);
        assertEquals(0, updated.length);
    }

    @Test
    void testGetEmployeesByExperience_minExperience5() {
        Employee[] employees = {
            new Employee("Alice", 50000, 6),
            new Employee("Bob", 40000, 2),
            new Employee("Charlie", 60000, 8)
        };
        Employee[] experienced = Employee.getEmployeesByExperience(employees, 5);
        assertEquals(2, experienced.length);
        assertEquals("Alice", experienced[0].getEmpName());
        assertEquals("Charlie", experienced[1].getEmpName());
    }

    @Test
    void testGetEmployeesByExperience_minExperience10() {
        Employee[] employees = {
            new Employee("Alice", 50000, 6),
            new Employee("Bob", 40000, 2),
            new Employee("Charlie", 60000, 8)
        };
        Employee[] experienced = Employee.getEmployeesByExperience(employees, 10);
        assertEquals(0, experienced.length);
    }

    @Test
    void testGetEmployeesByExperience_allQualify() {
        Employee[] employees = {
            new Employee("Alice", 50000, 6),
            new Employee("Bob", 40000, 7)
        };
        Employee[] experienced = Employee.getEmployeesByExperience(employees, 5);
        assertEquals(2, experienced.length);
    }

    @Test
    void testGetEmployeesByExperience_emptyArray() {
        Employee[] employees = {};
        Employee[] experienced = Employee.getEmployeesByExperience(employees, 5);
        assertEquals(0, experienced.length);
    }
}