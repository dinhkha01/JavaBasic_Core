package bt5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Nhập đoạn văn bản để tìm từ chứa ký tự đặc biệt:");
            String text = scanner.nextLine();

            // Regex để tìm các từ chứa ít nhất một ký tự đặc biệt
            // Từ được định nghĩa là chuỗi liên tiếp các ký tự không phải khoảng trắng
            String regex = "\\S*[^a-zA-Z0-9\\s]\\S*";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            // Đếm số lượng từ khớp trước để xác định kích thước mảng
            int count = 0;
            Matcher countMatcher = pattern.matcher(text);
            while (countMatcher.find()) {
                count++;
            }

            // Khởi tạo mảng với kích thước đúng
            String[] specialWords = new String[count];

            // Tìm lại các từ và lưu vào mảng
            int index = 0;
            while (matcher.find()) {
                specialWords[index] = matcher.group();
                index++;
            }

            // In kết quả
            if (count > 0) {
                System.out.print(count + " (Các từ chứa ký tự đặc biệt: ");

                // In các từ trong mảng, cách nhau bởi dấu phẩy
                for (int i = 0; i < specialWords.length; i++) {
                    System.out.print(specialWords[i]);
                    if (i < specialWords.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println(")");
            } else {
                System.out.println("0 (Không có ký tự đặc biệt)");
            }


        }
    }

