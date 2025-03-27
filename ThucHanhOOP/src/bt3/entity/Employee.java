package bt3.entity;

import bt3.validate.ValidateEmployee;

import java.util.Scanner;

public class Employee implements IEmployee {
    private String id;
    private String name;
    private int year;
    private float rate;
    private float commission;
    private float salary;
    private boolean status;

    public Employee() {
    }

    public Employee(String id, String name, int year, float rate, boolean status, float commission) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rate = rate;
        this.commission = commission;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public float calculateSalary(){
        return this.salary = rate * BASIC_SALARY + commission;
    }

    @Override
    public void inputData(Scanner sc) {
        this.id = ValidateEmployee.validateId(sc);
        this.name = ValidateEmployee.validateName(sc);
        this.year = ValidateEmployee.validateYear(sc);
        this.rate = ValidateEmployee.validateRate(sc);
        this.commission = ValidateEmployee.validateCommission(sc);
        this.status = ValidateEmployee.validateStatus(sc);

    }

    @Override
    public void displayData() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Year: " + year);
        System.out.println("Rate: " + rate);
        System.out.println("Commission: " + commission);
        System.out.println("Salary: " + salary);
        System.out.println("Status: " + status);
    }
}
