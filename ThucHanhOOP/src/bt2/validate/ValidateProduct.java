package bt2.validate;

import bt1.validate.ValidateString;

import java.util.Scanner;
import static bt2.business.ProductManager.*;

public class ValidateProduct {

    public static String validateIdProduct(Scanner sc){
        while(true){
            String id = InputMethod.inputString(sc,"Nhap id cua san pham (gồm 4 kí tự) và bắt đầu bằng kis tu P","Id không Hợp lệ");
            if(id.length()==4 && id.startsWith("P")){
                if (idIdProductIdUnique(id)) {
                    return id;
                }
                System.err.println("Id da ton tai");
                continue;
            }
            System.err.println("Id phai bat dau bang ky tu P va co do dai 4 ky tu");
        }
    }
    public static boolean idIdProductIdUnique(String id){
        for( int i = 0; i < size ; i++){
            if(products[i].getProductId().equals(id)) return false;
        }
        return true;
    }

    public static String validateNameProduct(Scanner sc){
        while(true){
            String name = InputMethod.inputString(sc,"Nhap tên sản phẩm – gồm 6-50 ký tự","Tên sản phẩm không được đê trống");
            ValidateString val = new ValidateString(6,50);
            if(val.isValid(name)){
                return name;
            }
            System.err.println(val.errorMassage());
        }
    };
    public static float validateImportPrice(Scanner sc){
        while( true ){
            System.out.println("Gia nhap (>0) : ");
            float importPrice = InputMethod.inputFloat(sc,"Gia nhap phai la so ");
            if (importPrice > 0){
                return  importPrice;
            }
            System.err.println("Gia nhap phai lon hon 0");

        }
    };
    public static float validateExportPrice(Scanner sc, float importPrice){
        while(true){
            System.out.println("Gia ban:");
            float exportPrice = InputMethod.inputFloat(sc,"Gia ban phai la so");
            if(exportPrice >= importPrice * 1.2){
                return exportPrice;
            }
            System.out.println("Gia ban phai lon hon gia nhap 20%");

        }
    };

    public static int validateQuantity(Scanner sc){
        while (true){
            System.out.println("Nhap so luong san pham (>0):");
            int quantity = InputMethod.inputInt(sc,"So luong san pham phai la so");
            if(quantity > 0){
                return quantity;
            }
            System.err.println("So luong phai lon hon 0");
        }
    }
    public static boolean validateStatus(Scanner sc){
        return InputMethod.inputBoolean(sc,"Nhập trạng thái sản phầm (true / đang bán - false / chưa bán)","lựa chọn ko hợp lệ , vui lòng nhập lại");


    };
    public static String validateDescription(Scanner sc){
        String description = InputMethod.inputString(sc,"Nhap mo ta cua san pham de:","Mô tả không dc để trống");
        return description;
    }
}
