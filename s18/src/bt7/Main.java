package bt7;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = 0;

        while (true) {
            System.out.print("Nhập số lượng phần tử N (số nguyên dương): ");
            N = Integer.parseInt(scanner.nextLine());
            if (N > 0) {
                break;
            } else {
                System.out.println("Lỗi: N phải là số nguyên dương. Vui lòng nhập lại!");
            }
        }

        int[] arr = new int[N];
        System.out.println("Nhập các giá trị của mảng:");
        for (int i = 0; i < N; i++) {
            while (true) {
                System.out.printf("arr[%d] = ", i);
                arr[i] = Integer.parseInt(scanner.nextLine());
                break;
            }
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        System.out.println("\nCác phần tử và số lần xuất hiện:");
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " lần");
        }

        System.out.println("\nSắp xếp theo số lần xuất hiện tăng dần:");
        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort((e1, e2) -> e1.getValue() - e2.getValue());

        for (Map.Entry<Integer, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " lần");
        }
    }
}