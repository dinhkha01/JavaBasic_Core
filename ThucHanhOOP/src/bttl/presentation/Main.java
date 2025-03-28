package bttl.presentation;

import bttl.business.ProductManager;

import java.util.Scanner;

public class Main {
    static ProductManager productManager = new ProductManager();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            System.out.println("-----------Menu---------------");
            System.out.println("1.Nhập số sản phẩm và nhập thông tin sản phẩm ");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo lợi nhuận tăng dần ");
            System.out.println("4. Xóa sản phẩm theo mã sản phẩm ");
            System.out.println("5. Tìm kiếm sản phẩm theo tên sản phẩm");
            System.out.println("6. Thay đổi trạng thái của sản phẩm theo mã sản phẩm ");
            System.out.println("7. Exit");
            System.out.print("Moi ban chon: ");
            int  choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    addProduct();
                    break;
                case 2:
                    productManager.showAllProduct();
                    break;
                case 3:
                    productManager.sortByInterest();
                    break;
                case 4:
                    deleteProduct();
                    break;

                case 5:
                    searchProduct();
                    break;
                case 6:
                    changeStatus();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Lua chon khong hop le");
            }
        }

    }
    public static void addProduct(){
        System.out.println("Nhâp số sản phẩm muốn thêm vào ");
        int n = Integer.parseInt(sc.nextLine());
        for(int i =0; i < n; i++){
            productManager.addProduct(sc);
        }
        System.out.println("Them san pham thanh cong");
    }
    public static void deleteProduct(){
        System.out.println("Nhâp Id sản phẩm cần xoá: ");
        int id = Integer.parseInt(sc.nextLine());
        productManager.deleteProductById(id);
    }
    public static void searchProduct(){
        System.out.println("Nhập tên sản phẩm cần tìm: ");
        String name = sc.nextLine();
        productManager.searchByName(name);
    }
    public static void changeStatus(){
        System.out.println("Nhâp Id sản phẩm cần sửa trạng thái: ");
        int id = Integer.parseInt(sc.nextLine());
        productManager.changeStatus(id);
    }

}
