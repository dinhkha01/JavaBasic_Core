package bttl.business.dao.Course;

import bttl.entity.Courses;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements ICourse {
    private Connection connection;

    public CourseDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Courses> findAll() {
        List<Courses> coursesList = new ArrayList<>();

        try (CallableStatement callStmt = connection.prepareCall("{CALL sp_getAllCourses()}");
             ResultSet resultSet = callStmt.executeQuery()) {

            while (resultSet.next()) {
                Courses course = new Courses();
                course.setId(resultSet.getInt("id"));
                course.setName(resultSet.getString("name"));
                course.setDescription(resultSet.getString("description"));
                coursesList.add(course);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving courses: " + e.getMessage());
        }

        return coursesList;
    }

    @Override
    public Courses findById(Integer id) {
        try (CallableStatement callStmt = connection.prepareCall("{CALL sp_getCourseById(?)}")) {
            callStmt.setInt(1, id);

            try (ResultSet resultSet = callStmt.executeQuery()) {
                if (resultSet.next()) {
                    Courses course = new Courses();
                    course.setId(resultSet.getInt("id"));
                    course.setName(resultSet.getString("name"));
                    course.setDescription(resultSet.getString("description"));
                    return course;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving course by ID: " + e.getMessage());
        }

        return null;
    }

    @Override
    public void save(Courses course) {
        try {
            if (course.getId() > 0) {

                CallableStatement callStmt = connection.prepareCall("{CALL sp_updateCourse(?, ?, ?)}");
                callStmt.setInt(1, course.getId());
                callStmt.setString(2, course.getName());
                callStmt.setString(3, course.getDescription());
                callStmt.executeUpdate();
            } else {

                CallableStatement callStmt = connection.prepareCall("{CALL sp_addCourse(?, ?)}");
                callStmt.setString(1, course.getName());
                callStmt.setString(2, course.getDescription());
                callStmt.executeUpdate();


                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
                if (rs.next()) {
                    course.setId(rs.getInt(1));
                }
                rs.close();
                stmt.close();
            }
        } catch (SQLException e) {
            System.err.println("Error saving course: " + e.getMessage());
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        try (CallableStatement callStmt = connection.prepareCall("{CALL sp_deleteCourse(?)}")) {
            callStmt.setInt(1, id);

            try (ResultSet resultSet = callStmt.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("result") == 1;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error deleting course: " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean isNameUnique(String name) {
        String sql = "SELECT COUNT(*) FROM Course WHERE name = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) == 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error checking course name uniqueness: " + e.getMessage());
        }

        return false;
    }
}