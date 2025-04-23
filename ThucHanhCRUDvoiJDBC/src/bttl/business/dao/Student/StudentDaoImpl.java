package bttl.business.dao.Student;

import bttl.entity.Students;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements IStudent {
    private Connection connection;

    public StudentDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Students> findAll() {
        List<Students> studentsList = new ArrayList<>();

        try (CallableStatement callStmt = connection.prepareCall("{CALL sp_getAllStudents()}");
             ResultSet resultSet = callStmt.executeQuery()) {

            while (resultSet.next()) {
                Students student = extractStudentFromResultSet(resultSet);
                studentsList.add(student);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving students: " + e.getMessage());
        }

        return studentsList;
    }

    @Override
    public Students findById(String id) {
        try (CallableStatement callStmt = connection.prepareCall("{CALL sp_getStudentById(?)}")) {
            callStmt.setString(1, id);

            try (ResultSet resultSet = callStmt.executeQuery()) {
                if (resultSet.next()) {
                    return extractStudentFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving student by ID: " + e.getMessage());
        }

        return null;
    }

    @Override
    public void save(Students student) {
        try {
            if (findById(student.getId()) != null) {
                // Update existing student
                CallableStatement callStmt = connection.prepareCall(
                        "{CALL sp_updateStudent(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                callStmt.setString(1, student.getId());
                callStmt.setString(2, student.getName());
                callStmt.setString(3, student.getEmail());
                callStmt.setString(4, student.getPhone());
                callStmt.setBoolean(5, student.isSex());
                callStmt.setDate(6, new java.sql.Date(student.getBod().getTime()));
                callStmt.setInt(7, student.getCourseId());
                callStmt.setString(8, student.getAvatar());
                callStmt.setBoolean(9, student.isStatus());
                callStmt.executeUpdate();
            } else {
                // Insert new student
                CallableStatement callStmt = connection.prepareCall(
                        "{CALL sp_addStudent(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
                callStmt.setString(1, student.getId());
                callStmt.setString(2, student.getName());
                callStmt.setString(3, student.getEmail());
                callStmt.setString(4, student.getPhone());
                callStmt.setBoolean(5, student.isSex());
                callStmt.setDate(6, new java.sql.Date(student.getBod().getTime()));
                callStmt.setInt(7, student.getCourseId());
                callStmt.setString(8, student.getAvatar());
                callStmt.setBoolean(9, student.isStatus());
                callStmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error saving student: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteById(String id) {
        try (CallableStatement callStmt = connection.prepareCall("{CALL sp_deleteStudent(?)}")) {
            callStmt.setString(1, id);
            callStmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error deleting student: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Students> searchByName(String name) {
        List<Students> studentsList = new ArrayList<>();

        try (CallableStatement callStmt = connection.prepareCall("{CALL sp_searchStudentsByName(?)}")) {
            callStmt.setString(1, name);

            try (ResultSet resultSet = callStmt.executeQuery()) {
                while (resultSet.next()) {
                    Students student = extractStudentFromResultSet(resultSet);
                    studentsList.add(student);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error searching students by name: " + e.getMessage());
        }

        return studentsList;
    }

    @Override
    public boolean isEmailUnique(String email) {
        String sql = "SELECT COUNT(*) FROM Student WHERE email = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) == 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error checking email uniqueness: " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean isPhoneUnique(String phone) {
        String sql = "SELECT COUNT(*) FROM Student WHERE phone = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, phone);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) == 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error checking phone uniqueness: " + e.getMessage());
        }

        return false;
    }

    private Students extractStudentFromResultSet(ResultSet resultSet) throws SQLException {
        Students student = new Students();
        student.setId(resultSet.getString("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setPhone(resultSet.getString("phone"));
        student.setSex(resultSet.getBoolean("sex"));
        student.setBod(resultSet.getDate("bod"));
        student.setCourseId(resultSet.getInt("course_id"));
        student.setAvatar(resultSet.getString("avatar"));
        student.setStatus(resultSet.getBoolean("status"));
        return student;
    }
}