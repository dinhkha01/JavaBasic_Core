package bt2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("Laptop",1);
        map.put("Lapto",2);
        map.put("Lapt",3);
        map.put("Lap",4);
        map.put("La",5);
        if(map.containsKey("Laptop")){
            System.out.println("co");
        } else {
            System.out.println("khong");
        }
        if(map.containsValue(6)){
            System.out.println("co");
        } else {
            System.out.println("khong");
        }


    }
}
