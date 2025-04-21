package bt1.entity;

import java.util.Scanner;

public class BookType implements IBook {
    private int id;
    private String typeName;
    private String description;
    private boolean isDeleted;

    public BookType() {
    }

    public BookType(int id, String typeName, String description, boolean isDeleted) {
        this.id = id;
        this.typeName = typeName;
        this.description = description;
        this.isDeleted = isDeleted;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Enter book type name: ");
        this.typeName = scanner.nextLine();
        System.out.print("Enter description: ");
        this.description = scanner.nextLine();
        this.isDeleted = false;
    }

    @Override
    public void displayData() {
        System.out.println("Book Type ID: " + id);
        System.out.println("Type Name: " + typeName);
        System.out.println("Description: " + description);
        System.out.println("Status: " + (isDeleted ? "Deleted" : "Active"));
    }
}