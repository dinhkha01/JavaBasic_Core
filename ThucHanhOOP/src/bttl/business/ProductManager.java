package bttl.business;

import bttl.entity.Product;

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
        for(int i=0; i < size; i++){
            products[i].disPlayData();
        }
    }

    public void sortByInterest() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (products[i].getInterest() < products[j].getInterest()) {
                    Product temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp thành công theo lợi nhuận (giảm dần)");
        showAllProduct();
    }
}
