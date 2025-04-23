package bttl.presentation;

import bttl.business.service.CourseService;
import bttl.entity.Courses;
import bttl.validate.ValidateCourse;

import java.util.List;
import java.util.Scanner;

public class CourseHandler {
    private final Scanner scanner;
    private final CourseService courseService;

    public CourseHandler(Scanner scanner, CourseService courseService) {
        this.scanner = scanner;
        this.courseService = courseService;
    }

    public void showMenu() {
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
                case 1 -> listAllCourses();
                case 2 -> addNewCourse();
                case 3 -> updateCourse();
                case 4 -> deleteCourse();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void listAllCourses() {
        List<Courses> courses = courseService.getAllCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
        } else {
            System.out.printf("%-5s %-30s %-50s\n", "ID", "Name", "Description");
            for (Courses course : courses) {
                System.out.printf("%-5d %-30s %-50s\n", course.getId(), course.getName(), course.getDescription());
            }
        }
    }

    private void addNewCourse() {
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

    private void updateCourse() {
        System.out.print("Enter course ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Courses existing = courseService.getCourseById(id);

        if (existing == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.print("Enter new name (leave blank to keep current): ");
        String name = scanner.nextLine();
        System.out.print("Enter new description (leave blank to keep current): ");
        String desc = scanner.nextLine();

        Courses updated = new Courses(id, name.isEmpty() ? existing.getName() : name,
                desc.isEmpty() ? existing.getDescription() : desc);

        if (!ValidateCourse.validate(updated)) {
            System.out.println("Invalid course data.");
            return;
        }

        if (courseService.updateCourse(updated)) {
            System.out.println("Course updated successfully!");
        } else {
            System.out.println("Failed to update course. Course name may already exist.");
        }
    }

    private void deleteCourse() {
        System.out.print("Enter course ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (courseService.deleteCourse(id)) {
            System.out.println("Course deleted successfully!");
        } else {
            System.out.println("Failed to delete course. It may have associated students or doesn't exist.");
        }
    }
}
