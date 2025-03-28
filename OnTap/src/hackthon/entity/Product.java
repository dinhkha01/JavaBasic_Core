package hackthon.entity;

import hackthon.business.ProductManager;
import hackthon.validate.InputMehod;
import hackthon.validate.ValidateProduct;

import java.util.Scanner;

public class Product implements IProduct {
   private int id;
   private String name;
   private String title;
   private String descriptions;
   private float importPrice;
   private float exportPrice;
   private float interest;
   private boolean status;
   Scanner sc = new Scanner(System.in);

   public Product() {
   }

   public Product(int id, String name, String title, String descriptions, float importPrice, float exportPrice, float interest, boolean status) {
      this.id = id;
      this.name = name;
      this.title = title;
      this.descriptions = descriptions;
      this.importPrice = importPrice;
      this.exportPrice = exportPrice;
      this.interest = interest;
      this.status = status;
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


   @Override
   public void inputData() {
      name = ValidateProduct.validateName(sc);
      title = ValidateProduct.validateTitle(sc);
      descriptions = ValidateProduct.validateDes(sc);
      importPrice = ValidateProduct.validateImportPrice(sc);
      exportPrice = ValidateProduct.validateExportPrice(sc, importPrice);
      interest = exportPrice - importPrice;
      status = ValidateProduct.validateStatus(sc);
   }

   @Override
   public void displayData() {
      System.out.println("ID: " + id);
      System.out.println("Name: " + name);
      System.out.println("Title: " + title);
      System.out.println("Descriptions: " + descriptions);
      System.out.println("Import Price: " + importPrice);
      System.out.println("Export Price: " + exportPrice);
      System.out.println("Interest: " + interest);
      System.out.println("Status: " + (status? "Đang bán" : "Không bán"));
      System.out.println("-------------------------------------");
   }
}
