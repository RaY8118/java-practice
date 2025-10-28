// ### 🔷 **Problem 21 – Advanced Employee Management System**

// Create an `Employees` class with:

// * `empId` (String)
// * `name` (String)
// * `department` (String)
// * `salary` (double)
// * `joiningDate` (String) - format: "YYYY-MM-DD"
// * `performanceRating` (int) - 1 to 5

// Write:

// 1. A method `getEmployeesByPerformanceAndDepartment(Employee[] employees, String department, int minRating)` that returns employees from the specified department with performance rating >= minRating, sorted by salary descending. Return empty array if none found.

// 2. A method `calculateDepartmentWiseBonus(Employee[] employees)` that gives bonus based on:
//    - Department "IT": 15% bonus if rating >= 4, 10% otherwise
//    - Department "HR": 12% bonus if rating >= 3, 8% otherwise
//    - Department "Finance": 18% bonus if rating >= 4, 12% otherwise
//    - Other departments: 10% bonus if rating >= 3, 5% otherwise
//    Return updated employees array.

// 3. A method `findSeniorEmployees(Employee[] employees, String currentDate)` that returns employees who have been with the company for more than 5 years (calculate from joiningDate to currentDate). Return empty array if none found.

// ---
package com.ray8118.ipa.oops;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Employees {
    private String empId;
    private String name;
    private String department;
    private double salary;
    private String joiningDate;
    private int performanceRating;

    public Employees() {
    }

    public Employees(String empId, String name, String department, double salary, String joiningDate,
            int performanceRating) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.performanceRating = performanceRating;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public int getPerformanceRating() {
        return performanceRating;
    }

    public void setPerformanceRating(int performanceRating) {
        this.performanceRating = performanceRating;
    }

    public Employees[] getEmployeesByPerformanceAndDepartment(Employees[] employees, String department, int minRating) {
        List<Employees> deptEmployees = new ArrayList<>();
        for (Employees employees2 : employees) {
            if (employees2.getDepartment().equals(department)) {
                if (employees2.getPerformanceRating() >= minRating) {
                    deptEmployees.add(employees2);
                }
            }
        }

        Employees[] sortedEmployees = deptEmployees.toArray(new Employees[0]);

        for (int i = 0; i < sortedEmployees.length - 1; i++) {
            for (int j = 0; j < sortedEmployees.length - i - 1; j++) {
                if (sortedEmployees[j].getSalary() < sortedEmployees[j + 1].getSalary()) {
                    Employees temp = sortedEmployees[j];
                    sortedEmployees[j] = sortedEmployees[j + 1];
                    sortedEmployees[j + 1] = temp;
                }
            }
        }

        return sortedEmployees;

    }

    public Employees[] calculateDepartmentWiseBonus(Employees[] employees) {
        for (Employees employee : employees) {
            switch (employee.getDepartment()) {
                case "IT":
                    if (employee.getPerformanceRating() >= 4) {
                        double bonus = (employee.getSalary() * 15) / 100;
                        employee.setSalary(employee.getSalary() + bonus);
                    } else {
                        double bonus = (employee.getSalary() * 10) / 100;
                        employee.setSalary(employee.getSalary() + bonus);
                    }
                    break;
                case "HR":
                    if (employee.getPerformanceRating() >= 3) {
                        double bonus = (employee.getSalary() * 12) / 100;
                        employee.setSalary(employee.getSalary() + bonus);
                    } else {
                        double bonus = (employee.getSalary() * 8) / 100;
                        employee.setSalary(employee.getSalary() + bonus);
                    }
                    break;
                case "Finance":
                    if (employee.getPerformanceRating() >= 4) {
                        double bonus = (employee.getSalary() * 18) / 100;
                        employee.setSalary(employee.getSalary() + bonus);
                    } else {
                        double bonus = (employee.getSalary() * 12) / 100;
                        employee.setSalary(employee.getSalary() + bonus);
                    }
                    break;
                default:
                    if (employee.getPerformanceRating() >= 3) {
                        double bonus = (employee.getSalary() * 10) / 100;
                        employee.setSalary(employee.getSalary() + bonus);
                    } else {
                        double bonus = (employee.getSalary() * 5) / 100;
                        employee.setSalary(employee.getSalary() + bonus);
                    }

            }
        }
        return employees;
    }

    public Employees[] findSeniorEmployees(Employees[] employees, String currentDate) {
        List<Employees> seniorList = new ArrayList<>();

        LocalDate current = LocalDate.parse(currentDate);
        for (Employees emp : employees) {
            LocalDate joined = LocalDate.parse(emp.getJoiningDate());
            Period diff = Period.between(joined, current);
            if (diff.getYears() > 5) {
                seniorList.add(emp);
            }
        }
        return seniorList.toArray(new Employees[0]);
    }

}
