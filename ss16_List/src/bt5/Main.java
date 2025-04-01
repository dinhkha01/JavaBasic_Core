package bt5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(2);
        numbers.add(1);
        numbers.add(3);
        numbers.add(3);
        numbers.add(4);
        List<Integer> counted = new ArrayList<>();
        System.out.println("Số lần xuất hiện của từng phần tử:");
        for (int i = 0; i < numbers.size(); i++) {
            if (!counted.contains(numbers.get(i))) {
                int count = 0;
                // Đếm số lần xuất hiện
                for (int j = 0; j < numbers.size(); j++) {
                    if (numbers.get(j) == numbers.get(i)) {
                        count++;
                    }
                }
                System.out.println(numbers.get(i) + " : " + count + " lần");
                counted.add(numbers.get(i));
            }
        }
    }
    }

