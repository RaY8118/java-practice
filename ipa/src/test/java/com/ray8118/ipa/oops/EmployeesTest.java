package com.ray8118.ipa.oops;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EmployeesTest {

    @Test
    void testGetEmployeesByPerformanceAndDepartment() {
        Employees[] employees = {
                new Employees("E1", "Alice", "IT", 70000, "2019-05-20", 5),
                new Employees("E2", "Bob", "IT", 50000, "2021-06-15", 4),
                new Employees("E3", "Charlie", "HR", 45000, "2020-02-10", 3)
        };

        Employees[] result = new Employees().getEmployeesByPerformanceAndDepartment(employees, "IT", 4);
        assertEquals(2, result.length);
        assertEquals("Alice", result[0].getName()); // Highest salary first
    }

    @Test
    void testCalculateDepartmentWiseBonus() {
        Employees[] employees = {
                new Employees("E1", "Alice", "IT", 100000, "2018-01-01", 5),
                new Employees("E2", "Bob", "Finance", 80000, "2019-06-01", 3),
                new Employees("E3", "Charlie", "HR", 60000, "2020-03-01", 4)
        };

        new Employees().calculateDepartmentWiseBonus(employees);

        // Verify updated salaries
        assertEquals(115000, employees[0].getSalary(), 0.1); // IT +15%
        assertEquals(89600, employees[1].getSalary(), 0.1); // Finance +12%
        assertEquals(67200, employees[2].getSalary(), 0.1); // HR +12%
    }

    @Test
    void testFindSeniorEmployees() {
        Employees[] employees = {
                new Employees("E1", "Alice", "IT", 70000, "2017-10-01", 5),
                new Employees("E2", "Bob", "HR", 60000, "2023-01-01", 4)
        };

        Employees[] seniors = new Employees().findSeniorEmployees(employees,
                "2025-10-01");

        assertEquals(1, seniors.length);
        assertEquals("Alice", seniors[0].getName());
    }
}
