package bt1.validate;

import bt1.entity.Book;

import java.util.Scanner;
import static bt1.business.BookManager.*;


public class ValidatorBook {
    public static String validateName(Scanner sc){
        while(true) {
            String name = InputMethod.inputString(sc,"Nhập tên sách (4 ki tu va bat dau bang chu B)", "Tên sách không được để trống") ;
            if(name.length() == 4 && name.startsWith("B")){
                if( isBookNameUnique(name)) {
                    return name;
                }
                System.err.println("Tên sách đã tồn tại");
                continue;
            }
            System.err.println(" Ten sach không hop lệ! Vui lòng nhập lại.");
        }
    }
    public static boolean isBookNameUnique(String name){
        for(int i =0 ; i < size ; i++){
            if(books[i].getBookName().equals(name)) return false;
        }
        return true;
    }

    public static float validateImportPrice(Scanner sc){
        while(true){
            System.out.println("Nhập giá nhập (lớn hơn 0): ");
            float price = InputMethod.inputFloat(sc,"giá nhập phải là số");
            if(price > 0) return price;
            System.err.println("Giá nhập phải lớn hơn 0.");

        }
    }
    public static float validateExportPrice(Scanner sc, float importPrice){
        System.out.println("Nhập giá xuất (lớn hơn ít nhất 30% giá nhập): ");
        while(true){
            float price = InputMethod.inputFloat(sc,"giá bán phải là số");
            if(price >= importPrice * 1.3 ) return price;
            System.err.println("Giá bán phải lớn hơn ít nhất 30% giá nhập.");

        }
    }
    public  static String validateAuthor(Scanner sc){
        while(true){
            String author = InputMethod.inputString(sc, "Nhập tác giả (6-50 ký tự)","Tên tác giả không dc để trống");
            ValidateString validate = new ValidateString(6,50);
            if( validate.isValid(author)) return author;
            System.err.println(validate.errorMassage());
        }
    }
    public static int validateYear(Scanner sc){
        System.out.print("Nhập năm xuất bản (sau 2000): ");
        while(true){
            int year = InputMethod.inputInt(sc,"Năm xuất bản phải là số");
            if(year >= 2000) return year;
            System.err.println("Năm xuất bản phải sau 2000.");
        }
    }

}
