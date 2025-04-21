package bt1.business.service;

import bt1.business.dao.BookType.BookTypeBusiness;
import bt1.entity.BookType;

import java.util.List;
import java.util.Scanner;

public class BookTypeService {
    private final BookTypeBusiness bookTypeBusiness;
    private final Scanner scanner;

    public BookTypeService() {
        this.bookTypeBusiness = new BookTypeBusiness();
        this.scanner = new Scanner(System.in);
    }

    public void displayAllBookTypes() {
        List<BookType> bookTypes = bookTypeBusiness.findAll();
        if (bookTypes.isEmpty()) {
            System.out.println("Không có loại sách nào.");
        } else {
            System.out.println("Danh sách loại sách:");
            for (BookType bookType : bookTypes) {
                bookType.displayData();
                System.out.println("----------------------");
            }
        }
    }

    public void createNewBookType() {
        BookType bookType = new BookType();
        bookType.inputData(scanner);
        bookTypeBusiness.save(bookType);
        System.out.println("Tạo mới loại sách thành công.");
    }

    public void updateBookType() {
        System.out.print("Nhập ID loại sách cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        BookType bookType = bookTypeBusiness.findById(id);

        if (bookType == null) {
            System.out.println("Không tìm thấy loại sách với ID: " + id);
            return;
        }

        boolean isEditing = true;
        while (isEditing) {
            System.out.println("Thông tin hiện tại:");
            bookType.displayData();
            System.out.println("Chọn trường cần chỉnh sửa:");
            System.out.println("1. Tên loại sách");
            System.out.println("2. Mô tả");
            System.out.println("3. Hoàn tất chỉnh sửa");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên loại sách mới: ");
                    bookType.setTypeName(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Nhập mô tả mới: ");
                    bookType.setDescription(scanner.nextLine());
                    break;
                case 3:
                    isEditing = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }

        try {
            bookTypeBusiness.save(bookType);
            System.out.println("Cập nhật loại sách thành công.");
        } catch (Exception e) {
            System.out.println("Lỗi khi cập nhật: " + e.getMessage());
        }
    }

    public void deleteBookType() {
        System.out.print("Nhập ID loại sách cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        bookTypeBusiness.deleteById(id);
        System.out.println("Xóa loại sách thành công.");
    }

    public void countBooksByType() {
        System.out.print("Nhập ID loại sách: ");
        int typeId = Integer.parseInt(scanner.nextLine());
        int count = bookTypeBusiness.countBooksByTypeId(typeId);
        System.out.println("Số lượng sách thuộc loại " + typeId + ": " + count);
    }
}