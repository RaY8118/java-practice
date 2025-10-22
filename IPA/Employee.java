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

import java.util.Scanner;

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

  public static void main(String[] args) {
    Employee[] employees = new Employee[2];
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < employees.length; i++) {
      System.out.print("Enter emp name: ");
      String empName = sc.nextLine();
      System.out.print("Enter salary: ");
      int salary = sc.nextInt();
      System.out.print("Enter experience: ");
      int yearsOfExperience = sc.nextInt();
      sc.nextLine();

      employees[i] = new Employee(empName, salary, yearsOfExperience);
    }

    Employee[] employees2 = calculateBonus(employees);
    for (Employee employee : employees2) {
      System.out.println(employee);
    }

    sc.close();

  }
}
