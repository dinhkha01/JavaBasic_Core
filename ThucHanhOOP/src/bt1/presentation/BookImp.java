package bt1.presentation;

import bt1.business.BookManager;
import bt1.entity.Book;

import java.util.Scanner;

public class BookImp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookManager bookManager = new BookManager();
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
            int n;
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sách cần thêm: ");
                     n = Integer.parseInt(sc.nextLine());
                    for(int i =0 ; i< n; i++){
                        bookManager.addBook(sc);
                    }
                    System.out.println("them sach thanh cong !!!");
                  break;
                case 2:
                    System.out.println("Đã tính lợi nhuận ");
                      break;
                case 3:
                    bookManager.displayAllBooks();
                    break;
                case 4:
                    System.out.print("Nhap ten sach can tim: ");
                    String name = sc.nextLine();
                    bookManager.searchByNameBook(name);
                    break;
                case 5:
                    System.out.print("Nhap nam can thong ke: ");
                    int year = Integer.parseInt(sc.nextLine());
                    Book[] booksYears = bookManager.searchByYear(year);
                    System.out.println();
                    bookManager.displayBooks(booksYears);
                    break;
                case 6:
                    System.out.print("Nhap ten tac gia can thong ke: ");
                    String author = sc.nextLine();
                    Book[] booksAuthor = bookManager.searchByAuthor(author);
                    bookManager.displayBooks(booksAuthor);
                    break;
                case 7:
                    System.out.println("Bai");
                    System.exit(0);

                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }

        }
    }
}
