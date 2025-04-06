package bt7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Employee {
    private String name;
    private int age;

    private String department;
    private double salary;

    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public void  show() {
        System.out.println("Name: " + name + ", Age: " + age + ", Department: " + department + ", Salary: " + salary);
        System.out.println("------------------------------------------------");
    }

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Quý", 26, "IT", 2500),

                new Employee("Lan", 24, "IT", 2100),

                new Employee("Minh", 30, "HR", 3000),

                new Employee("Huyền", 28, "IT", 2000),

                new Employee("Long", 32, "IT", 3100),

                new Employee("Trang", 25, "Marketing", 2200),

                new Employee("Việt", 24, "IT", 2500)

        );
        List<Employee> e = new ArrayList<>(employees);
        e.stream().filter(employee -> employee.salary > 2000 && employee.age > 25 && employee.department.equals("IT")).sorted(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getName)).forEach(Employee::show);

//        e.forEach(Employee::show);

    }
}
