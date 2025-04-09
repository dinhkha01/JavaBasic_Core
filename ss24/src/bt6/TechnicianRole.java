package bt6;

class TechnicianRole implements IRole, ITechnicalCapability {
    @Override
    public String getRoleName() {
        return "Kỹ thuật";
    }

    @Override
    public void performRoleTasks() {
        performTechnicalTask();
    }

    @Override
    public void performTechnicalTask() {
        System.out.println("Đang sửa chữa, bảo trì thiết bị...");
    }
}