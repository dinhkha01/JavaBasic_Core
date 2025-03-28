package hackthon.validate;

import java.util.Scanner;

public class ValidateProduct {
    public static String validateName(Scanner sc) {
        while(true){
            String name = InputMehod.inputString(sc,"Nhập tên sản phẩm ", "tên ko dc trống");
             if(name.length() > 4 && name.length() <=20 ){
                 return name;
             }
             System.out.println("Tên phải từ 5 đến 20 kí tự");

        }


    }
    public static String validateTitle(Scanner sc) {
        while(true){
            String title = InputMehod.inputString(sc,"Nhập tiêu đề sản phẩm ", "tieu ko dc trống");
             if(title.length() > 1 && title.length() <=50 ){
                 return title;
             }
            System.out.println("Tieu de phai tren");
        }
    }
    public static String validateDes(Scanner sc) {
        while(true){
            String des = InputMehod.inputString(sc,"Nhập miêu tả sản phẩm ", "tieu ko dc trống");
             if(des.length() > 1 && des.length() <=500 ){
                 return des;
             }
            System.out.println("Miêu tả phai tren");
        }
    }
    public static Float validateImportPrice(Scanner sc) {
        while(true){
            float importPrice = InputMehod.inputFloat(sc,"Nhập giá nhập của sản phẩm ", "Giá nhập phải là số");
             if(importPrice>0){
                 return importPrice;
             }
            System.err.println("Giá nhâp phải lớn hơn 0");
        }
    }
    public static Float validateExportPrice(Scanner sc, float importPrice) {
        while(true){
            float exportPrice  = InputMehod.inputFloat(sc,"Nhập giá bán của sản phẩm ", "Giá bán phải là số");
            if(exportPrice > importPrice * 1.2 ){
                 return exportPrice ;
             }
            System.err.println("Giá bán phải lớnn hơn giá nhập 20% ");
        }
    }
    public static Boolean validateStatus(Scanner sc){

        return InputMehod.inputBoolean(sc,"Nhập trang thái sản phẩm (true/đang bán- false/khong bán)","dữ liệu không hợp lệ!!!");
    }

}
