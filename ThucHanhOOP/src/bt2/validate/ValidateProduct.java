package bt2.validate;

import java.util.Scanner;

public class ValidateProduct {

    public static String validateNameProduct(Scanner sc){
        while(true){
            System.out.println("Nhap tên sản phẩm – gồm 6-50 ký tự");
            String name = sc.nextLine();
            if(name.length() >= 6 && name.length() <= 60){
                return name;
            }
            System.out.println("Ten khong hop le !!! ");
        }
    };
    public static float validateImportPrice(Scanner sc){
        while( true ){
            System.out.println("Gia nhap (>0) : ");
            float importPrice = Float.parseFloat(sc.nextLine());
            if (importPrice >0){
                return  importPrice;
            }
            System.out.println("Gia nhap phai lon hon 0");

        }
    };
    public static float validateExportPrice(Scanner sc, float importPrice){
        while(true){
            System.out.println("Gia ban:");
            float exportPrice = Float.parseFloat(sc.nextLine());
            if(exportPrice >= importPrice * 1.2){
                return exportPrice;
            }
            System.out.println("Gia ban phai lon hon gia nhap 20%");

        }
    };

    public static int validateQuantity(Scanner sc){
        while (true){
            System.out.println("Nhap so luong san pham (>0):");
            int quantity = Integer.parseInt(sc.nextLine());
            if(quantity > 0){
                return quantity;
            }
            System.out.println("So luong phai lon hon 0");
        }
    }
    public static boolean validateStatus(Scanner sc){
        while (true){
            System.out.println("Nhap trang thai (true/false):");
            String status = sc.nextLine().trim().toLowerCase();
            if(status.equals("true") || status.equals("false")){
                return Boolean.parseBoolean(status);
            }
            System.out.println("Trang thai phai la true hoac false");
        }

    };
    public static String validateDescription(Scanner sc){
        while(true){
            System.out.println("Nhap mo ta cua san pham de: ");
            String description = sc.nextLine();
            if(!description.isEmpty()){
                return description;
            }
            System.out.println("Mo tả ko dc để trống !!! ");

        }
    }


}
