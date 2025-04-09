package bt6;

import java.util.ArrayList;
import java.util.List;

class Employee {
    private String id;
    private String name;
    private List<IRole> roles;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
        this.roles = new ArrayList<>();
    }

    public void addRole(IRole role) {
        roles.add(role);
        System.out.println(name + " đã được thêm vai trò: " + role.getRoleName());
    }

    public void performAllRoles() {
        System.out.println("\n" + name + " đang thực hiện các vai trò:");
        for (IRole role : roles) {
            System.out.print("- " + role.getRoleName() + ": ");
            role.performRoleTasks();
        }
    }

    // Kiểm tra nếu nhân viên có vai trò cụ thể
    public <T extends IRole> boolean hasRole(Class<T> roleType) {
        for (IRole role : roles) {
            if (roleType.isInstance(role)) {
                return true;
            }
        }
        return false;
    }

    // Thực hiện các khả năng đặc biệt nếu có
    public void manageTeamIfCapable() {
        for (IRole role : roles) {
            if (role instanceof IManagementCapability) {
                ((IManagementCapability) role).manageTeam();
                return;
            }
        }
        System.out.println(name + " không có khả năng quản lý");
    }

    // Getter methods
    public String getId() { return id; }
    public String getName() { return name; }
    public List<IRole> getRoles() { return roles; }
}