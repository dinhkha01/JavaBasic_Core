package bt3.presentation;

import bt3.business.EmployeeManager;
import bt3.entity.Employee;
import bt3.validate.PrintColor;
import bt3.validate.ValidateEmployee;

import static bt3.business.EmployeeManager.*;
import java.util.Scanner;

public class EmployeeImp {
    static EmployeeManager employeeManager = new EmployeeManager();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            System.out.println("-----------Menu---------------");
            System.out.println("1. Nhập thông tin cho n nhân viên  (n nhập từ bàn phím) ");
            System.out.println("2. Hiển thị thông tin nhân viên");
            System.out.println("3. Tính lương cho các nhân viên ");
            System.out.println("4. Tìm kiếm nhân viên theo tên nhân viên ");
            System.out.println("5. Cập nhật thông tin nhân viên ");
            System.out.println("6. Xóa nhân viên theo mã nhân viên ");
            System.out.println("7. Exit");
            System.out.print("Moi ban chon: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    addEmployee();
                    break;
                case 2:
                  employeeManager.showAllInfor();
                    break;
                case 3:
                    employeeManager.calculateSalary();
                    break;
                case 4:
                    searchByName();
                    break;

                case 5:
                    updateEmployee();
                    break;
                case 6:
                    deleteEmployee();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Lua chon khong hop le");

            }
        }

    }
    public static void addEmployee(){
        System.out.println("Nhập số nhân viên muốn them vào mảng");
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0 ; i < n ; i++){
            employeeManager.addEmployee(sc);
        }
        System.out.println("Danh sach nhân viên đã thêm xong :");
    };
    public static void searchByName(){
        if(size == 0) {
            PrintColor.error("Chưa có thông tin của Employee nào cả");
            return;
        }
        System.out.println("Nhập tên nhân viên muốn tìm: ");
        String name = sc.nextLine();
        employeeManager.searchByName(name);
    }

    public static void updateEmployee(){
        if(size ==0) {
            PrintColor.error("Chưa có thông tin của Employee nào cả");
            return;
        }
        System.out.println("Nhập mã nhân viên muốn cập nhật: ");
        String id = sc.nextLine();
        Employee employee = employeeManager.findById(id);
        if(employee == null){
            PrintColor.error("Không tìm thấy nhân viên nào với ID: "+id);
            return;
        }
        System.out.println("Thông tin cũ :");
        employee.displayData();
        while(true){
            System.out.println("Nhập thông tin cập nhật cho nhân viên ID: "+id + "Tên Nhân viên: " + employee.getName());
            System.out.println("2. Tên");
            System.out.println("3. Năm sinh");
            System.out.println("4. hệ số lương nhân viên");
            System.out.println("5. hoa hồng");
            System.out.println("6. Trạng thái");
            System.out.println("7. Thoát");
            System.out.print("Chọn thông tin muốn cập nhật: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 2:
                    employee.setName(ValidateEmployee.validateName(sc));
                    break;
                case 3:
                    employee.setYear(ValidateEmployee.validateYear(sc));
                    break;
                case 4:
                    employee.setRate(ValidateEmployee.validateRate(sc));
                    break;
                case 5:
                    employee.setCommission(ValidateEmployee.validateCommission(sc));
                    break;
                case 6:
                    employee.setStatus(ValidateEmployee.validateStatus(sc));
                    break;
                case 7:
                    System.out.println("Thoát cập nhật thông tin nhân viên.");
                    employeeManager.updateEmployee(employee);
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại.");
            }
        }
    }
    public  static void deleteEmployee(){
        if(size ==0) {
            PrintColor.error("Chưa có thông tin của Employee nào cả");
            return;
        }
        System.out.println("Nhập mã nhân viên muốn xóa: ");
        String id = sc.nextLine();
        employeeManager.deleteEmployee(id);
    }

}
