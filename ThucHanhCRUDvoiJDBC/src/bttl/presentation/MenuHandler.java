package bttl.presentation;

import bttl.business.service.CourseService;
import bttl.business.service.StudentService;
import bttl.entity.Courses;
import bttl.entity.Students;
import bttl.validate.ValidateCourse;
import bttl.validate.ValidateStudent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class MenuHandler {
    private final Scanner scanner;
    private final CourseService courseService;
    private final StudentService studentService;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public MenuHandler(Scanner scanner, CourseService courseService, StudentService studentService) {
        this.scanner = scanner;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    public void showMainMenu() {
        while (true) {
            System.out.println("\n==== EXAM MANAGEMENT SYSTEM ====");
            System.out.println("1. Course Management");
            System.out.println("2. Student Management");
            System.out.println("0. Exit");
            System.out.print("Please choose: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> showCourseMenu();
                case 2 -> showStudentMenu();
                case 0 -> {
                    System.out.println("Exiting system. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showCourseMenu() {
        CourseHandler handler = new CourseHandler(scanner, courseService);
        handler.showMenu();
    }

    private void showStudentMenu() {
        StudentHandler handler = new StudentHandler(scanner, studentService);
        handler.showMenu();
    }
}
