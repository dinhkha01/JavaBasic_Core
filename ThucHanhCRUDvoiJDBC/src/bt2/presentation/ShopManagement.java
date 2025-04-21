package bt2.presentation;

import bt2.business.service.CategoriesService;
import bt2.business.service.ProductsService;
import bt2.business.service.ReportService;

import java.util.Scanner;

public class ShopManagement {
    private final Scanner scanner;
    private final CategoriesService categoriesService;
    private final ProductsService productsService;
    private final ReportService reportService;

    public ShopManagement() {
        this.scanner = new Scanner(System.in);
        this.categoriesService = new CategoriesService();
        this.productsService = new ProductsService();
        this.reportService = new ReportService();
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            displayMainMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    categoriesManagement();
                    break;
                case 2:
                    productsManagement();
                    break;
                case 3:
                    reportManagement();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using Shop Management System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\n******************* SHOP MANAGEMENT *******************");
        System.out.println("1. Quản lý danh mục");
        System.out.println("2. Quản lý sản phẩm");
        System.out.println("3. Báo cáo thống kê");
        System.out.println("4. Thoát");
        System.out.println("*****************************************************");
        System.out.print("Enter your choice: ");
    }

    private void categoriesManagement() {
        boolean back = false;
        while (!back) {
            displayCategoriesMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    categoriesService.displayAllCategories();
                    break;
                case 2:
                    categoriesService.displayCategoriesSortedByName();
                    break;
                case 3:
                    categoriesService.addCategory(scanner);
                    break;
                case 4:
                    categoriesService.updateCategory(scanner);
                    break;
                case 5:
                    categoriesService.deleteCategory(scanner);
                    break;
                case 6:
                    categoriesService.searchCategoriesByName(scanner);
                    break;
                case 7:
                    categoriesService.updateCategoryStatus(scanner);
                    break;
                case 8:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            if (!back) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
    }

    private void displayCategoriesMenu() {
        System.out.println("\n**************** CATEGORIES MANAGEMENT ****************");
        System.out.println("1. Hiển thị các danh mục");
        System.out.println("2. Hiển thị danh mục sắp xếp theo tên tăng dần");
        System.out.println("3. Thêm mới danh mục");
        System.out.println("4. Cập nhật danh mục");
        System.out.println("5. Xóa danh mục");
        System.out.println("6. Tìm kiếm danh mục theo tên");
        System.out.println("7. Cập nhật trạng thái danh mục");
        System.out.println("8. Thoát");
        System.out.println("*****************************************************");
        System.out.print("Enter your choice: ");
    }

    private void productsManagement() {
        boolean back = false;
        while (!back) {
            displayProductsMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    productsService.displayAllProducts();
                    break;
                case 2:
                    productsService.displayProductsSortedByPriceDesc();
                    break;
                case 3:
                    productsService.addProduct(scanner);
                    break;
                case 4:
                    productsService.updateProduct(scanner);
                    break;
                case 5:
                    productsService.updateProductStatus(scanner);
                    break;
                case 6:
                    productsService.deleteProduct(scanner);
                    break;
                case 7:
                    productsService.searchProductsByName(scanner);
                    break;
                case 8:
                    productsService.searchProductsByPriceRange(scanner);
                    break;
                case 9:
                    productsService.sellProduct(scanner);
                    break;
                case 10:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            if (!back) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
    }

    private void displayProductsMenu() {
        System.out.println("\n****************** PRODUCT MANAGEMENT ******************");
        System.out.println("1. Hiển thị sản phẩm");
        System.out.println("2. Hiển thị sản phẩm theo giá giảm dần");
        System.out.println("3. Thêm mới sản phẩm");
        System.out.println("4. Cập nhật sản phẩm");
        System.out.println("5. Cập nhật trạng thái sản phẩm");
        System.out.println("6. Xóa sản phẩm");
        System.out.println("7. Tìm kiếm sản phẩm theo tên sản phẩm");
        System.out.println("8. Tìm kiếm sản phẩm trong khoảng giá a-b");
        System.out.println("9. Bán sản phẩm");
        System.out.println("10. Thoát");
        System.out.println("*****************************************************");
        System.out.print("Enter your choice: ");
    }

    private void reportManagement() {
        boolean back = false;
        while (!back) {
            displayReportMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    reportService.countCategoriesByStatus();
                    break;
                case 2:
                    reportService.countProductsByStatus();
                    break;
                case 3:
                    reportService.countProductsByCategory();
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            if (!back) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
    }

    private void displayReportMenu() {
        System.out.println("\n****************** REPORT MANAGEMENT ******************");
        System.out.println("1. Thống kê số danh mục theo trạng thái danh mục");
        System.out.println("2. Thống kê số lượng sản phẩm theo trạng thái sản phẩm");
        System.out.println("3. Thống kê số lượng sản phẩm theo từng danh mục");
        System.out.println("4. Thoát");
        System.out.println("*****************************************************");
        System.out.print("Enter your choice: ");
    }

    private int getChoice() {
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            choice = -1;
        }
        return choice;
    }

    public static void main(String[] args) {
        ShopManagement shopManagement = new ShopManagement();
        shopManagement.start();
    }
}