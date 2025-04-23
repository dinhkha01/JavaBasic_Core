package bttl.presentation;

import bttl.business.dao.Course.CourseDaoImpl;
import bttl.business.dao.Student.StudentDaoImpl;
import bttl.business.service.CourseService;
import bttl.business.service.StudentService;
import bttl.config.ConnectionDB;
import java.sql.Connection;
import java.util.Scanner;

public class Main {
    private static CourseService courseService;
    private static StudentService studentService;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try (Connection conn = ConnectionDB.openConnection()) {
            if (conn != null) {
                courseService = new CourseService(new CourseDaoImpl(conn));
                studentService = new StudentService(new StudentDaoImpl(conn));
                System.out.println("Connected to database successfully!");

                MenuHandler menuHandler = new MenuHandler(scanner, courseService, studentService);
                menuHandler.showMainMenu();
            } else {
                System.out.println("Failed to connect to database!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
