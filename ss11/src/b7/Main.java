package b7;

public class Main {
    public static void main(String[] args) {
        // Tạo các đối tượng nhân viên
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("TA", 100000, 4);
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("Hao", 120000);

        IEmployee[] employees = new IEmployee[2];
        employees[0] = partTimeEmployee;
        employees[1] = fullTimeEmployee;

        for (IEmployee employee : employees) {
            System.out.println(employee.getName() + " - Lương: " + employee.calculateSalary() + " VND");
        }
    }
}
