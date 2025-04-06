package bt1;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> arrNum = Stream.of(1,2,3,4,5,6,7,8,9,10).filter(num -> num%2 ==0 ).toList();
        arrNum.forEach(System.out::println);


    }
}
