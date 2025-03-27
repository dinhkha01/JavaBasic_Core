package bt1.entity;

import bt1.validate.ValidatorBook;

import java.util.Scanner;
import java.util.UUID;

public class Book {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;

    public Book() {
    }

    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author,  int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.year = year;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public void inputData(Scanner sc){
        this.bookId = UUID.randomUUID().toString();
        this.bookName = ValidatorBook.validateName(sc);
        this.importPrice = ValidatorBook.validateImportPrice(sc);
        this.exportPrice = ValidatorBook.validateExportPrice(sc, importPrice);
        this.author = ValidatorBook.validateAuthor(sc);
        this.year = ValidatorBook.validateYear(sc);
    }
    public void calculateInterest(){
        this.interest = exportPrice - importPrice;
    };

    public void displayData() {
        System.out.println("Mã sách: " + bookId);
        System.out.println("Tên sách: " + bookName);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá xuất: " + exportPrice);
        System.out.println("Tác giả: " + author);
        System.out.println("Lợi nhuận: " + interest);
        System.out.println("Năm xuất bản: " + year);
        System.out.println("----------------------------------");
    }


}
