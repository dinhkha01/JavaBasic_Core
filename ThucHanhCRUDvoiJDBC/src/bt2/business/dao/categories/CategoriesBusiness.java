package bt2.business.dao.categories;

import bt2.config.ConnectionDB;
import bt2.entity.Categories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesBusiness implements ICategoriesDao {

    @Override
    public List<Categories> findAllSortedByName() {
        List<Categories> categories = new ArrayList<>();
        String sql = "{CALL sp_findAllCategoriesSortedByName()}";
        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement cstmt = conn.prepareCall(sql);
             ResultSet rs = cstmt.executeQuery()) {
            while (rs.next()) {
                Categories category = new Categories(
                        rs.getInt("category_id"),
                        rs.getString("category_name"),
                        rs.getBoolean("category_status")
                );
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public List<Categories> searchByName(String keyword) {
        List<Categories> categories = new ArrayList<>();
        String sql = "{CALL sp_searchCategoriesByName(?)}";
        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setString(1, keyword);
            try (ResultSet rs = cstmt.executeQuery()) {
                while (rs.next()) {
                    Categories category = new Categories(
                            rs.getInt("category_id"),
                            rs.getString("category_name"),
                            rs.getBoolean("category_status")
                    );
                    categories.add(category);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public void updateStatus(Integer id, boolean status) {
        String sql = "{CALL sp_updateCategoryStatus(?, ?)}";
        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, id);
            cstmt.setBoolean(2, status);
            cstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasProducts(Integer categoryId) {
        String sql = "{CALL sp_hasProducts(?, ?)}";
        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, categoryId);
            cstmt.registerOutParameter(2, Types.BOOLEAN);
            cstmt.execute();
            return cstmt.getBoolean(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Object[]> countByStatus() {
        List<Object[]> results = new ArrayList<>();
        String sql = "{CALL sp_countCategoriesByStatus()}";
        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement cstmt = conn.prepareCall(sql);
             ResultSet rs = cstmt.executeQuery()) {
            while (rs.next()) {
                Object[] row = {rs.getBoolean(1), rs.getInt(2)};
                results.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public List<Categories> findAll() {
        List<Categories> categories = new ArrayList<>();
        String sql = "{CALL sp_findAllCategories()}";
        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement cstmt = conn.prepareCall(sql);
             ResultSet rs = cstmt.executeQuery()) {
            while (rs.next()) {
                Categories category = new Categories(
                        rs.getInt("category_id"),
                        rs.getString("category_name"),
                        rs.getBoolean("category_status")
                );
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Categories findById(Integer id) {
        String sql = "{CALL sp_findCategoryById(?)}";
        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, id);
            try (ResultSet rs = cstmt.executeQuery()) {
                if (rs.next()) {
                    return new Categories(
                            rs.getInt("category_id"),
                            rs.getString("category_name"),
                            rs.getBoolean("category_status")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Categories category) {
        if (category.getCategoryId() == 0) {
            String sql = "{CALL sp_insertCategory(?, ?)}";
            try (Connection conn = ConnectionDB.openConnection();
                 CallableStatement cstmt = conn.prepareCall(sql)) {
                cstmt.setString(1, category.getCategoryName());
                cstmt.setBoolean(2, category.isCategoryStatus());
                cstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String sql = "{CALL sp_updateCategory(?, ?, ?)}";
            try (Connection conn = ConnectionDB.openConnection();
                 CallableStatement cstmt = conn.prepareCall(sql)) {
                cstmt.setInt(1, category.getCategoryId());
                cstmt.setString(2, category.getCategoryName());
                cstmt.setBoolean(3, category.isCategoryStatus());
                cstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (hasProducts(id)) {
            System.out.println("Không thể xóa danh mục đã có sản phẩm!");
            return;
        }
        String sql = "{CALL sp_deleteCategory(?)}";
        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, id);
            cstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}