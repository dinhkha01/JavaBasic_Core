package bt2.business.service;

import bt2.business.dao.categories.CategoriesBusiness;
import bt2.business.dao.categories.ICategoriesDao;
import bt2.config.ConnectionDB;
import bt2.entity.Categories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportService {
    private final ICategoriesDao categoriesDao;

    public ReportService() {
        this.categoriesDao = new CategoriesBusiness();
    }

    // 1. Count categories by status
    public void countCategoriesByStatus() {
        System.out.println("--------- CATEGORIES BY STATUS ---------");
        System.out.printf("%-15s | %-10s\n", "STATUS", "COUNT");
        System.out.println("--------------------------------------");

        List<Object[]> results = categoriesDao.countByStatus();
        for (Object[] row : results) {
            boolean status = (Boolean) row[0];
            int count = (Integer) row[1];
            System.out.printf("%-15s | %-10d\n",
                    status ? "Active" : "Inactive",
                    count);
        }
    }

    // 2. Count products by status
    public void countProductsByStatus() {
        System.out.println("--------- PRODUCTS BY STATUS ---------");
        System.out.printf("%-15s | %-10s\n", "STATUS", "COUNT");
        System.out.println("--------------------------------------");

        String sql = "SELECT product_status, COUNT(*) FROM Products GROUP BY product_status";
        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                boolean status = rs.getBoolean(1);
                int count = rs.getInt(2);
                System.out.printf("%-15s | %-10d\n",
                        status ? "Active" : "Inactive",
                        count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3. Count products by category
    public void countProductsByCategory() {
        System.out.println("--------- PRODUCTS BY CATEGORY ---------");
        System.out.printf("%-5s | %-30s | %-10s\n", "ID", "CATEGORY NAME", "PRODUCT COUNT");
        System.out.println("---------------------------------------------------");

        String sql = "SELECT c.category_id, c.category_name, COUNT(p.product_id) " +
                "FROM Categories c " +
                "LEFT JOIN Products p ON c.category_id = p.category_id " +
                "GROUP BY c.category_id, c.category_name " +
                "ORDER BY c.category_name";
        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                int categoryId = rs.getInt(1);
                String categoryName = rs.getString(2);
                int productCount = rs.getInt(3);
                System.out.printf("%-5d | %-30s | %-10d\n",
                        categoryId,
                        categoryName,
                        productCount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}