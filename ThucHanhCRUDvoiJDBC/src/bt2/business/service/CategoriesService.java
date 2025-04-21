package bt2.business.service;

import bt2.business.dao.categories.CategoriesBusiness;
import bt2.business.dao.categories.ICategoriesDao;
import bt2.entity.Categories;

import java.util.List;
import java.util.Scanner;

public class CategoriesService {
    private final ICategoriesDao categoriesDao;

    public CategoriesService() {
        this.categoriesDao = new CategoriesBusiness();
    }

    // 1. Display all categories
    public void displayAllCategories() {
        List<Categories> categories = categoriesDao.findAll();
        if (categories.isEmpty()) {
            System.out.println("No categories found.");
            return;
        }
        System.out.println("--------- CATEGORIES LIST ---------");
        System.out.printf("%-5s | %-30s | %-10s\n", "ID", "NAME", "STATUS");
        System.out.println("-----------------------------------------");
        for (Categories category : categories) {
            System.out.printf("%-5d | %-30s | %-10s\n",
                    category.getCategoryId(),
                    category.getCategoryName(),
                    category.isCategoryStatus() ? "Active" : "Inactive");
        }
    }

    // 2. Display categories sorted by name
    public void displayCategoriesSortedByName() {
        List<Categories> categories = categoriesDao.findAllSortedByName();
        if (categories.isEmpty()) {
            System.out.println("No categories found.");
            return;
        }
        System.out.println("--------- CATEGORIES LIST (SORTED BY NAME) ---------");
        System.out.printf("%-5s | %-30s | %-10s\n", "ID", "NAME", "STATUS");
        System.out.println("---------------------------------------------------");
        for (Categories category : categories) {
            System.out.printf("%-5d | %-30s | %-10s\n",
                    category.getCategoryId(),
                    category.getCategoryName(),
                    category.isCategoryStatus() ? "Active" : "Inactive");
        }
    }

    // 3. Add new category
    public void addCategory(Scanner scanner) {
        System.out.println("--------- ADD NEW CATEGORY ---------");
        System.out.print("Enter category name: ");
        String name = scanner.nextLine();

        Categories newCategory = new Categories();
        newCategory.setCategoryName(name);
        newCategory.setCategoryStatus(true);

        categoriesDao.save(newCategory);
        System.out.println("Category added successfully!");
    }

    // 4. Update category
    public void updateCategory(Scanner scanner) {
        System.out.println("--------- UPDATE CATEGORY ---------");
        System.out.print("Enter category ID to update: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format!");
            return;
        }

        Categories existingCategory = categoriesDao.findById(id);
        if (existingCategory == null) {
            System.out.println("Category not found with ID: " + id);
            return;
        }

        System.out.println("Current category name: " + existingCategory.getCategoryName());
        System.out.print("Enter new category name (or press Enter to keep current): ");
        String newName = scanner.nextLine();

        if (!newName.isEmpty()) {
            existingCategory.setCategoryName(newName);
        }

        categoriesDao.save(existingCategory);
        System.out.println("Category updated successfully!");
    }

    // 5. Delete category
    public void deleteCategory(Scanner scanner) {
        System.out.println("--------- DELETE CATEGORY ---------");
        System.out.print("Enter category ID to delete: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format!");
            return;
        }

        Categories existingCategory = categoriesDao.findById(id);
        if (existingCategory == null) {
            System.out.println("Category not found with ID: " + id);
            return;
        }

        if (categoriesDao.hasProducts(id)) {
            System.out.println("Cannot delete category that has products!");
            return;
        }

        categoriesDao.deleteById(id);
        System.out.println("Category deleted successfully!");
    }

    // 6. Search categories by name
    public void searchCategoriesByName(Scanner scanner) {
        System.out.println("--------- SEARCH CATEGORIES ---------");
        System.out.print("Enter keyword to search: ");
        String keyword = scanner.nextLine();

        List<Categories> categories = categoriesDao.searchByName(keyword);
        if (categories.isEmpty()) {
            System.out.println("No categories found matching the keyword: " + keyword);
            return;
        }

        System.out.println("--------- SEARCH RESULTS ---------");
        System.out.printf("%-5s | %-30s | %-10s\n", "ID", "NAME", "STATUS");
        System.out.println("-----------------------------------------");
        for (Categories category : categories) {
            System.out.printf("%-5d | %-30s | %-10s\n",
                    category.getCategoryId(),
                    category.getCategoryName(),
                    category.isCategoryStatus() ? "Active" : "Inactive");
        }
    }

    // 7. Update category status
    public void updateCategoryStatus(Scanner scanner) {
        System.out.println("--------- UPDATE CATEGORY STATUS ---------");
        System.out.print("Enter category ID to update status: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format!");
            return;
        }

        Categories existingCategory = categoriesDao.findById(id);
        if (existingCategory == null) {
            System.out.println("Category not found with ID: " + id);
            return;
        }

        boolean currentStatus = existingCategory.isCategoryStatus();
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
        categoriesDao.updateStatus(id, newStatus);
        System.out.println("Category status updated successfully!");
    }
}