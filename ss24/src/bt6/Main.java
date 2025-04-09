package bt6;

public class Main {
    public static void main(String[] args) {
        // Tạo các vai trò
        IRole managerRole = new ManagerRole();
        IRole salesRole = new SalesRole();
        IRole technicianRole = new TechnicianRole();

        // Tạo nhân viên và gán vai trò
        Employee emp1 = new Employee("E001", "Nguyễn Văn A");
        emp1.addRole(managerRole);
        emp1.addRole(salesRole);

        Employee emp2 = new Employee("E002", "Trần Thị B");
        emp2.addRole(salesRole);
        emp2.addRole(technicianRole);

        Employee emp3 = new Employee("E003", "Lê Văn C");
        emp3.addRole(technicianRole);

        // Thực hiện các vai trò
        emp1.performAllRoles();
        emp2.performAllRoles();
        emp3.performAllRoles();

        // Kiểm tra khả năng đặc biệt
        System.out.println("\nKiểm tra khả năng quản lý:");
        emp1.manageTeamIfCapable();
        emp2.manageTeamIfCapable();
        emp3.manageTeamIfCapable();

        // Thêm vai trò mới (mở rộng mà không cần sửa code cũ)
        System.out.println("\nThêm vai trò mới:");
        emp3.addRole(managerRole);
        emp3.performAllRoles();
        emp3.manageTeamIfCapable();
    }
}