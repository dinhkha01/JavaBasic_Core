package bttl.presentation;


import bttl.business.dao.Course.CourseDaoImpl;
import bttl.business.dao.Student.StudentDaoImpl;
import bttl.business.service.CourseService;
import bttl.business.service.StudentService;
import bttl.config.ConnectionDB;
import bttl.entity.Courses;
import bttl.entity.Students;
import bttl.validate.ValidateCourse;
import bttl.validate.ValidateStudent;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static CourseService courseService;
    private static StudentService studentService;
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {

        try (Connection conn = ConnectionDB.openConnection()) {
            if (conn != null) {
                courseService = new CourseService(new CourseDaoImpl(conn));
                studentService = new StudentService(new StudentDaoImpl(conn));
                System.out.println("Connected to database successfully!");
                showMainMenu();
            } else {
                System.out.println("Failed to connect to database!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void showMainMenu() {
        while (true) {
            System.out.println("\n==== EXAM MANAGEMENT SYSTEM ====");
            System.out.println("1. Course Management");
            System.out.println("2. Student Management");
            System.out.println("0. Exit");
            System.out.print("Please choose: ");

            int choice = Integer.parseInt(scanner.nextLine());


            switch (choice) {
                case 1:
                    showCourseMenu();
                    break;
                case 2:
                    showStudentMenu();
                    break;
                case 0:
                    System.out.println("Exiting system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showCourseMenu() {
        while (true) {
            System.out.println("\n==== COURSE MANAGEMENT ====");
            System.out.println("1. List all courses");
            System.out.println("2. Add new course");
            System.out.println("3. Update course");
            System.out.println("4. Delete course");
            System.out.println("0. Back to main menu");
            System.out.print("Please choose: ");

            int choice = Integer.parseInt(scanner.nextLine());


            switch (choice) {
                case 1:
                    listAllCourses();
                    break;
                case 2:
                    addNewCourse();
                    break;
                case 3:
                    updateCourse();
                    break;
                case 4:
                    deleteCourse();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showStudentMenu() {
        while (true) {
            System.out.println("\n==== STUDENT MANAGEMENT ====");
            System.out.println("1. List all students");
            System.out.println("2. Add new student");
            System.out.println("3. Update student");
            System.out.println("4. Delete student");
            System.out.println("5. Search students by name");
            System.out.println("0. Back to main menu");
            System.out.print("Please choose: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    listAllStudents();
                    break;
                case 2:
                    addNewStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    searchStudentsByName();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void listAllCourses() {
        System.out.println("\n--- List of Courses ---");
        List<Courses> courses = courseService.getAllCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
        } else {
            System.out.printf("%-5s %-30s %-50s\n", "ID", "Name", "Description");
            for (Courses course : courses) {
                System.out.printf("%-5d %-30s %-50s\n",
                        course.getId(), course.getName(), course.getDescription());
            }
        }
    }

    private static void addNewCourse() {
        System.out.println("\n--- Add New Course ---");
        Courses course = new Courses();

        System.out.print("Enter course name: ");
        course.setName(scanner.nextLine());

        System.out.print("Enter course description: ");
        course.setDescription(scanner.nextLine());

        if (!ValidateCourse.validate(course)) {
            System.out.println("Invalid course data. Please check your input.");
            return;
        }

        if (courseService.addCourse(course)) {
            System.out.println("Course added successfully!");
        } else {
            System.out.println("Failed to add course. Course name may already exist.");
        }
    }

    private static void updateCourse() {
        System.out.println("\n--- Update Course ---");
        System.out.print("Enter course ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Courses existing = courseService.getCourseById(id);
        if (existing == null) {
            System.out.println("Course not found with ID: " + id);
            return;
        }

        System.out.println("Current course details:");
        System.out.println("Name: " + existing.getName());
        System.out.println("Description: " + existing.getDescription());

        Courses updated = new Courses();
        updated.setId(id);

        System.out.print("Enter new course name (leave blank to keep current): ");
        String name = scanner.nextLine();
        updated.setName(name.isEmpty() ? existing.getName() : name);

        System.out.print("Enter new course description (leave blank to keep current): ");
        String description = scanner.nextLine();
        updated.setDescription(description.isEmpty() ? existing.getDescription() : description);

        if (!ValidateCourse.validate(updated)) {
            System.out.println("Invalid course data. Please check your input.");
            return;
        }

        if (courseService.updateCourse(updated)) {
            System.out.println("Course updated successfully!");
        } else {
            System.out.println("Failed to update course. Course name may already exist.");
        }
    }

    private static void deleteCourse() {
        System.out.println("\n--- Delete Course ---");
        System.out.print("Enter course ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (courseService.deleteCourse(id)) {
            System.out.println("Course deleted successfully!");
        } else {
            System.out.println("Failed to delete course. It may have associated students or doesn't exist.");
        }
    }

    private static void listAllStudents() {
        System.out.println("\n--- List of Students ---");
        List<Students> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.printf("%-7s %-20s %-25s %-15s %-6s %-12s %-20s %-7s\n",
                    "ID", "Name", "Email", "Phone", "Sex", "Birth Date", "Course", "Status");
            for (Students student : students) {
                System.out.printf("%-7s %-20s %-25s %-15s %-6s %-12s %-20s %-7s\n",
                        student.getId(),
                        student.getName(),
                        student.getEmail(),
                        student.getPhone(),
                        student.isSex() ? "Male" : "Female",
                        dateFormat.format(student.getBod()),
                        student.getCourseId(),
                        student.isStatus() ? "Active" : "Inactive");
            }
        }
    }

    private static void addNewStudent() {
        System.out.println("\n--- Add New Student ---");
        Students student = new Students();

        System.out.print("Enter student ID: ");
        student.setId(scanner.nextLine());

        System.out.print("Enter student name: ");
        student.setName(scanner.nextLine());

        System.out.print("Enter student email: ");
        student.setEmail(scanner.nextLine());

        System.out.print("Enter student phone: ");
        student.setPhone(scanner.nextLine());

        System.out.print("Enter student sex (1 for Male, 0 for Female): ");
        student.setSex(scanner.nextInt() == 1);
        scanner.nextLine();

        System.out.print("Enter student birth date (dd/MM/yyyy): ");
        try {
            student.setBod(dateFormat.parse(scanner.nextLine()));
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            return;
        }

        System.out.print("Enter course ID: ");
        student.setCourseId(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Enter avatar file path (optional): ");
        student.setAvatar(scanner.nextLine());

        student.setStatus(true);

        if (!ValidateStudent.validate(student)) {
            System.out.println("Invalid student data. Please check your input.");
            return;
        }

        if (studentService.addStudent(student)) {
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Failed to add student. Email or phone may already exist.");
        }
    }

    private static void updateStudent() {
        System.out.println("\n--- Update Student ---");
        System.out.print("Enter student ID to update: ");
        String id = scanner.nextLine();

        Students existing = studentService.getStudentById(id);
        if (existing == null) {
            System.out.println("Student not found with ID: " + id);
            return;
        }

        System.out.println("Current student details:");
        System.out.println("Name: " + existing.getName());
        System.out.println("Email: " + existing.getEmail());
        System.out.println("Phone: " + existing.getPhone());
        System.out.println("Sex: " + (existing.isSex() ? "Male" : "Female"));
        System.out.println("Birth Date: " + dateFormat.format(existing.getBod()));
        System.out.println("Course ID: " + existing.getCourseId());
        System.out.println("Avatar: " + existing.getAvatar());
        System.out.println("Status: " + (existing.isStatus() ? "Active" : "Inactive"));

        Students updated = new Students();
        updated.setId(id);

        System.out.print("Enter new student name (leave blank to keep current): ");
        String name = scanner.nextLine();
        updated.setName(name.isEmpty() ? existing.getName() : name);

        System.out.print("Enter new student email (leave blank to keep current): ");
        String email = scanner.nextLine();
        updated.setEmail(email.isEmpty() ? existing.getEmail() : email);

        System.out.print("Enter new student phone (leave blank to keep current): ");
        String phone = scanner.nextLine();
        updated.setPhone(phone.isEmpty() ? existing.getPhone() : phone);

        System.out.print("Enter new student sex (1 for Male, 0 for Female, leave blank to keep current): ");
        String sexInput = scanner.nextLine();
        updated.setSex(sexInput.isEmpty() ? existing.isSex() : sexInput.equals("1"));

        System.out.print("Enter new student birth date (dd/MM/yyyy, leave blank to keep current): ");
        String bodInput = scanner.nextLine();
        try {
            updated.setBod(bodInput.isEmpty() ? existing.getBod() : dateFormat.parse(bodInput));
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            return;
        }

        System.out.print("Enter new course ID (leave blank to keep current): ");
        String courseInput = scanner.nextLine();
        updated.setCourseId(courseInput.isEmpty() ? existing.getCourseId() : Integer.parseInt(courseInput));

        System.out.print("Enter new avatar file path (leave blank to keep current): ");
        String avatar = scanner.nextLine();
        updated.setAvatar(avatar.isEmpty() ? existing.getAvatar() : avatar);

        System.out.print("Enter new status (1 for Active, 0 for Inactive, leave blank to keep current): ");
        String statusInput = scanner.nextLine();
        updated.setStatus(statusInput.isEmpty() ? existing.isStatus() : statusInput.equals("1"));

        if (!ValidateStudent.validate(updated)) {
            System.out.println("Invalid student data. Please check your input.");
            return;
        }

        if (studentService.updateStudent(updated)) {
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Failed to update student. Email or phone may already exist.");
        }
    }

    private static void deleteStudent() {
        System.out.println("\n--- Delete Student ---");
        System.out.print("Enter student ID to delete: ");
        String id = scanner.nextLine();

        if (studentService.deleteStudent(id)) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Failed to delete student. It may not exist.");
        }
    }

    private static void searchStudentsByName() {
        System.out.println("\n--- Search Students by Name ---");
        System.out.print("Enter student name to search: ");
        String name = scanner.nextLine();
        List<Students> students = studentService.searchStudentsByName(name);
        if (students.isEmpty()) {
            System.out.println("No students found with name containing: " + name);
        } else {
            System.out.printf("%-7s %-20s %-25s %-15s %-6s %-12s %-20s %-7s\n",
                    "ID", "Name", "Email", "Phone", "Sex", "Birth Date", "Course", "Status");
            for (Students student : students) {
                System.out.printf("%-7s %-20s %-25s %-15s %-6s %-12s %-20s %-7s\n",
                        student.getId(),
                        student.getName(),
                        student.getEmail(),
                        student.getPhone(),
                        student.isSex() ? "Male" : "Female",
                        dateFormat.format(student.getBod()),
                        student.getCourseId(),
                        student.isStatus() ? "Active" : "Inactive");
            }
        }
    }
}