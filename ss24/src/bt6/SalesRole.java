package bt6;

class SalesRole implements IRole, ISalesCapability {
    @Override
    public String getRoleName() {
        return "Bán hàng";
    }

    @Override
    public void performRoleTasks() {
        makeSale();
    }

    @Override
    public void makeSale() {
        System.out.println("Đang tư vấn khách hàng, bán sản phẩm...");
    }
}