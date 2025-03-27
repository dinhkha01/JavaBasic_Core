package bt2.presentation;

import bt1.entity.Book;
import bt2.business.ProductManager;

import java.util.Scanner;

public class ProductImp {
    static ProductManager productManager = new ProductManager();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        while(true){
            System.out.println("-----------Menu---------------");
            System.out.println("1.  Nhập thông tin n sản phẩm (n nhập từ bàn phím) ");
            System.out.println("2.Hiển thị thông tin các sản phẩm");
            System.out.println("3.Tính lợi nhuận các sản phẩm");
            System.out.println("4. Thống kê các sản phẩm theo giá");
            System.out.println("5.Tìm các sản phẩm theo tên sản phẩm");
            System.out.println("6. Nhập hàng vào kho");
            System.out.println("7. Bán sản phẩm");
            System.out.println("8. Cập nhật trạng thái sản phẩm");
            System.out.println("9. Exit");
            System.out.print("Moi ban chon: ");
            int  choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    productManager.disPlayAllProducts();
                    break;
                case 3:
                    productManager.calculateProfit();
                    break;
                case 4:
                    findProductByPrice();
                    break;
                case 5:
                    searchProductByName();

                    break;
                case 6:
                    addProductToStock();

                    break;
                case 7:
                    sellProductByName();
                    break;
                case 8:
                    changeStatus();
                    break;
                case 9:
                    System.out.println("Bai");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }

        }

    }
    public static void addProduct(){
        System.out.println("nhap so luong san pham can them vao ");
        int n = Integer.parseInt(sc.nextLine());
        for(int i =0 ; i < n ; i++){
            productManager.addProduct();
        }
        System.out.println("Them san pham thanh cong ");
    }
    public static void findProductByPrice(){
        System.out.println("Nhap gia tu: ");
        float fromPrice = Float.parseFloat(sc.nextLine());
        System.out.println("Nhap gia den: ");
        float toPrice = Float.parseFloat(sc.nextLine());
        productManager.findProductByPrice(fromPrice, toPrice);
    }
    public static void searchProductByName(){
        System.out.println("Nhap ten san pham de tim ne ");
        String name = sc.nextLine();
        productManager.searchProductByName(name);
    }
    public static void addProductToStock(){
        System.out.println("nhap ID cua san pham can nhap: ");
        String id = sc.nextLine();
        System.out.println("nhap so luong san pham can nhap: ");
        int quantity = Integer.parseInt(sc.nextLine());
        productManager.addProductToStock(id, quantity);
    }
    public static void sellProductByName(){
        System.out.println("nhap ten san pham can mua");
        String name = sc.nextLine();
        System.out.println("nhap so luong san pham can mua: ");
        int quantity = Integer.parseInt(sc.nextLine());
        productManager.sellProductByName(name, quantity);
    }
    public static void changeStatus(){
        System.out.println("nhap id cua san pham can cap nhat: ");
        String id = sc.nextLine();
        productManager.changeStatus(id);
    }


}
