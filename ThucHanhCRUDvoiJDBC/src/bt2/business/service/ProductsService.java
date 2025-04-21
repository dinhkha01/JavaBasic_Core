package bt2.business.service;

import bt2.business.dao.product.IProductsDao;
import bt2.business.dao.product.ProductsBusiness;
import bt2.entity.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import bt2.config.ConnectionDB;

public class ProductsService {
    private final IProductsDao productsDao;

    public ProductsService() {
        this.productsDao = new ProductsBusiness();
    }

    // 1. Display all products
    public void displayAllProducts() {
        List<Products> products = productsDao.findAll();
        if (products.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        displayProductList(products, "PRODUCTS LIST");
    }

    // 2. Display products sorted by price (descending)
    public void displayProductsSortedByPriceDesc() {
        List<Products> products = findAllSortedByPriceDesc();
        if (products.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        displayProductList(products, "PRODUCTS LIST (SORTED BY PRICE DESC)");
    }

    private List<Products> findAllSortedByPriceDesc() {
        List<Products> products = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE product_status = 1 ORDER BY price DESC";
        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Products product = new Products(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getInt("view"),
                        rs.getInt("category_id"),
                        rs.getBoolean("product_status"),
                        rs.getDate("created_at")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    // Helper method to display product list
    private void displayProductList(List<Products> products, String title) {
        System.out.println("--------- " + title + " ---------");
        System.out.printf("%-5s | %-30s | %-10s | %-10s | %-10s | %-10s | %-10s\n",
                "ID", "NAME", "PRICE", "QUANTITY", "VIEWS", "CATEGORY", "CREATED");
        System.out.println("----------------------------------------------------------------------------------------");
        for (Products product : products) {
            System.out.printf("%-5d | %-30s | %-10.2f | %-10d | %-10d | %-10d | %-10s\n",
                    product.getProductId(),
                    product.getProductName(),
                    product.getPrice(),
                    product.getQuantity(),
                    product.getView(),
                    product.getCategoryId(),
                    product.getCreatedAt());
        }
    }

    // 3. Add new product
    public void addProduct(Scanner scanner) {
        System.out.println("--------- ADD NEW PRODUCT ---------");

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter price: ");
        double price;
        try {
            price = Double.parseDouble(scanner.nextLine());
            if (price <= 0) {
                System.out.println("Price must be greater than 0!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid price format!");
            return;
        }

        System.out.print("Enter quantity: ");
        int quantity;
        try {
            quantity = Integer.parseInt(scanner.nextLine());
            if (quantity < 0) {
                System.out.println("Quantity cannot be negative!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity format!");
            return;
        }

        System.out.print("Enter category ID: ");
        int categoryId;
        try {
            categoryId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid category ID format!");
            return;
        }

        // Check if category exists
        if (!categoryExists(categoryId)) {
            System.out.println("Category ID does not exist!");
            return;
        }

        Products newProduct = new Products();
        newProduct.setProductName(name);
        newProduct.setPrice(price);
        newProduct.setQuantity(quantity);
        newProduct.setView(0);
        newProduct.setCategoryId(categoryId);
        newProduct.setProductStatus(true);
        newProduct.setCreatedAt(new Date());

        productsDao.save(newProduct);
        System.out.println("Product added successfully!");
    }

    // Helper method to check if category exists
    private boolean categoryExists(int categoryId) {
        String sql = "SELECT category_id FROM Categories WHERE category_id = ? AND category_status = 1";
        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, categoryId);
            try (ResultSet rs = pst.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 4. Update product
    public void updateProduct(Scanner scanner) {
        System.out.println("--------- UPDATE PRODUCT ---------");
        System.out.print("Enter product ID to update: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format!");
            return;
        }

        Products existingProduct = (Products) productsDao.findById(id);
        if (existingProduct == null) {
            System.out.println("Product not found with ID: " + id);
            return;
        }

        System.out.println("Current product details:");
        System.out.println("Name: " + existingProduct.getProductName());
        System.out.println("Price: " + existingProduct.getPrice());
        System.out.println("Quantity: " + existingProduct.getQuantity());
        System.out.println("Category ID: " + existingProduct.getCategoryId());

        System.out.print("Enter new product name (or press Enter to keep current): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            existingProduct.setProductName(newName);
        }

        System.out.print("Enter new price (or press Enter to keep current): ");
        String priceInput = scanner.nextLine();
        if (!priceInput.isEmpty()) {
            try {
                double newPrice = Double.parseDouble(priceInput);
                if (newPrice <= 0) {
                    System.out.println("Price must be greater than 0! Price not updated.");
                } else {
                    existingProduct.setPrice(newPrice);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid price format! Price not updated.");
            }
        }

        System.out.print("Enter new quantity (or press Enter to keep current): ");
        String quantityInput = scanner.nextLine();
        if (!quantityInput.isEmpty()) {
            try {
                int newQuantity = Integer.parseInt(quantityInput);
                if (newQuantity < 0) {
                    System.out.println("Quantity cannot be negative! Quantity not updated.");
                } else {
                    existingProduct.setQuantity(newQuantity);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity format! Quantity not updated.");
            }
        }

        System.out.print("Enter new category ID (or press Enter to keep current): ");
        String categoryInput = scanner.nextLine();
        if (!categoryInput.isEmpty()) {
            try {
                int newCategoryId = Integer.parseInt(categoryInput);
                if (!categoryExists(newCategoryId)) {
                    System.out.println("Category ID does not exist! Category not updated.");
                } else {
                    existingProduct.setCategoryId(newCategoryId);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid category ID format! Category not updated.");
            }
        }

        productsDao.save(existingProduct);
        System.out.println("Product updated successfully!");
    }

    // 5. Update product status
    public void updateProductStatus(Scanner scanner) {
        System.out.println("--------- UPDATE PRODUCT STATUS ---------");
        System.out.print("Enter product ID to update status: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format!");
            return;
        }

        Products existingProduct = (Products) productsDao.findById(id);
        if (existingProduct == null) {
            System.out.println("Product not found with ID: " + id);
            return;
        }

        boolean currentStatus = existingProduct.isProductStatus();
        System.out.println("Current status: " + (currentStatus ? "Active" : "Inactive"));
        System.out.print("Enter new status (1 for Active, 0 for Inactive): ");
        int statusInput;
        try {
            statusInput = Integer.parseInt(scanner.nextLine());
            if (statusInput != 0 && statusInput != 1) {
                System.out.println("Status must be 0 or 1!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid status format!");
            return;
        }

        boolean newStatus = statusInput == 1;
        existingProduct.setProductStatus(newStatus);
        productsDao.save(existingProduct);
        System.out.println("Product status updated successfully!");
    }

    // 6. Delete product
    public void deleteProduct(Scanner scanner) {
        System.out.println("--------- DELETE PRODUCT ---------");
        System.out.print("Enter product ID to delete: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format!");
            return;
        }

        Products existingProduct = (Products) productsDao.findById(id);
        if (existingProduct == null) {
            System.out.println("Product not found with ID: " + id);
            return;
        }

        productsDao.deleteById(id);
        System.out.println("Product deleted successfully!");
    }

    // 7. Search products by name
    public void searchProductsByName(Scanner scanner) {
        System.out.println("--------- SEARCH PRODUCTS BY NAME ---------");
        System.out.print("Enter keyword to search: ");
        String keyword = scanner.nextLine();

        List<Products> products = searchByName(keyword);
        if (products.isEmpty()) {
            System.out.println("No products found matching the keyword: " + keyword);
            return;
        }

        displayProductList(products, "SEARCH RESULTS");
    }

    private List<Products> searchByName(String keyword) {
        List<Products> products = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE product_name LIKE ? AND product_status = 1";
        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, "%" + keyword + "%");
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Products product = new Products(
                            rs.getInt("product_id"),
                            rs.getString("product_name"),
                            rs.getDouble("price"),
                            rs.getInt("quantity"),
                            rs.getInt("view"),
                            rs.getInt("category_id"),
                            rs.getBoolean("product_status"),
                            rs.getDate("created_at")
                    );
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    // 8. Search products by price range
    public void searchProductsByPriceRange(Scanner scanner) {
        System.out.println("--------- SEARCH PRODUCTS BY PRICE RANGE ---------");
        System.out.print("Enter minimum price: ");
        double minPrice;
        try {
            minPrice = Double.parseDouble(scanner.nextLine());
            if (minPrice < 0) {
                System.out.println("Minimum price cannot be negative!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid price format!");
            return;
        }

        System.out.print("Enter maximum price: ");
        double maxPrice;
        try {
            maxPrice = Double.parseDouble(scanner.nextLine());
            if (maxPrice < minPrice) {
                System.out.println("Maximum price must be greater than or equal to minimum price!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid price format!");
            return;
        }

        List<Products> products = searchByPriceRange(minPrice, maxPrice);
        if (products.isEmpty()) {
            System.out.println("No products found in the price range: " + minPrice + " - " + maxPrice);
            return;
        }

        displayProductList(products, "SEARCH RESULTS");
    }

    private List<Products> searchByPriceRange(double minPrice, double maxPrice) {
        List<Products> products = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE price BETWEEN ? AND ? AND product_status = 1";
        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setDouble(1, minPrice);
            pst.setDouble(2, maxPrice);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Products product = new Products(
                            rs.getInt("product_id"),
                            rs.getString("product_name"),
                            rs.getDouble("price"),
                            rs.getInt("quantity"),
                            rs.getInt("view"),
                            rs.getInt("category_id"),
                            rs.getBoolean("product_status"),
                            rs.getDate("created_at")
                    );
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    // 9. Sell product
    public void sellProduct(Scanner scanner) {
        System.out.println("--------- SELL PRODUCT ---------");
        System.out.print("Enter product ID to sell: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format!");
            return;
        }

        Products existingProduct = (Products) productsDao.findById(id);
        if (existingProduct == null) {
            System.out.println("Product not found with ID: " + id);
            return;
        }

        System.out.println("Product: " + existingProduct.getProductName());
        System.out.println("Current quantity: " + existingProduct.getQuantity());
        System.out.print("Enter quantity to sell: ");
        int sellQuantity;
        try {
            sellQuantity = Integer.parseInt(scanner.nextLine());
            if (sellQuantity <= 0) {
                System.out.println("Quantity to sell must be greater than 0!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity format!");
            return;
        }

        if (sellQuantity > existingProduct.getQuantity()) {
            System.out.println("Not enough stock! Available: " + existingProduct.getQuantity());
            return;
        }

        // Update quantity and view count
        existingProduct.setQuantity(existingProduct.getQuantity() - sellQuantity);
        existingProduct.setView(existingProduct.getView() + 1);
        productsDao.save(existingProduct);

        System.out.println("Product sold successfully!");
        System.out.println("Remaining quantity: " + existingProduct.getQuantity());
    }
}