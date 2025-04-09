package bt5;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        // Thêm các sản phẩm
        manager.addProduct(new Electronics(1, "Laptop Dell XPS", "Dell"));
        manager.addProduct(new Clothing(2, "Áo thun nam", "XL"));
        manager.addProduct(new Electronics(3, "Điện thoại iPhone 13", "Apple"));
        manager.addProduct(new Clothing(4, "Quần jeans nữ", "M"));

        // Hiển thị tất cả sản phẩm
        manager.displayAllProducts();
    }
}
