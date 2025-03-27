package bt2.entity;

import bt2.business.ProductManager;
import bt2.validate.ValidateProduct;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private float imporPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private  String descriptions;
    private boolean status;

    public Product() {
    }

    public Product(String productId, String productName, float imporPrice, float exportPrice, int quantity, String descriptions, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.imporPrice = imporPrice;
        this.exportPrice = exportPrice;
        this.profit =0;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;

    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getImporPrice() {
        return imporPrice;
    }

    public void setImporPrice(float imporPrice) {
        this.imporPrice = imporPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public void inputData(Scanner sc ){
        this.productId = ValidateProduct.validateIdProduct(sc);
        this.productName = ValidateProduct.validateNameProduct(sc);
        this.imporPrice = ValidateProduct.validateImportPrice(sc);
        this.exportPrice = ValidateProduct.validateExportPrice(sc, imporPrice);
        this.quantity = ValidateProduct.validateQuantity(sc);
        this.descriptions = ValidateProduct.validateDescription(sc);
        this.status = ValidateProduct.validateStatus(sc);
    }
    public float calculateProfit(){
        return profit = exportPrice - imporPrice ;
    }
    public void disPlayInfo(){
        System.out.println("Product ID: "+ productId);
        System.out.println("Product Name: "+ productName);
        System.out.println("Import Price: "+ imporPrice);
        System.out.println("Export Price: "+ exportPrice);
        System.out.println("Profit: "+ profit);
        System.out.println("Quantity: "+ quantity);
        System.out.println("Descriptions: "+ descriptions);
        System.out.println("Status: "+ (status? "Dang ban" : "Khong ban"));
    };
}
