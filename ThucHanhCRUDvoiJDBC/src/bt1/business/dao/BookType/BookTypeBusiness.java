package bt1.business.dao.BookType;

import bt1.config.ConnectionDB;
import bt1.entity.BookType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookTypeBusiness implements IBookTypeDao {
    @Override
    public List<BookType> findAll() {
        List<BookType> bookTypes = new ArrayList<>();
        Connection connection = null;
        CallableStatement callSt = null;
        ResultSet rs = null;

        try {
            connection = ConnectionDB.openConnection();
            callSt = connection.prepareCall("{call get_all_book_types()}");
            rs = callSt.executeQuery();

            while (rs.next()) {
                BookType bookType = new BookType();
                bookType.setId(rs.getInt("id"));
                bookType.setTypeName(rs.getString("type_name"));
                bookType.setDescription(rs.getString("description"));
                bookType.setDeleted(rs.getBoolean("is_deleted"));
                bookTypes.add(bookType);
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
        return bookTypes;
    }

    @Override
    public BookType findById(Integer id) {
        Connection connection = null;
        CallableStatement callSt = null;
        ResultSet rs = null;

        try {
            connection = ConnectionDB.openConnection();
            callSt = connection.prepareCall("{call get_book_type_by_id(?)}");
            callSt.setInt(1, id);
            rs = callSt.executeQuery();

            if (rs.next()) {
                BookType bookType = new BookType();
                bookType.setId(rs.getInt("id"));
                bookType.setTypeName(rs.getString("type_name"));
                bookType.setDescription(rs.getString("description"));
                bookType.setDeleted(rs.getBoolean("is_deleted"));
                return bookType;
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
    public void save(BookType bookType) {
        Connection connection = null;
        CallableStatement callSt = null;

        try {
            connection = ConnectionDB.openConnection();
            if (bookType.getId() == 0) {
                // Insert new book type
                callSt = connection.prepareCall("{call insert_book_type(?, ?, ?)}");
                callSt.setString(1, bookType.getTypeName());
                callSt.setString(2, bookType.getDescription());
                callSt.setBoolean(3, bookType.isDeleted());
            } else {
                // Update existing book type
                callSt = connection.prepareCall("{call update_book_type(?, ?, ?, ?)}");
                callSt.setInt(1, bookType.getId());
                callSt.setString(2, bookType.getTypeName());
                callSt.setString(3, bookType.getDescription());
                callSt.setBoolean(4, bookType.isDeleted());
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
            callSt = connection.prepareCall("{call delete_book_type(?)}");
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

    public int countBooksByTypeId(int typeId) {
        Connection connection = null;
        CallableStatement callSt = null;
        ResultSet rs = null;

        try {
            connection = ConnectionDB.openConnection();
            callSt = connection.prepareCall("{call count_books_by_type_id(?)}");
            callSt.setInt(1, typeId);
            rs = callSt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
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
        return 0;
    }
}