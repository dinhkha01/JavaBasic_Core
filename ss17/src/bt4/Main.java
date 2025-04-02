package bt4;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        for(int i = 10; i > 0; i--){
            set.add(i);
        }
        System.out.println(set);
    }

}
