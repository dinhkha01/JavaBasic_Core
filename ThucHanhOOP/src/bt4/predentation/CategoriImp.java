package bt4.predentation;

import bt4.business.CategoriManager;
import bt4.entity.Categories;

import java.util.Scanner;

public class CategoriImp {
     static CategoriManager categoriManager = new CategoriManager();
     static Scanner sc = new Scanner(System.in);
    public void menuCategori(){
        while(true){
            System.out.println("1. Thêm mới danh mục");
            System.out.println("2. Hiển thị danh sách danh mục");
            System.out.println("3. Cập nhật danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Thay đoi trạng thái danh mục");
            System.out.println("6. Thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    addCategori();
                    break;
                case 2:
                    categoriManager.showAllCate();
                    break;
                case 3:
                    break;
                case 4:
                    deleteCate();
                    break;
                case 5:
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không h��p lệ! Vui lòng nhập lại.");

            }
        }
    }
    public static void addCategori(){
        System.out.println("nhap so danh muc muon them vao: ");
        int n = Integer.parseInt(sc.nextLine());
        for(int i=0 ; i< n; i++){
            categoriManager.addCategories(sc);
        }
    }
    public static void deleteCate(){
        System.out.println("Nhap ID can cua danh muc can xoa");
        int id = Integer.parseInt(sc.nextLine());
        categoriManager.deleteCategories(id);
    }

}
