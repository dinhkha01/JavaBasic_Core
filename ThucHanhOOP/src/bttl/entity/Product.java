package bttl.entity;

import bttl.validate.ValidateProduct;

import java.util.Scanner;


public class Product implements IProduct{
    Scanner sc = new Scanner(System.in);

    private int id;
    private String name;
    private String title;
    private String descriptions;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean status;

    public Product() {
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Product(int id, String name, String title, String descriptions, float importPrice, float exportPrice, boolean status) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.status = status;
    }

    @Override
    public void inputData() {

        this.name = ValidateProduct.validateName(sc);
        this.title = ValidateProduct.validateTitle(sc);
        this.descriptions = ValidateProduct.validateDescriptions(sc);
        this.importPrice = ValidateProduct.validateImportPrice(sc);
        this.exportPrice = ValidateProduct.validateExportPrice(sc, importPrice);
        this.status = ValidateProduct.validateStatus(sc);
        this.interest = exportPrice - importPrice;
    }

    @Override
    public void disPlayData() {

    }
}
