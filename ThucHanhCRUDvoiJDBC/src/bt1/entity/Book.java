package bt1.entity;

import java.util.Scanner;

public class Book implements IBook {
    private int id;
    private String bookName;
    private String author;
    private String content;
    private int totalPages;
    private String publisher;
    private double price;
    private int typeId;
    private boolean isDeleted;

    public Book() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.print("Enter book name: ");
        this.bookName = scanner.nextLine();
        System.out.print("Enter author: ");
        this.author = scanner.nextLine();
        System.out.print("Enter content: ");
        this.content = scanner.nextLine();

        // Validate số trang
        while (true) {
            try {
                System.out.print("Enter total pages: ");
                this.totalPages = Integer.parseInt(scanner.nextLine());
                if (this.totalPages > 0) break;
                System.out.println("Số trang phải lớn hơn 0");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên dương");
            }
        }

        System.out.print("Enter publisher: ");
        this.publisher = scanner.nextLine();

        // Validate giá
        while (true) {
            try {
                System.out.print("Enter price: ");
                this.price = Double.parseDouble(scanner.nextLine());
                if (this.price > 0) break;
                System.out.println("Giá sách phải lớn hơn 0");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực dương");
            }
        }

        // Validate typeId
        while (true) {
            try {
                System.out.print("Enter book type ID (xem danh sách phía trên): ");
                this.typeId = Integer.parseInt(scanner.nextLine());
                if (this.typeId > 0) break;
                System.out.println("ID thể loại phải lớn hơn 0");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên dương");
            }
        }

        this.isDeleted = false;
    }
    @Override
    public void displayData() {
        System.out.println("Book ID: " + id);
        System.out.println("Book Name: " + bookName);
        System.out.println("Author: " + author);
        System.out.println("Content: " + content);
        System.out.println("Total Pages: " + totalPages);
        System.out.println("Publisher: " + publisher);
        System.out.println("Price: " + price);
        System.out.println("Type ID: " + typeId);
        System.out.println("Status: " + (isDeleted ? "Deleted" : "Active"));
    }
}