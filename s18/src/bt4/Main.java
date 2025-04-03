package bt4;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("NV123", 1);
        map.put("NV234", 2);
        map.put("NV456", 4);
        map.put("NV567", 6);
        map.put("NV345", 3);


        for(Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println("Key: " + e.getKey() + "= Value: " + e.getValue());
        }
        System.out.println("--------------------------------");
        map.put("NV234",10);
        for(Map.Entry<String,Integer> e : map.entrySet()){
            System.out.println("Key: " + e.getKey() + "= Value: " + e.getValue());
        }
        map.remove("NV456");
        System.out.println("--------------------------------");
        for(Map.Entry<String,Integer> e : map.entrySet()){
            System.out.println("Key: " + e.getKey() + "= Value: " + e.getValue());
        }

    }
}
