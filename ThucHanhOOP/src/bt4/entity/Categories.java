package bt4.entity;

import java.util.Scanner;

public class Categories implements IApp {
    private int categoryId;
    private String categoryName;
    private String descriptions;
    private boolean categoryStatus;

    public Categories() {
    }

    public Categories(int categoryId, String categoryName, String descriptions, boolean categoryStatus) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.descriptions = descriptions;
        this.categoryStatus = categoryStatus;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(boolean categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    @Override
    public void inputData(Scanner sc) {

    }

    @Override
    public void displayData() {
        System.out.println("Category ID: " + categoryId);
        System.out.println("Category Name: " + categoryName);
        System.out.println("Descriptions: " + descriptions);
        System.out.println("Category Status: " + (categoryStatus?"Hoạt động":" Không hoạt động"));
        System.out.println("------------------------");


    }
    public void showIdAndName(){
        System.out.println(categoryId+" | " + categoryName);
    }
}
