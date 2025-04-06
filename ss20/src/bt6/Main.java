package bt6;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo danh sách
        List<String> items = List.of("apple", "banana", "apple", "orange", "banana", "apple");

        // In thời điểm bắt đầu chương trình
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String startTime = LocalDateTime.now().format(formatter);
        System.out.println("Thời điểm thực thi: " + startTime);

        System.out.println("\nSố lần xuất hiện của từng phần tử:");

        // Sử dụng Stream API để đếm số lần xuất hiện
        Map<String, Long> countMap = items.stream()
                .collect(Collectors.groupingBy(
                        item -> item,
                        Collectors.counting()
                ));

        // In kết quả
        countMap.forEach((item, count) ->
                System.out.println(item + ": " + count + " lần")
        );
    }
}
