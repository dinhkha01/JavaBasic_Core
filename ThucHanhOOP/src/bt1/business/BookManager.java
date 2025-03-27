package bt1.business;

import bt1.entity.Book;
import bt1.validate.ValidatorBook;

import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class BookManager {
    public static Book[] books;
    public static int size;
;

    public BookManager() {
        books = new Book[100];
        size = 0;
    }

    public  void addBook(Scanner sc) {
        if(size >= books.length){
            System.out.println("Danh sach sach da day");
            return;
        }
        Book book = new Book();
        book.inputData(sc);
        books[size] = book;
        size++;
    }
    public void calculateInterest(){
        for( int i =0; i< size ; i ++ ){
            books[i].calculateInterest();

        }
        System.out.println("Đã tính lợi nhuận ");
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
            System.err.println("không tìm thấy sách: " + name);
        }

    }
}




