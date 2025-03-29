package bt4.validate;

import java.util.Scanner;
import static bt4.business.CategoriManager.*;

public class ValidateCategory {
    public static String validateNameCategory(Scanner sc) {
        while (true) {
            String name = InputMehod.inputString(sc, "nhap ten phai tren duoi 50 ki tu", "ten khong dc de trong");
            ValidateString val = new ValidateString(0, 50);
            if (val.isValid(name)) {
                if(isNameUnique(name)) return name;
                System.err.println("ten da bi trung lap");
                continue;
            }
            System.err.println(val.errorMassage());
        }

    }

    public static boolean isNameUnique(String name) {
        for (int i = 0; i < sizeCategori; i++) {
            if (categories[i].getCategoryName().equals(name)) {
                return false;
            }
        }
        return true;
    }
    public static String validateDescriptionCate(Scanner sc){
        while (true){
            String description = InputMehod.inputString(sc,"Nhap tieu de danh muc","Danh muc khong duoc de trong");
            ValidateString val = new ValidateString(6,255);
            if(val.isValid(description))return  description;
            System.err.println(val.errorMassage());
        }
    }
    public static boolean validateStatusCate(Scanner sc){
        return InputMehod.inputBoolean(sc,"Nhập trạng thái của anh mục (true – hoạt động, false – không hoạt động)","dữ liệu khoogn hợp lệ nhập lại đê");
    }
}
