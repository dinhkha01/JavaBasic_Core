package bt5_6;

import java.util.Scanner;

public class main {
    public static int choice;
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
    menu();
    }
    public static void menu(){
        do{

            System.out.println("-----------------------------Menu----------------------------------");
            System.out.println("1.Xử lí chuỗi");
            System.out.println("2.Xử lí số");
            System.out.println("3.Thoát");
            System.out.println("Chọn 1-3" );
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    menu1();
                    break;
                case 2:
                    menu2();
                    break;
                case 3:
                    System.out.println("Thoát");
                    break;
                default:
                    System.out.println("Chọn sai. Vui lòng chọn lại.");
            }

        }while(choice != 3);
    }
    public static void menu1(){
        String str="";
        do{

            System.out.println("-----------------------------Xử ly chuỗi----------------------------------");
            System.out.println("1.nhập chuỗi");
            System.out.println("2.Loại bỏ khoản trắng");
            System.out.println("3.Đếm số lần xuất hiện của từng ký tụ");
            System.out.println("4.Chuyển đổi thành dạng chuan (viet hoa chu cai dau cua moi tu)");
            System.out.println("5.Quay lai menu chinh");
            System.out.println("Chọn 1-5" );
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    System.out.print("nhap chuoi bat ki");
                     str = sc.nextLine();
                    System.out.printf("chuoi da nhap la:  %s\n",str);
                    break;
                case 2:
                    if (str.isEmpty()) {
                        System.out.println("Chuỗi rỗng, vui lòng nhập chuỗi trước (chọn 1)");

                    } else {
                        str = str.trim().replaceAll("\\s+", " ");
                        System.out.printf("chuoi sau khi loai bo het khoang trang thua: %s\n", str);

                    }
                    break;
                case 3:
                    if (str.isEmpty()) {
                        System.out.println("Chuỗi rỗng, vui lòng nhập chuỗi trước (chọn 1)");
                    } else {
                        // Tạo một mảng để lưu trữ các ký tự đã đếm
                        char[] chars = str.toCharArray();
                        // Mảng boolean để đánh dấu ký tự đã được đếm hay chưa
                        boolean[] counted = new boolean[chars.length];


                        for (int i = 0; i < chars.length; i++) {
                            // Nếu ký tự chưa được đếm
                            if (!counted[i]) {
                                // Lấy ký tự hiện tại
                                char currentChar = chars[i];
                                // Biến đếm số lần xuất hiện
                                int count = 1;
                                // Đánh dấu ký tự này đã được đếm
                                counted[i] = true;

                                // Kiểm tra các ký tự còn lại trong chuỗi
                                for (int j = i + 1; j < chars.length; j++) {
                                    // Nếu tìm thấy ký tự giống với ký tự hiện tại
                                    if (chars[j] == currentChar && !counted[j]) {
                                        // Tăng số lần đếm
                                        count++;
                                        // Đánh dấu ký tự này đã được đếm
                                        counted[j] = true;
                                    }
                                }
                                System.out.printf("'%s': %d lần\n", currentChar, count);
                            }
                        }
                    }
                    break;
                case 4:

                    if (str.isEmpty()) {
                        System.out.println("Chuỗi rỗng, vui lòng nhập chuỗi trước (chọn 1)");
                    } else {
                        // Loại bỏ khoảng trắng thừa ở đầu, cuối và giữa các từ
                        str = str.trim().replaceAll("\\s+", " ");
                        StringBuilder result = new StringBuilder();
                        // Biến để đánh dấu ký tự tiếp theo có cần viết hoa không
                        boolean capitalizeNext = true;

                        // Duyệt từng ký tự trong chuỗi
                        for (int i = 0; i < str.length(); i++) {
                            // Lấy ký tự tại vị trí i
                            char c = str.charAt(i);

                            // Nếu ký tự là khoảng trắng
                            if (Character.isWhitespace(c)) {
                                // Đánh dấu ký tự tiếp theo cần viết hoa (vì sau khoảng trắng là từ mới)
                                capitalizeNext = true;
                                // Thêm khoảng trắng vào kết quả
                                result.append(c);
                            }
                            // Nếu ký tự cần viết hoa (là ký tự đầu của từ)
                            else if (capitalizeNext) {
                                // Thêm ký tự viết hoa vào kết quả
                                result.append(Character.toUpperCase(c));
                                // Đã xử lý xong ký tự đầu, các ký tự sau không cần viết hoa
                                capitalizeNext = false;
                            }
                            // Các ký tự còn lại trong từ
                            else {
                                // Thêm ký tự viết thường vào kết quả
                                result.append(Character.toLowerCase(c));
                            }
                        }

                        // Cập nhật chuỗi ban đầu bằng chuỗi kết quả đã xử lý
                        str = result.toString();
                        // Hiển thị chuỗi sau khi xử lý
                        System.out.printf("Chuỗi sau khi chuyển đổi thành dạng chuẩn: %s\n", str);
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Chọn sai. Vui lòng chọn lại.");
            }

        }while(choice != 5);
    }
    public static void menu2(){
        int n=0 ;
        int[] arr = new int[n];
        do{
            System.out.println("-----------------------------Xử ly chuỗi----------------------------------");
            System.out.println("1.nhập mãng số nguyên");
            System.out.println("2.Tìm số lớn nhất");
            System.out.println("3.Đếm số phần tử có chữ số đầu tiên là số lẻ");
            System.out.println("4.Kiểm tra mảng đối xứng");
            System.out.println("5.Quay lai menu chinh");
            System.out.println("Chọn 1-5" );
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("nhap do dai cua mang");
                    n = sc.nextInt();
                    arr = new int[n];
                    for(int i =0 ; i < n; i++){
                        System.out.printf("nhap phan tu thu %d:  ",i+1);
                        arr[i] = sc.nextInt();
                    }
                    System.out.println("mang da nhap la");
                    for(int i =0 ; i < n; i++){
                        System.out.printf("phan tu thu %d: %d \n ",i+1, arr[i]);
                    }

                    break;
                case 2:
                    if(n == 0){
                        System.out.println("chua co phan tu trong mang (chon 1)");
                    }else {
                        int max = arr[0];
                        for(int i = 0; i< n;i++ ){
                            if(max < arr[i]){
                                max = arr[i];
                            }
                        }
                        System.out.printf("so lon nhat trong mang la: %d\n", max);
                    }
                    break;
                case 3:
                    if(n == 0) {
                        System.out.println("chua co phan tu trong mang (chon 1)");
                    } else {
                        int count=0;
                        for(int i =0 ; i< n; i++){
                            if (arr[i] < 0) {
                                arr[i] = Math.abs(arr[i]);
                            }

                            while (arr[i] >= 10) {
                                arr[i] /= 10;
                            }
                            if (arr[i] % 2 != 0){
                                count++;
                            }
                        }
                        System.out.printf("so phan tu co chu so dau tien la so le la: %d\n", count);
                    }
                    break;
                case 4:
                    if(n == 0) {
                        System.out.println("chua co phan tu trong mang (chon 1)");
                    } else {
                        boolean check = true;
                        for(int i =0 ; i < n/2; i++){
                            if(arr[i] != arr[n-1-i]){
                                check = false;
                                break;
                            }
                        }
                        if(check){
                            System.out.println("mang la doi xung");
                        } else {
                            System.out.println("mang khong la doi xung");
                        }

                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Chọn sai. Vui lòng chọn lại.");
            }

        }while(choice != 5);

    };
}
