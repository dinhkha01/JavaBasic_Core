package bt4.business;

import bt4.entity.Categories;

import java.util.Scanner;

public class CategoriManager {
    public static Categories[] categories;
    public static int sizeCategori;
    public static int idCouter=0;
    public CategoriManager(){
        categories = new Categories[100];
        sizeCategori = 0;
    }
    public int idCouter() {
        return ++idCouter;
    };
    public void addCategories(Scanner sc){
        if(sizeCategori >= categories.length ){
            System.out.println("The list is full. Cannot add more categories.");
            return;
        }
        Categories categori = new Categories();
        categori.inputData( sc);
        categori.setCategoryId(idCouter());
        categories[sizeCategori] = categori;
        sizeCategori++;
    }

  public void showAllCate(){
        for(int i = 0 ; i< sizeCategori; i++){
            categories[i].displayData();
        }
  }
  public Categories findById(int id){
        for(int i = 0 ; i< sizeCategori; i++){
            if(categories[i].getCategoryId() == id){
                return categories[i];
            }
        }
      System.out.println("khong tim thay danh muc cua ID: " + id);
        return null;
  }

    public void updateCategories(Categories categorie){
        for(int i =0 ; i < sizeCategori ; i++){
            if(categories[i].getCategoryId() == categorie.getCategoryId()){
                categories[i]= categorie;
                return;
            }
        }
    }
    public int findIndexById(int id){
        for(int i = 0 ; i< sizeCategori; i++){
            if(categories[i].getCategoryId() == id){
                return i;
            }
        }
        System.out.println("khong tim thay danh muc cua ID: " + id);
        return -1;
    }
    public void deleteCategories(int id){
        int index = findIndexById(id);
        for(int i = index ; i < sizeCategori -1 ; i ++){
            categories[i]= categories[i+1];

        }
        sizeCategori--;
    }
    public void changeStatusCate( int id){
        int index = findIndexById(id);
        categories[index].setCategoryStatus(!categories[index].isCategoryStatus());
        System.out.println("cap nhat thanh cong");
    }
}
