package bt2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10)) ;
        for( int i = 0 ; i < arr.size(); i ++){
            if( arr.get(i) % 3 == 0){
                arr.remove(i);
            }
        }
        for (Integer a : arr){
            System.out.println(a);
        }

    }
}
