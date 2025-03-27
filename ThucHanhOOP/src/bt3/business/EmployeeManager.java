package bt3.business;

import bt3.entity.Employee;
import bt3.validate.InputMethod;
import bt3.validate.PrintColor;
import bt3.validate.ValidateEmployee;

import java.util.Arrays;
import java.util.Scanner;

public class EmployeeManager {
    public static Employee[] employees;
    public static int size;



    public EmployeeManager() {
        employees = new Employee[100];
        size = 0;
    }

    public void addEmployee(Scanner sc) {
        if (size >= employees.length) {
            PrintColor.error(" Chưa có thông tin của Employee nào cả");
            return;
        }
        Employee employee = new Employee();
        employee.inputData(sc);
        employees[size] = employee;
        size++;

    }

    public void showAllInfor() {
        if(size ==0) {
            PrintColor.error(" Chưa có thông tin của Employee nào cả");

            return;
        }
        System.out.println("Danh sách nhân viên");
        for (int i = 0; i < size; i++) {
            employees[i].displayData();
        }
    }

    public void calculateSalary() {
        if(size == 0) {
            PrintColor.error(" Chưa có thông tin của Employee nào cả");
            return;
        }
        for (int i = 0; i < size; i++) {
            employees[i].calculateSalary();
            System.out.println("Lương của nhân viên " + employees[i].getName() + " là: " + employees[i].getCommission());
            System.out.println("==========================");
        }
    }

    public void searchByName(String name) {
        Employee[] result = new Employee[size];
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getName() != null) {
                // Chuyển tên nhân viên và keyword về chữ thường để so sánh không phân biệt hoa/thường
                String employeeName = employee.getName().toLowerCase();
                // Kiểm tra tên nhân viên có CHỨA keyword hay không
                if (employeeName.contains(name.toLowerCase())) {
                    result[count] = employee;
                    count++;
                }
            }
        }
        showInfor(Arrays.copyOf(result, count)) ;
    }
    public void showInfor(Employee[] employees){
        if(employees.length ==0) return;
        System.out.println("Danh sách nhân viên tìm thấy");
        for (Employee employee : employees){
            employee.displayData();
        }
    }

    public void deleteEmployee(String id){
        if(size ==0) {
            PrintColor.error("Chưa có thông tin của Employee nào cả");
            return;
        }
        int index = findIndexById(id);
        if(index != -1){
            for(int i = index; i < size -1; i++){
                employees[i] = employees[i + 1];
            }
            size--;
        }
    }
    public  int findIndexById(String id){
        for(int i =0 ; i < size; i++){
            if(employees[i].getId().equals(id)) return i;
        }
        PrintColor.error("không tìm thấy ID: "+id);
        return -1;
    }
    public  Employee findById(String id){
        for(int i =0 ; i < size; i++){
            if(employees[i].getId().equals(id)) return employees[i];
        }

        return null;
    }

    public  void updateEmployee(Employee employee ){
        for(int i = 0 ; i < size; i++){
            if(employees[i].getId().equals(employee.getId())){
                employees[i] = employee;
                return;
            }
        }
    }
}
