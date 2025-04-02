package bt5;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i = 1; i < 5 ; i++){
            set1.add(i);
            for(int j= 4 ; j < 9; j++){
                set2.add(j);
            }
        }
        Set<Integer> set = new HashSet<>(set1);
        set.addAll(set2);
        Set<Integer> sortSet= new TreeSet<>(set);
        System.out.println(sortSet);
    }
}
