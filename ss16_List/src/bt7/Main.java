package bt7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,2,1,3,3,4,5));

        System.out.println("Danh sách ban đầu: " + numbers);

        // Tìm các phần tử chỉ xuất hiện đúng 1 lần
        List<Integer> uniqueElements = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            int count = 0;
            for (int j = 0; j < numbers.size(); j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    count++;
                }
            }
            if (count == 1 && !uniqueElements.contains(numbers.get(i))) {
                uniqueElements.add(numbers.get(i));
            }
        }
        System.out.println("\nCác phần tử xuất hiện đúng 1 lần: " + uniqueElements);

        //  Tìm các phần tử trùng lặp và số lần xuất hiện
        List<Integer> checkedElements = new ArrayList<>();
        System.out.println("\nCác phần tử trùng lặp và số lần xuất hiện:");
        for (int i = 0; i < numbers.size(); i++) {
            if (!checkedElements.contains(numbers.get(i))) {
                int count = 0;
                for (int j = 0; j < numbers.size(); j++) {
                    if (numbers.get(i).equals(numbers.get(j))) {
                        count++;
                    }
                }
                if (count > 1) {
                    System.out.println(numbers.get(i) + " : " + count + " lần");
                    checkedElements.add(numbers.get(i));
                }
            }
        }
    }
}
