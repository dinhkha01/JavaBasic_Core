package bt6;

import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

public class Invoice {
    private List<Product> products;
    private static final double TAX_RATE = 0.1;

    public Invoice() {
        this.products = new ArrayList<>();
        initializeProducts();
    }

    private void initializeProducts() {
        products.add(new Product("Product 1", 100));
        products.add(new Product("Product 2", 200));
        products.add(new Product("Product 3", 300));
    }

    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        invoice.displayInvoice();
    }

    public void displayInvoice() {
        displayHeader();
        displayProducts();
        displayTotals();
    }

    private void displayHeader() {
        System.out.println("=================================");
        System.out.printf("%-15s %10s\n", "Name", "Price");
        System.out.println("---------------------------------");
    }

    private void displayProducts() {
        for (Product product : products) {
            System.out.printf("%-15s %10.2f\n", product.getName(), product.getPrice());
        }
    }

    private void displayTotals() {
        double subtotal = calculateSubtotal();
        double tax = calculateTax(subtotal);
        double total = calculateTotal(subtotal, tax);

        System.out.println("---------------------------------");
        System.out.printf("%-15s %10.2f\n", "Subtotal:", subtotal);
        System.out.printf("%-15s %10.2f\n", "Tax (" + (TAX_RATE * 100) + "%):", tax);
        System.out.printf("%-15s %10.2f\n", "Total:", total);
        System.out.println("=================================");
    }

    private double calculateSubtotal() {
        double subtotal = 0;
        for (Product product : products) {
            subtotal += product.getPrice();
        }
        return subtotal;
    }

    private double calculateTax(double subtotal) {
        return subtotal * TAX_RATE;
    }

    private double calculateTotal(double subtotal, double tax) {
        return subtotal + tax;
    }
}