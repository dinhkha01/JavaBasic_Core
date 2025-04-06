package bt2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> num = Stream.of(1,2,3,4,5,6,7,8,9,10).filter(n -> n % 2 ==0).toList();
        int sum = num.stream().reduce(0,Integer::sum);
        System.out.println("tong: "+ sum);
    }
}
