package bt5;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    // Thêm sản phẩm vào danh sách
    public void addProduct(Product product) {
        products.add(product);
    }

    // Hiển thị tất cả sản phẩm
    public void displayAllProducts() {
        System.out.println("\nDANH SÁCH SẢN PHẨM");
        System.out.println("==================");
        for (Product product : products) {
            product.display();
        }
    }


}
