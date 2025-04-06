package bt5;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Integer> normalList = List.of(10, 5, 8, 20, 7);
        List<Integer> singleElementList = List.of(10);
        List<Integer> allSameList = List.of(10, 10, 10);

        System.out.println("Danh sách bình thường:");
        findSecondLargest(normalList);

        System.out.println("\nDanh sách chỉ có 1 phần tử:");
        findSecondLargest(singleElementList);

        System.out.println("\nDanh sách các phần tử giống nhau:");
        findSecondLargest(allSameList);
    }

    public static void findSecondLargest(List<Integer> list) {
        Optional<Integer> secondLargest = list.stream()
                .distinct()                     // Loại bỏ phần tử trùng nhau
                .sorted((a, b) -> b - a)        // Sắp xếp giảm dần
                .skip(1)                        // Bỏ qua phần tử lớn nhất
                .findFirst();                   // Lấy phần tử đầu tiên (lớn thứ 2)

        // Sử dụng Optional để xử lý kết quả
        if (secondLargest.isPresent()) {
            System.out.println("Số lớn thứ hai là: " + secondLargest.get());
        } else {
            System.out.println("Không tìm thấy số lớn thứ hai");
        }
    }
}
