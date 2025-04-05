package bt5;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập danh sách chuỗi (cách nhau bằng dấu phẩy):");
        String input = scanner.nextLine();
        List<String> list = Arrays.stream(input.split(",")).map(String::trim).toList();
        long count = list.stream().filter(s -> s.startsWith("A") && s.length()>=5).count();
        System.out.println(count);

    }
}
