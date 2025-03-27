package bt1.presentation;

import bt1.business.BookManager;
import bt1.entity.Book;

import java.util.Scanner;
import static bt1.business.BookManager.*;

public class BookImp {
   static BookManager bookManager = new BookManager();
   static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {


        while(true ){
            System.out.println("-----------Menu---------------");
            System.out.println("1. Nhap thong tin n sach. ");
            System.out.println("2. Tinh loi sach.");
            System.out.println("3. Hien thi thong tin sach");
            System.out.println("4. Tim sach theo ten");
            System.out.println("5. Thong ke so luong sach theo tung nam");
            System.out.println("6. Thong ke sach theo tac gia");
            System.out.println("7. Exit");
            System.out.print("Moi ban chon: ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addBook();
                  break;
                case 2:
                    bookManager.calculateInterest();
                    disPlayInterest();
                      break;
                case 3:
                    bookManager.displayAllBooks();
                    break;
                case 4:
                   searchByNameBook();
                    break;
                case 5:
                   searchByYear();
                    break;
                case 6:
                   searchByAuthor();
                    break;
                case 7:
                    System.err.println("Bai");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Lua chon khong hop le");
            }

        }
    }
    public static void addBook(  ){
        System.out.print("Nhập số lượng sách cần thêm: ");
        int n = Integer.parseInt(sc.nextLine());
        for(int i =0 ; i< n; i++){
            bookManager.addBook(sc);
        }
        System.out.println("them sach thanh cong !!!");
    };
    public static void searchByNameBook(){
        System.out.print("Nhap ten sach can tim: ");
        String name = sc.nextLine();
        bookManager.searchByNameBook(name);
    }
    public static void searchByYear(){
        System.out.print("Nhap nam can thong ke: ");
        int year = Integer.parseInt(sc.nextLine());
        Book[] booksYears = bookManager.searchByYear(year);
        System.out.println();
        bookManager.displayBooks(booksYears);
    }
    public static void searchByAuthor(){
        System.out.print("Nhap ten tac gia can thong ke: ");
        String author = sc.nextLine();
        Book[] booksAuthor = bookManager.searchByAuthor(author);
        bookManager.displayBooks(booksAuthor);
    }
    public static void disPlayInterest(){
        for(int i =0 ; i < size ; i++){
            System.out.println("Tên sách " + books[i].getBookName());
            System.out.println("Giá lời " + books[i].getInterest());
        }
    }
}
