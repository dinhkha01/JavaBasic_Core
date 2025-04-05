package bt6;

import java.util.List;

public interface StringProcessor {
    String processString(String input);

    // Phương thức mặc định in danh sách chuỗi
    default void printList(List<String> list) {
        System.out.println("Danh sách chuỗi sau xử lý:");
        list.forEach(System.out::println);
    }
}
