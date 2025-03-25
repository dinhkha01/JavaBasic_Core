package bt1.business;

import bt1.entity.Book;
import bt1.validate.ValidatorBook;

import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class BookManager {
    private Book[] books;
    private int size;

    public BookManager() {
        books = new Book[100];
        size = 0;
    }

    public  void addBook(Scanner sc) {
        if(size >= books.length){
            System.out.println("Danh sach sach da day");
            return;
        }
        System.out.println("Nhap thong tin cua sach thu " + (size +1));
        String bookId = UUID.randomUUID().toString();
        System.out.print("Nhap ten sach: ");
        String bookName = ValidatorBook.validateName(sc,books,size);
        System.out.print("Giá nhập: ");
        float importPrice = ValidatorBook.validateImportPrice(sc);
        System.out.print("Giá xuất: ");
        float exportPrice = ValidatorBook.validateExportPrice(sc, importPrice);
        sc.nextLine();
        System.out.print("Tac giả: ");
        String author = ValidatorBook.validateAuthor(sc);
        System.out.print("Năm xuat ban: ");
        int publishYear = ValidatorBook.validateYear(sc);
        books[size] = new Book(bookId,bookName,importPrice,exportPrice,author,publishYear);
        size++;
    }
    public void displayAllBooks() {
        if (size == 0) {
            System.out.println("khong co sach nao het ");
            return;
        }
        System.out.println("danh sach sahc: ");
        for ( int i =0 ; i < size ; i++ ) {
            books[i].displayData();
        }
    }
    public Book[] searchByAuthor( String author){
        Book[] authors = new Book[size];
        int count = 0;
        for(int i =0 ; i < size; i++){
            if(books[i].getAuthor().equals(author)){
                authors[count]= books[i];
                count++;
            }

        }
        // đưa mảng về đúng kích thước của nó khi đã lưu sách trùng author
        return Arrays.copyOf(authors,count);
    }
    public Book[] searchByYear(int year){
        Book[] years = new Book[size];
        int count = 0;
        for( int i = 0; i < size; i++){
            if(books[i].getYear() == year){
                years[count]= books[i];
                count++;
            }
        }

        return Arrays.copyOf(years,count);
    }


    public void displayBooks(Book[] books){
        if(books.length == 0){
            System.out.println("không tìm thấy sách: ");
            return;
        }
        System.out.println("danh sach sach thoa man dieu kien: ");
        for(Book book : books){
            book.displayData();
        }
    }
    public void searchByNameBook(String name) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (books[i].getBookName().equalsIgnoreCase(name)) {
                books[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("không tìm thấy sách: " + name);
        }

    }
}




