package bt1.business.dao.Book;

import bt1.config.ConnectionDB;
import bt1.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookBusiness implements IBookDao {
    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        Connection connection = null;
        CallableStatement callSt = null;
        ResultSet rs = null;

        try {
            connection = ConnectionDB.openConnection();
            callSt = connection.prepareCall("{call get_all_books()}");
            rs = callSt.executeQuery();

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setBookName(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setContent(rs.getString("content"));
                book.setTotalPages(rs.getInt("total_pages"));
                book.setPublisher(rs.getString("publisher"));
                book.setPrice(rs.getDouble("price"));
                book.setTypeId(rs.getInt("type_id"));
                book.setDeleted(rs.getBoolean("is_deleted"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
            try {
                if (callSt != null) callSt.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    @Override
    public Book findById(Integer id) {
        Connection connection = null;
        CallableStatement callSt = null;
        ResultSet rs = null;

        try {
            connection = ConnectionDB.openConnection();
            callSt = connection.prepareCall("{call get_book_by_id(?)}");
            callSt.setInt(1, id);
            rs = callSt.executeQuery();

            if (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setBookName(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setContent(rs.getString("content"));
                book.setTotalPages(rs.getInt("total_pages"));
                book.setPublisher(rs.getString("publisher"));
                book.setPrice(rs.getDouble("price"));
                book.setTypeId(rs.getInt("type_id"));
                book.setDeleted(rs.getBoolean("is_deleted"));
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
            try {
                if (callSt != null) callSt.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void save(Book book) {
        Connection connection = null;
        CallableStatement callSt = null;

        try {
            connection = ConnectionDB.openConnection();
            if (book.getId() == 0) {
                // Insert new book
                callSt = connection.prepareCall("{call insert_book(?, ?, ?, ?, ?, ?, ?, ?)}");
                callSt.setString(1, book.getBookName());
                callSt.setString(2, book.getAuthor());
                callSt.setString(3, book.getContent());
                callSt.setInt(4, book.getTotalPages());
                callSt.setString(5, book.getPublisher());
                callSt.setDouble(6, book.getPrice());
                callSt.setInt(7, book.getTypeId());
                callSt.setBoolean(8, book.isDeleted());
            } else {
                // Update existing book
                callSt = connection.prepareCall("{call update_book(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                callSt.setInt(1, book.getId());
                callSt.setString(2, book.getBookName());
                callSt.setString(3, book.getAuthor());
                callSt.setString(4, book.getContent());
                callSt.setInt(5, book.getTotalPages());
                callSt.setString(6, book.getPublisher());
                callSt.setDouble(7, book.getPrice());
                callSt.setInt(8, book.getTypeId());
                callSt.setBoolean(9, book.isDeleted());
            }
            callSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
            try {
                if (callSt != null) callSt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteById(Integer id) {
        Connection connection = null;
        CallableStatement callSt = null;

        try {
            connection = ConnectionDB.openConnection();
            callSt = connection.prepareCall("{call delete_book(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
            try {
                if (callSt != null) callSt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Book> findAllOrderByPriceDesc() {
        List<Book> books = new ArrayList<>();
        Connection connection = null;
        CallableStatement callSt = null;
        ResultSet rs = null;

        try {
            connection = ConnectionDB.openConnection();
            callSt = connection.prepareCall("{call get_books_order_by_price_desc()}");
            rs = callSt.executeQuery();

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setBookName(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setContent(rs.getString("content"));
                book.setTotalPages(rs.getInt("total_pages"));
                book.setPublisher(rs.getString("publisher"));
                book.setPrice(rs.getDouble("price"));
                book.setTypeId(rs.getInt("type_id"));
                book.setDeleted(rs.getBoolean("is_deleted"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
            try {
                if (callSt != null) callSt.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    public List<Book> searchByNameOrContent(String keyword) {
        List<Book> books = new ArrayList<>();
        Connection connection = null;
        CallableStatement callSt = null;
        ResultSet rs = null;

        try {
            connection = ConnectionDB.openConnection();
            callSt = connection.prepareCall("{call search_books_by_name_or_content(?)}");
            callSt.setString(1, keyword);
            rs = callSt.executeQuery();

            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setBookName(rs.getString("book_name"));
                book.setAuthor(rs.getString("author"));
                book.setContent(rs.getString("content"));
                book.setTotalPages(rs.getInt("total_pages"));
                book.setPublisher(rs.getString("publisher"));
                book.setPrice(rs.getDouble("price"));
                book.setTypeId(rs.getInt("type_id"));
                book.setDeleted(rs.getBoolean("is_deleted"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
            try {
                if (callSt != null) callSt.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return books;
    }

    public List<Object[]> countBooksByType() {
        List<Object[]> results = new ArrayList<>();
        Connection connection = null;
        CallableStatement callSt = null;
        ResultSet rs = null;

        try {
            connection = ConnectionDB.openConnection();
            callSt = connection.prepareCall("{call count_books_group_by_type()}");
            rs = callSt.executeQuery();

            while (rs.next()) {
                Object[] row = new Object[2];
                row[0] = rs.getInt("type_id");
                row[1] = rs.getInt("book_count");
                results.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
            try {
                if (callSt != null) callSt.close();
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}