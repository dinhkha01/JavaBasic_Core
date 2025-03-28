package bttl.business;

import bttl.entity.Product;

import java.util.Arrays;
import java.util.Scanner;

public class ProductManager {
    public static Product[] products;
    public static int size;
    public static int idCounter =0;

    public ProductManager() {
        products = new Product[100];
        size = 0;
    }
    public int idCouter(){
        return ++idCounter;
    }
    public void addProduct(Scanner sc) {
        if(size > products.length){
            System.err.println("Vựt mức pickaball ");
            return;
        }
        Product product = new Product();
        product.inputData();
        product.setId(idCouter());
        products[size] = product;
        size++;
    }
    public  void showAllProduct(){
        if(size ==0){
            System.out.println("Danh sách r��ng");
            return;
        }
        for(int i=0; i < size; i++){
            products[i].disPlayData();
        }
    }

    public void sortByInterest() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (products[i].getInterest() > products[j].getInterest()) {
                    Product temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp thành công theo lợi nhuận (giảm dần)");
        showAllProduct();
    }
    public void deleteProductById(int id){
        int index = findIndexById(id);
        if(index != -1) {
            for (int i = index ; i < size-1 ; i++){
                products[i] = products[i+1];
            }
            size--;
        }
    }
    public  int findIndexById(int id){
        for(int i =0 ; i < size ; i++){
            if(products[i].getId() == id) return i;
        }
        System.err.println("không tìm thấy Id");
        return -1;
    }
    public  void searchByName(String name){
        Product[] resul= new Product[size];
        int count =0;
        for( Product p : products){
            if(p != null && p.getName()!=null){
                String productName = p.getName().toLowerCase();
                if(productName.contains(name.toLowerCase())){
                    resul[count]=p;
                    count++;
                }
            }
        }
        showInfor(Arrays.copyOf(resul,count));
    }
    public  void showInfor(Product[] products){
        if(products.length ==0){
            System.err.println("Không tìm thấy sản phẩm nào hợp lệ");
            return;
        }
        for (Product p : products){
            p.disPlayData();
        }
    }
    public void changeStatus(int id){
        int index = findIndexById(id);
        products[index].setStatus(!products[index].isStatus());
        System.out.println("Đã thay đổi trạng status của sản phẩm " + products[index].getName());
        products[index].disPlayData();
    }
}
