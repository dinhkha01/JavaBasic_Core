package bt1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("a","","c","","d"));
        Predicate<String> checkHollow = String::isBlank;
        list.removeIf(checkHollow);
        System.out.println(list);
    }
}
