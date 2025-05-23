package DSA.src.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        String name= "hey this is first java program";
       Map m = Arrays.asList(name.split("")).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

       List employee = new ArrayList();
       Employee e = new Employee("umesh","IT",25,15000);
       Employee e1 = new Employee("Sagar","HR",20,10000);
        Employee e2 = new Employee("Mahesh","TECH",18,9000);
       Employee e3 = new Employee("Ganesh","IT",22,18000);
       employee.add(e);
       employee.add(e1);
       employee.add(e2);
       employee.add(e3);

       System.out.println(Employee.averageSalaryByDepartment(employee));
        System.out.println(Employee.countEmployeesByDepartment(employee));
        System.out.println(Employee.filterByDepartment(employee,"IT"));



    }


}