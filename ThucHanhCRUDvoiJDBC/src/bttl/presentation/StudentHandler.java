package bttl.presentation;

import bttl.business.service.StudentService;
import bttl.entity.Students;
import bttl.validate.ValidateStudent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class StudentHandler {
    private final Scanner scanner;
    private final StudentService studentService;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public StudentHandler(Scanner scanner, StudentService studentService) {
        this.scanner = scanner;
        this.studentService = studentService;
    }

    public void showMenu() {
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
                case 1 -> listAllStudents();
                case 2 -> addNewStudent();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> searchStudentsByName();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void listAllStudents() {
        List<Students> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.printf("%-7s %-20s %-25s %-15s %-6s %-12s %-20s %-7s\n",
                    "ID", "Name", "Email", "Phone", "Sex", "Birth Date", "Course", "Status");
            for (Students s : students) {
                System.out.printf("%-7s %-20s %-25s %-15s %-6s %-12s %-20s %-7s\n",
                        s.getId(), s.getName(), s.getEmail(), s.getPhone(),
                        s.isSex() ? "Male" : "Female",
                        dateFormat.format(s.getBod()),
                        s.getCourseId(),
                        s.isStatus() ? "Active" : "Inactive");
            }
        }
    }

    private void addNewStudent() {
        Students s = new Students();

        System.out.print("Enter ID: ");
        s.setId(scanner.nextLine());
        System.out.print("Enter name: ");
        s.setName(scanner.nextLine());
        System.out.print("Enter email: ");
        s.setEmail(scanner.nextLine());
        System.out.print("Enter phone: ");
        s.setPhone(scanner.nextLine());
        System.out.print("Enter sex (1 = Male, 0 = Female): ");
        s.setSex(scanner.nextLine().equals("1"));

        System.out.print("Enter birth date (dd/MM/yyyy): ");
        try {
            s.setBod(dateFormat.parse(scanner.nextLine()));
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
            return;
        }

        System.out.print("Enter course ID: ");
        s.setCourseId(Integer.parseInt(scanner.nextLine()));
        System.out.print("Enter avatar (optional): ");
        s.setAvatar(scanner.nextLine());
        s.setStatus(true);

        if (!ValidateStudent.validate(s)) {
            System.out.println("Invalid student data.");
            return;
        }

        if (studentService.addStudent(s)) {
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Failed to add student. Email or phone may already exist.");
        }
    }

    private void updateStudent() {
        System.out.print("Enter student ID to update: ");
        String id = scanner.nextLine();
        Students existing = studentService.getStudentById(id);
        if (existing == null) {
            System.out.println("Student not found.");
            return;
        }

        Students updated = new Students();
        updated.setId(id);

        System.out.print("Enter new name (leave blank to keep current): ");
        String name = scanner.nextLine();
        updated.setName(name.isEmpty() ? existing.getName() : name);

        System.out.print("Enter new email (leave blank to keep current): ");
        String email = scanner.nextLine();
        updated.setEmail(email.isEmpty() ? existing.getEmail() : email);

        System.out.print("Enter new phone (leave blank to keep current): ");
        String phone = scanner.nextLine();
        updated.setPhone(phone.isEmpty() ? existing.getPhone() : phone);

        System.out.print("Enter new sex (1 = Male, 0 = Female, blank to keep): ");
        String sexInput = scanner.nextLine();
        updated.setSex(sexInput.isEmpty() ? existing.isSex() : sexInput.equals("1"));

        System.out.print("Enter new birth date (dd/MM/yyyy, blank to keep): ");
        String dob = scanner.nextLine();
        try {
            updated.setBod(dob.isEmpty() ? existing.getBod() : dateFormat.parse(dob));
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
            return;
        }

        System.out.print("Enter new course ID (blank to keep): ");
        String courseInput = scanner.nextLine();
        updated.setCourseId(courseInput.isEmpty() ? existing.getCourseId() : Integer.parseInt(courseInput));

        System.out.print("Enter new avatar (blank to keep): ");
        String avatar = scanner.nextLine();
        updated.setAvatar(avatar.isEmpty() ? existing.getAvatar() : avatar);

        System.out.print("Enter new status (1 = Active, 0 = Inactive, blank to keep): ");
        String status = scanner.nextLine();
        updated.setStatus(status.isEmpty() ? existing.isStatus() : status.equals("1"));

        if (!ValidateStudent.validate(updated)) {
            System.out.println("Invalid student data.");
            return;
        }

        if (studentService.updateStudent(updated)) {
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Failed to update student. Email or phone may already exist.");
        }
    }

    private void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        String id = scanner.nextLine();

        if (studentService.deleteStudent(id)) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Failed to delete student.");
        }
    }

    private void searchStudentsByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        List<Students> students = studentService.searchStudentsByName(name);
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.printf("%-7s %-20s %-25s %-15s %-6s %-12s %-20s %-7s\n",
                    "ID", "Name", "Email", "Phone", "Sex", "Birth Date", "Course", "Status");
            for (Students s : students) {
                System.out.printf("%-7s %-20s %-25s %-15s %-6s %-12s %-20s %-7s\n",
                        s.getId(), s.getName(), s.getEmail(), s.getPhone(),
                        s.isSex() ? "Male" : "Female",
                        dateFormat.format(s.getBod()),
                        s.getCourseId(),
                        s.isStatus() ? "Active" : "Inactive");
            }
        }
    }
}
