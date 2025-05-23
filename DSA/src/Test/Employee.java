package DSA.src.Test;

import java.util.*;
import java.util.stream.Collectors;


public class Employee {
    private String name;
    private String department;
    private int age;
    private double salary;

    public Employee(String name, String department, int age, double salary) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("Employee{name='%s', department='%s', age=%d, salary=%.2f}", name, department, age, salary);
    }

    public static List<Employee> filterByDepartment(List<Employee> employees, String department) {
        List departBasedList = employees.stream().filter(emp -> department.equals(emp.department)).collect(Collectors.toList());
        return departBasedList;
    }

    // Method to group employees by department
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String,List<Employee>> filteredResult =    employees.stream().collect(Collectors.groupingBy(emp -> emp.department));
        return filteredResult;
    }

    // Method to calculate average salary by department
    public static Map<String, Double> averageSalaryByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> deptWiseList = employees.stream().collect(Collectors.groupingBy(emp->emp.department));
        return employees.stream().collect(Collectors.groupingBy(Employee::getName,Collectors.averagingDouble(Employee::getSalary)));

    }

    // Method to find the highest paid employee in each department
    public static Map<String, Optional<Employee>> highestPaidEmployeeByDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
    }

    // Method to count employees in each department
    public static Map<String, Long> countEmployeesByDepartment(List<Employee> employees) {
        Map<String, Long> countDepartmentBase = employees.stream().collect(Collectors.groupingBy(emp -> emp.department,Collectors.counting()));
        return countDepartmentBase;
    }

    // Method to partition employees by salary threshold
    public static Map<Boolean, List<Employee>> partitionBySalaryThreshold(List<Employee> employees, double threshold) {
        Map<Boolean, List<Employee>> thresholdBasedSalary = employees.stream().collect(Collectors.partitioningBy(emp -> emp.salary>threshold));
        return thresholdBasedSalary;
    }


}