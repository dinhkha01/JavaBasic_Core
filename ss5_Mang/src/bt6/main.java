package bt6;

import java.util.Random;

public class main {
    public static void main(String[] args) {
        int[] markingArray = new int[1000];

        // Khởi tạo mảng originalArray với 20 giá trị ngẫu nhiên từ 1-1000
        int[] originalArray = new int[20];
        Random random = new Random();

        System.out.println("Mảng originalArray:");
        System.out.print("{");
        for (int i = 0; i < originalArray.length; i++) {
            // Sinh số ngẫu nhiên từ 1 đến 1000
            originalArray[i] = random.nextInt(1000) + 1;
            System.out.print(originalArray[i]);
            if (i < originalArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");

        // Duyệt qua từng phần tử của mảng originalArray
        // và đánh dấu tần suất xuất hiện vào mảng markingArray
        for (int i = 0; i < originalArray.length; i++) {
            markingArray[originalArray[i] - 1]++;
        }

        // Tìm tần suất xuất hiện lớn nhất
        int maxFrequency = 0;
        for (int i = 0; i < markingArray.length; i++) {
            if (markingArray[i] > maxFrequency) {
                maxFrequency = markingArray[i];
            }
        }

        // In ra phần tử xuất hiện nhiều nhất và số lần xuất hiện
        System.out.println("\nPhần tử xuất hiện nhiều nhất:");
        for (int i = 0; i < markingArray.length; i++) {
            if (markingArray[i] == maxFrequency) {
                // +1 vì index của mảng markingArray bắt đầu từ 0 nhưng giá trị thực từ 1
                System.out.println("Phần tử: " + (i + 1) + ", Số lần xuất hiện: " + maxFrequency);
            }
        }
    }
}
