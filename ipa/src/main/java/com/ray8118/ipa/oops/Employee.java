// ### 🔷 **Problem 5 – Employee Bonus Calculation**
//
// Create `Employee` class with:
//
// * `empName` (String)
// * `salary` (int)
// * `yearsOfExperience` (int)
//
// Write:
//
// 1. A method `calculateBonus(Employee[] employees)` that increases salary by:
//
//    * 20% if experience > 5 years
//    * 10% otherwise
//
// Return an array of updated Employee objects.
// 2. A method `getEmployeesByExperience(Employee[] employees, int minExperience)` that returns an array of employees with experience greater than or equal to `minExperience`. Return an empty array if no such employees are found.

package com.ray8118.ipa.oops;

import java.util.ArrayList;
import java.util.List;

public class Employee {
  private String empName;
  private int salary;
  private int yearsOfExperience;
  private int bonus;

  public Employee(String empName, int salary, int yearsOfExperience) {
    this.empName = empName;
    this.salary = salary;
    this.yearsOfExperience = yearsOfExperience;
    this.bonus = 10;
  }

  public String getEmpName() {
    return empName;
  }

  public void setEmpName(String empName) {
    this.empName = empName;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public int getYearsOfExperience() {
    return yearsOfExperience;
  }

  public void setYearsOfExperience(int yearsOfExperience) {
    this.yearsOfExperience = yearsOfExperience;
  }

  public int getBonus() {
    return bonus;
  }

  public void setBonus(int bonus) {
    this.bonus = bonus;
  }

  @Override
  public String toString() {
    return "Employee [empName=" + empName + ", salary=" + salary + ", yearsOfExperience=" + yearsOfExperience + "]";
  }

  public static Employee[] calculateBonus(Employee[] employees) {
    int bonusSalary = 0;
    for (Employee employee : employees) {
      if (employee.getYearsOfExperience() > 5) {
        employee.setBonus(20);
        bonusSalary = (employee.getSalary() * employee.getBonus()) / 100;
        employee.setSalary(employee.getSalary() + bonusSalary);
      } else {
        bonusSalary = (employee.getSalary() * employee.getBonus()) / 100;
        employee.setSalary(employee.getSalary() + bonusSalary);
      }
    }

    return employees;
  }

  public static Employee[] getEmployeesByExperience(Employee[] employees, int minExperience) {
    List<Employee> employessByExperience = new ArrayList<>();
    for (Employee employee : employees) {
      if (employee.getYearsOfExperience() >= minExperience) {
        employessByExperience.add(employee);
      }
    }
    return employessByExperience.toArray(new Employee[0]);
  }

  public static void main(String[] args) {

  }
}
