package bt1.presentation;

import bt1.business.service.BookService;
import bt1.business.service.BookTypeService;

import java.util.Scanner;

public class BookManagement {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BookTypeService bookTypeService = new BookTypeService();
    private static final BookService bookService = new BookService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("***************** BOOK-MANAGEMENT *****************");
            System.out.println("1. Quản lý loại sách (BOOKTYPE-MENU)");
            System.out.println("2. Quản lý sách (BOOK-MENU)");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    bookTypeMenu();
                    break;
                case 2:
                    bookMenu();
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void bookTypeMenu() {
        while (true) {
            System.out.println("****************** BOOKTYPE-MENU ******************");
            System.out.println("1. Danh sách loại sách");
            System.out.println("2. Tạo mới loại sách");
            System.out.println("3. Cập nhật thông tin loại sách");
            System.out.println("4. Xóa loại sách");
            System.out.println("5. Thống kê số lượng sách theo mã loại sách");
            System.out.println("6. Quay lại");
            System.out.print("Chọn chức năng: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    bookTypeService.displayAllBookTypes();
                    break;
                case 2:
                    bookTypeService.createNewBookType();
                    break;
                case 3:
                    bookTypeService.updateBookType();
                    break;
                case 4:
                    bookTypeService.deleteBookType();
                    break;
                case 5:
                    bookTypeService.countBooksByType();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void bookMenu() {
        while (true) {
            System.out.println("******************** BOOK-MENU ********************");
            System.out.println("1. Danh sách sách");
            System.out.println("2. Tạo mới sách");
            System.out.println("3. Cập nhật thông tin sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Hiển thị danh sách các cuốn sách theo giá giảm dần");
            System.out.println("6. Tìm kiếm sách theo tên hoặc nội dung");
            System.out.println("7. Thống kê số lượng sách theo nhóm");
            System.out.println("8. Quay lại");
            System.out.print("Chọn chức năng: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    bookService.displayAllBooks();
                    break;
                case 2:
                    bookService.createNewBook();
                    break;
                case 3:
                    bookService.updateBook();
                    break;
                case 4:
                    bookService.deleteBook();
                    break;
                case 5:
                    bookService.displayBooksOrderByPriceDesc();
                    break;
                case 6:
                    bookService.searchBooksByNameOrContent();
                    break;
                case 7:
                    bookService.countBooksByTypeGroup();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}