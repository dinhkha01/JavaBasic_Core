package bt1.validate;

import bt1.entity.Book;

import java.util.Scanner;

public class ValidatorBook {
    public static String validateName(Scanner sc, Book[] books, int size){
        while(true) {
            System.out.println("\"Nhập tên sách (4 ký tự, bắt đầu bằng B): \"");
            String name = sc.nextLine();
            if(name.length() == 4 && name.startsWith("B") && isBookNameUnique(name, books,size)){
                return name;
            }
            System.out.println("Tên sách đã tồn tại hoặc không hop lệ! Vui lòng nhập lại.");
        }
    }
    public static boolean isBookNameUnique(String name , Book[] books , int size){
        for(int i =0 ; i < size ; i++){
            if(books[i].getBookName().equals(name)) return false;
        }
        return true;
    }

    public static float validateImportPrice(Scanner sc){
        while(true){
            System.out.println("Nhập giá nhập (lớn hơn 0): ");
            float price = sc.nextFloat();
            if(price > 0) return price;
            System.out.println("Giá nhập phải lớn hơn 0.");

        }
    }
    public static float validateExportPrice(Scanner sc, float importPrice){
        while(true){
            System.out.println("Nhập giá xuất (lớn hơn ít nhất 30% giá nhập): ");
            float price = sc.nextFloat();
            if(price >= importPrice * 1.3 ) return price;
            System.out.println("Giá xuất phải lớn hơn ít nhất 30% giá nhập.");

        }
    }
    public  static String validateAuthor(Scanner sc){
        while(true){
            System.out.println("Nhập tác giả (6-50 ký tự):  ");
            String author = sc.nextLine();
            if( author.length() >= 6 && author.length() <= 50  ) return author;
            System.out.println("Tác giả phải có từ 6-50 ký tự.");
        }
    }
    public static int validateYear(Scanner sc){
        while(true){
            System.out.print("Nhập năm xuất bản (sau 2000): ");
            int year = Integer.parseInt(sc.nextLine());
            if(year >= 2000) return year;
            System.out.println("Năm xuất bản phải sau 2000.");
        }
    }

}
