package bt2.business;

import bt2.entity.Product;
import bt2.validate.ValidateProduct;

import java.util.Arrays;

import java.util.Scanner;


public class ProductManager {
   public static Product[] products;
    public static int size;
    Scanner sc = new Scanner(System.in);
    public ProductManager(){
        products = new Product[100];
        size = 0;
    };



    public  void addProduct(){
        if(size >= products.length){
            System.out.println("Danh muc da day roi day");
            return;
        }
        Product product = new Product();
        product.inputData(sc);
        products[size]= product;
        size++;
    }
    public void disPlayAllProducts( ){
        if (size == 0 ){
            System.err.println("Danh muc chua co san pham nao");
            return;
        }
        System.out.println("Danh muc cac san pham : ");
        for(int i =0 ; i < size ; i++){
            products[i].disPlayInfo();
        }
    }
    public void calculateProfit(){
        if (size == 0 ){
            System.err.println("Danh muc chua co san pham nao");
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
            System.err.println("Danh muc chua co san pham nao");
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
                System.err.println("Khong tim thay san pham nao hop le: ");
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
                    System.err.println("Da them " + quantity + " san pham vao kho");
                    return;
                }

            }
            System.err.println("San pham co id khong hop le");

        }

    public void sellProductByName(String name, int quantity) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getProductName().equals(name)) {
                if (products[i].getQuantity() >= quantity) {
                    products[i].setQuantity(products[i].getQuantity() - quantity);
                    System.err.println("Đã bán " + quantity + " sản phẩm");
                } else {
                    System.err.println("Sản phẩm không đủ số lượng");
                }
                return;
            }
        }
        System.err.println("Không tìm thấy sản phẩm với tên: " + name);
    }
        public void changeStatus(String id) {
            for (int i = 0; i < size; i++) {
                if (products[i].getProductId().equals(id)) {
                    products[i].setStatus(!products[i].isStatus());
                    System.err.println("Da thay doi trang thai san pham");
                    return;
                }
            }
            System.err.println("San pham co id khong hop le");

        }
    }






