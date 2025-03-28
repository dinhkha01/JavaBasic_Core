package hackthon.business;

import hackthon.entity.Product;

public class ProductManager {
    public static Product[] products;
    public static int size;
    public  static int idCounter =0;
    public ProductManager() {
        products = new Product[100];
        size = 0;
    }
    public int idCounter(){
        return ++idCounter;
    }
}
