package bt6;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[6];
        employees[0] = new FullTimeEmployee("Nguyễn Văn A", 30, 1000, 2000000);
        employees[1] = new FullTimeEmployee("Trần Thị B", 28, 120000, 3000000);
        employees[2] = new PartTimeEmployee("Lê Văn C", 25, 80, 1200);
        employees[3] = new PartTimeEmployee("Phạm Thị D", 22, 90, 600);
        employees[4] = new Intern("Hoàng Văn E", 21, 5000000);
        employees[5] = new Intern("Ngô Thị F", 20, 4500000);


        System.out.println("===== THÔNG TIN CHI TIẾT NHÂN VIÊN =====\n");
        for(Employee e: employees){
            System.out.println(e.showInfo());
            System.out.println(e.calculateSalary());
        }
    }
}
