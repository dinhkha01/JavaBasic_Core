package bt6;

class ManagerRole implements IRole, IManagementCapability {
    @Override
    public String getRoleName() {
        return "Quản lý";
    }

    @Override
    public void performRoleTasks() {
        manageTeam();
    }

    @Override
    public void manageTeam() {
        System.out.println("Đang quản lý nhóm, phân công công việc...");
    }
}