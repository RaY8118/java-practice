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

import com.ray8118.ipa.TestHelper;

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
    Employee[] employees = {
        new Employee("Alice", 50000, 6),
        new Employee("Bob", 40000, 2),
        new Employee("Charlie", 60000, 8)
    };

    // 1️⃣ Test calculateBonus
    Employee[] updatedEmployees = Employee.calculateBonus(employees);

    TestHelper.assertEqual("Alice salary after 20% bonus", updatedEmployees[0].getSalary(), 60000);
    TestHelper.assertEqual("Bob salary after 10% bonus", updatedEmployees[1].getSalary(), 44000);
    TestHelper.assertEqual("Charlie salary after 20% bonus", updatedEmployees[2].getSalary(), 72000);

    // 2️⃣ Test getEmployeesByExperience
    Employee[] experiencedEmployees = Employee.getEmployeesByExperience(updatedEmployees, 5);

    TestHelper.assertEqual("Number of experienced employees >=5 years", experiencedEmployees.length, 2);
    TestHelper.assertEqual("First experienced employee is Alice", experiencedEmployees[0].getEmpName(), "Alice");
    TestHelper.assertEqual("Second experienced employee is Charlie", experiencedEmployees[1].getEmpName(), "Charlie");

    // 3️⃣ Edge case: empty array
    Employee[] emptyArray = {};
    Employee[] resultEmpty = Employee.calculateBonus(emptyArray);
    TestHelper.assertEqual("Empty array returns empty after calculateBonus", resultEmpty.length, 0);

    Employee[] resultNoExperience = Employee.getEmployeesByExperience(updatedEmployees, 20);
    TestHelper.assertEqual("No employee has >=20 years experience", resultNoExperience.length, 0);

    // 4️⃣ Additional test: all employees <=5 years
    Employee[] juniorEmployees = {
        new Employee("Dave", 30000, 1),
        new Employee("Eve", 35000, 3)
    };
    Employee.calculateBonus(juniorEmployees);
    for (Employee emp : juniorEmployees) {
      TestHelper.assertEqual(emp.getEmpName() + " salary after 10% bonus", emp.getSalary(),
          (int) (emp.getSalary() / 1.10 * 1.10));
    }
  }
}
