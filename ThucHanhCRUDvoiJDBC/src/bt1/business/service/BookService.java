package bt1.business.service;

import bt1.business.dao.Book.BookBusiness;
import bt1.business.dao.BookType.BookTypeBusiness;
import bt1.entity.Book;
import bt1.entity.BookType;

import java.util.List;
import java.util.Scanner;

public class BookService {
    private final BookBusiness bookBusiness;
    private final BookTypeBusiness bookTypeBusiness;
    private final Scanner scanner;

    public BookService() {
        this.bookBusiness = new BookBusiness();
        this.bookTypeBusiness = new BookTypeBusiness();
        this.scanner = new Scanner(System.in);
    }

    public void displayAllBooks() {
        List<Book> books = bookBusiness.findAll();
        if (books.isEmpty()) {
            System.out.println("Không có sách nào.");
        } else {
            System.out.println("Danh sách sách:");
            for (Book book : books) {
                book.displayData();
                System.out.println("----------------------");
            }
        }
    }

    public void createNewBook() {
        // Hiển thị danh sách thể loại sách trước khi tạo mới
        System.out.println("Danh sách thể loại sách:");
        List<BookType> bookTypes = bookTypeBusiness.findAll();
        if (bookTypes.isEmpty()) {
            System.out.println("Không có thể loại sách nào. Vui lòng thêm thể loại sách trước.");
            return;
        }

        for (BookType bookType : bookTypes) {
            System.out.printf("ID: %d - Tên: %s%n", bookType.getId(), bookType.getTypeName());
        }
        System.out.println("----------------------");

        Book book = new Book();
        book.inputData(scanner);

        // Kiểm tra xem typeId có tồn tại không
        boolean typeExists = false;
        for (BookType bookType : bookTypes) {
            if (bookType.getId() == book.getTypeId()) {
                typeExists = true;
                break;
            }
        }

        if (!typeExists) {
            System.out.println("Lỗi: Không tìm thấy thể loại sách với ID " + book.getTypeId());
            System.out.println("Thêm sách không thành công.");
            return;
        }

        try {
            bookBusiness.save(book);
            System.out.println("Tạo mới sách thành công.");
        } catch (Exception e) {
            System.out.println("Lỗi khi thêm sách: " + e.getMessage());
        }
    }


    public void updateBook() {
        System.out.print("Nhập ID sách cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        Book book = bookBusiness.findById(id);

        if (book == null) {
            System.out.println("Không tìm thấy sách với ID: " + id);
            return;
        }

        System.out.println("Thông tin hiện tại:");
        book.displayData();
        System.out.println("Nhập thông tin mới:");
        book.inputData(scanner);
        bookBusiness.save(book);
        System.out.println("Cập nhật sách thành công.");
    }

    public void deleteBook() {
        System.out.print("Nhập ID sách cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        bookBusiness.deleteById(id);
        System.out.println("Xóa sách thành công.");
    }

    public void displayBooksOrderByPriceDesc() {
        List<Book> books = bookBusiness.findAllOrderByPriceDesc();
        if (books.isEmpty()) {
            System.out.println("Không có sách nào.");
        } else {
            System.out.println("Danh sách sách theo giá giảm dần:");
            for (Book book : books) {
                book.displayData();
                System.out.println("----------------------");
            }
        }
    }

    public void searchBooksByNameOrContent() {
        System.out.print("Nhập từ khóa tìm kiếm: ");
        String keyword = scanner.nextLine();
        List<Book> books = bookBusiness.searchByNameOrContent(keyword);

        if (books.isEmpty()) {
            System.out.println("Không tìm thấy sách phù hợp.");
        } else {
            System.out.println("Kết quả tìm kiếm:");
            for (Book book : books) {
                book.displayData();
                System.out.println("----------------------");
            }
        }
    }

    public void countBooksByTypeGroup() {
        List<Object[]> results = bookBusiness.countBooksByType();
        if (results.isEmpty()) {
            System.out.println("Không có dữ liệu thống kê.");
        } else {
            System.out.println("Thống kê số lượng sách theo loại:");
            System.out.printf("%-10s %-15s%n", "Type ID", "Số lượng");
            for (Object[] row : results) {
                System.out.printf("%-10d %-15d%n", row[0], row[1]);
            }
        }
    }
}