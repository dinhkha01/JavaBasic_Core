package bt5;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    private static ArrayList<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void displayMainMenu() {
        while (true) {
            System.out.println("\n=== Product Management System ===");
            System.out.println("1. Add Product");
            System.out.println("2. Show All Products");
            System.out.println("3. Find Product");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    displayAllProducts();
                    break;
                case 3:
                    findProduct();
                    break;
                case 4:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        products.add(new Product(name, price));
        System.out.println("Product added successfully!");
    }

    private static void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\n=== All Products ===");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void findProduct() {
        System.out.print("Enter product name to search: ");
        String searchName = scanner.nextLine();

        boolean found = false;
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Product found: " + product);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }
    }
}
