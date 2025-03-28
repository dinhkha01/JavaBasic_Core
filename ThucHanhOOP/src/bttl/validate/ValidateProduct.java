package bttl.validate;

import java.util.Scanner;
import static bttl.business.ProductManager.*;
public class ValidateProduct {
    public static String validateName(Scanner sc){
        while (true){
            String name = InputMethod.inputString(sc,"Nhập tên của sản phầm","Tên sản phẩm không được để trống");
            ValidateString val = new ValidateString(6,50);
            if(val.isVal(name)){
                return name;
            }
            System.err.println(val.errorMassage());
        }
    }
    public static String validateTitle(Scanner sc){
        while (true){
            String title = InputMethod.inputString(sc,"Nhập tiêu đề của sản phẩm","Tiêu đề sản phẩm không được để trống");
            ValidateString val = new ValidateString(6,50);
            if(val.isVal(title)){
                return title;
            }
            System.err.println(val.errorMassage());
        }
    }
    public static String validateDescriptions(Scanner sc){
        while (true){
            String description = InputMethod.inputString(sc,"Nhập mô tả sản phẩm của sản phẩm","Mô tả sản phẩm sản phẩm không được để trống");
            ValidateString val = new ValidateString(6,50);
            if(val.isVal(description)){
                return description;
            }
            System.err.println(val.errorMassage());
        }
    }
    public static float validateImportPrice( Scanner sc){
        while (true){
            System.out.println("Nhập giá nhập của sản phẩm");
            float importPrice = InputMethod.inputFloat(sc,"Giá nhập phải là số");
            if(importPrice > 0){
                return importPrice;
            }
            System.err.println("Giá nhập phải lớnn hơn 0");
        }

    }
    public static float validateExportPrice( Scanner sc , float importPrice){
        while (true){
            System.out.println("Nhập giá ban của sản phẩm > 20% giá nhập");
            float exportPrice = InputMethod.inputFloat(sc,"Giá bán phải là số");
            if(exportPrice >= importPrice* 1.2){
                return exportPrice;
            }
            System.err.println("Giá bán phải lớnn hơn giá nhập 20% ");
        }

    }
    public static boolean validateStatus( Scanner sc){
        return InputMethod.inputBoolean(sc,"Nhập trang thái sản phẩm (true/đang bán- false/khong bán)","dữ liệu không hợp lệ!!!");
    }
}
