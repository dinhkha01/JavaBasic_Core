package bt3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        for(int i =0; i< 10 ; i++){
            set.add(i);
        }
        set.removeIf(in -> in % 3 ==0);
        System.out.println(set);
    }
}
