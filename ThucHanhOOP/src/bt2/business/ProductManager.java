package bt2.business;

import bt2.entity.Product;
import bt2.validate.ValidateProduct;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class ProductManager {
    Product[] products;
    int size;
    public ProductManager(){
        products = new Product[100];
        size = 0;
    };
    private String generateProductId() {
        Random random = new Random();
        String newId;

        // Lặp cho đến khi tìm được ID không trùng
        do {
            // Tạo 3 số ngẫu nhiên từ 0-999
            int randomNumber = random.nextInt(1000);
            // Định dạng thành 3 chữ số, thêm số 0 ở đầu nếu cần
            newId = "P" + String.format("%03d", randomNumber);
        } while (isIdExist(newId)); // Kiểm tra ID đã tồn tại chưa

        return newId;
    }

    private boolean isIdExist(String id) {
        for (int i = 0; i < size; i++) {
            if (products[i].getProductId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    public  void addProduct(Scanner sc){
        if(products.length < size){
            System.out.println("Danh muc da day roi day");
            return;
        }
        String id = generateProductId();
        String name = ValidateProduct.validateNameProduct(sc);
        float importPrice = ValidateProduct.validateImportPrice(sc);
        float exportPrice = ValidateProduct.validateExportPrice(sc, importPrice);
        int quantity = ValidateProduct.validateQuantity(sc);
        String descriptions = ValidateProduct.validateDescription(sc);
        boolean status = ValidateProduct.validateStatus(sc);
        products[size] = new Product(id,name,importPrice,exportPrice,quantity,descriptions,status);
        size++;
    }
    public void disPlayAllProducts( ){
        if (size == 0 ){
            System.out.println("Danh muc chua co san pham nao");
            return;
        }
        System.out.println("Danh muc cac san pham : ");
        for(int i =0 ; i < size ; i++){
            products[i].disPlayInfo();
        }
    }
    public void calculateProfit(){
        if (size == 0 ){
            System.out.println("Danh muc chua co san pham nao");
            return;
        }
        for(int i =0 ; i < size ; i++){
            products[i].calculateProfit();
        }
        System.out.println("da tinh loi nhuan san pham: ");
    }
    public void findProductByPrice(float fromPrice , float toPrice ){
        if (size == 0 ){
            System.out.println("Danh muc chua co san pham nao");
            return;
        }
        System.out.println("San pham co gia tu "+ fromPrice +" den "+ toPrice +" : ");
        Product[] productsByPrice = new Product[size];
        int count = 0;
        for(int i =0 ; i < size ; i++){
            if(products[i].getExportPrice() >= fromPrice && products[i].getExportPrice() <= toPrice ){
                productsByPrice[count] = products[i];
                count++;
            }
        }
        disPlayProductsSearch(Arrays.copyOf(productsByPrice,count));
        }

        public void searchProductByName(String name){
        if (size == 0 ){
            System.out.println("Danh muc chua co san pham nao");
            return;
        }
        System.out.println("San pham co ten la: "+ name +" : ");
        Product[] productsByName = new Product[size];
        int  count = 0;

        for (int i = 0 ; i <size ; i++ ){
            if (products[i].getProductName().equals(name)){
                productsByName[count] = products[i];
                count++;
            }

        }
        disPlayProductsSearch(Arrays.copyOf(productsByName,count));

        }
        public void disPlayProductsSearch(Product[] products){
            if(products.length == 0){
                System.out.println("Khong tim thay san pham nao hop le: ");
                return;
            }

            for(int i =0 ; i < products.length ; i++){
                products[i].disPlayInfo();
            }
        }
        public void addProductToStock(String id , int quantity) {
            for (int i = 0; i < products.length; i++) {
                if (products[i].getProductId().equals(id)) {
                    products[i].setQuantity(products[i].getQuantity() + quantity);
                    System.out.println("Da them " + quantity + " san pham vao kho");
                    return;
                }

            }
            System.out.println("San pham co id khong hop le");

        }

    public void sellProductByName(String name, int quantity) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getProductName().equals(name)) {
                if (products[i].getQuantity() >= quantity) {
                    products[i].setQuantity(products[i].getQuantity() - quantity);
                    System.out.println("Đã bán " + quantity + " sản phẩm");
                } else {
                    System.out.println("Sản phẩm không đủ số lượng");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm với tên: " + name);
    }
        public void changeStatus(String id){
         for(int i =0 ; i < products.length ; i++){
             if(products[i].getProductId().equals(id) ){
                 products[i].setStatus(!products[i].isStatus());
                 System.out.println("Da thay doi trang thai san pham");
                 return;
             } else {
                 System.out.println("San pham co id khong hop le");
                 return;
             }
         }
        }
    }





