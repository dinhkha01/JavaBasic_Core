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

        boolean isEditing = true;
        while (isEditing) {
            System.out.println("Thông tin hiện tại:");
            book.displayData();
            System.out.println("Chọn trường cần chỉnh sửa:");
            System.out.println("1. Tên sách");
            System.out.println("2. Tác giả");
            System.out.println("3. Nội dung");
            System.out.println("4. Số trang");
            System.out.println("5. Nhà xuất bản");
            System.out.println("6. Giá");
            System.out.println("7. Mã loại sách");
            System.out.println("8. Hoàn tất chỉnh sửa");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên sách mới: ");
                    book.setBookName(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Nhập tác giả mới: ");
                    book.setAuthor(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Nhập nội dung mới: ");
                    book.setContent(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Nhập số trang mới: ");
                    book.setTotalPages(Integer.parseInt(scanner.nextLine()));
                    break;
                case 5:
                    System.out.print("Nhập nhà xuất bản mới: ");
                    book.setPublisher(scanner.nextLine());
                    break;
                case 6:
                    System.out.print("Nhập giá mới: ");
                    book.setPrice(Double.parseDouble(scanner.nextLine()));
                    break;
                case 7:
                    System.out.println("Danh sách loại sách:");
                    List<BookType> bookTypes = bookTypeBusiness.findAll();
                    for (BookType type : bookTypes) {
                        System.out.printf("ID: %d - Tên: %s%n", type.getId(), type.getTypeName());
                    }
                    System.out.print("Nhập mã loại sách mới: ");
                    int typeId = Integer.parseInt(scanner.nextLine());
                    // Kiểm tra typeId hợp lệ
                    boolean validType = bookTypes.stream().anyMatch(t -> t.getId() == typeId);
                    if (validType) {
                        book.setTypeId(typeId);
                    } else {
                        System.out.println("Mã loại sách không tồn tại!");
                    }
                    break;
                case 8:
                    isEditing = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }

        try {
            bookBusiness.save(book);
            System.out.println("Cập nhật sách thành công.");
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật: " + e.getMessage());
        }
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