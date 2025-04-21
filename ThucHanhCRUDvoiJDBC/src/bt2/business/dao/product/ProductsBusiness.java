
package bt2.business.dao.product;

import bt2.config.ConnectionDB;
import bt2.entity.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsBusiness implements IProductsDao {

    @Override
    public List<Products> findAll() {
        List<Products> products = new ArrayList<>();
        String sql = "{CALL sp_findAllProducts()}";
        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement cstmt = conn.prepareCall(sql);
             ResultSet rs = cstmt.executeQuery()) {
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

    @Override
    public Products findById(Object id) {
        String sql = "{CALL sp_findProductById(?)}";
        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, (Integer) id);
            try (ResultSet rs = cstmt.executeQuery()) {
                if (rs.next()) {
                    return new Products(
                            rs.getInt("product_id"),
                            rs.getString("product_name"),
                            rs.getDouble("price"),
                            rs.getInt("quantity"),
                            rs.getInt("view"),
                            rs.getInt("category_id"),
                            rs.getBoolean("product_status"),
                            rs.getDate("created_at")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Object o) {
        Products product = (Products) o;
        if (product.getProductId() == 0) {
            String sql = "{CALL sp_insertProduct(?, ?, ?, ?, ?, ?, ?)}";
            try (Connection conn = ConnectionDB.openConnection();
                 CallableStatement cstmt = conn.prepareCall(sql)) {
                cstmt.setString(1, product.getProductName());
                cstmt.setDouble(2, product.getPrice());
                cstmt.setInt(3, product.getQuantity());
                cstmt.setInt(4, product.getView());
                cstmt.setInt(5, product.getCategoryId());
                cstmt.setBoolean(6, product.isProductStatus());
                cstmt.setDate(7, new java.sql.Date(product.getCreatedAt().getTime()));
                cstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String sql = "{CALL sp_updateProduct(?, ?, ?, ?, ?, ?, ?, ?)}";
            try (Connection conn = ConnectionDB.openConnection();
                 CallableStatement cstmt = conn.prepareCall(sql)) {
                cstmt.setInt(1, product.getProductId());
                cstmt.setString(2, product.getProductName());
                cstmt.setDouble(3, product.getPrice());
                cstmt.setInt(4, product.getQuantity());
                cstmt.setInt(5, product.getView());
                cstmt.setInt(6, product.getCategoryId());
                cstmt.setBoolean(7, product.isProductStatus());
                cstmt.setDate(8, new java.sql.Date(product.getCreatedAt().getTime()));
                cstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteById(Object id) {
        String sql = "{CALL sp_deleteProduct(?)}";
        try (Connection conn = ConnectionDB.openConnection();
             CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setInt(1, (Integer) id);
            cstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}