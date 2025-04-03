package bt3;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("for", 4);
        map.put("six", 6);
        for(Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println("Key: " + e.getKey() + "= Value: " + e.getValue());
        }
        System.out.println("--------------------------------");
        map.put("one",10);
        for(Map.Entry<String,Integer> e : map.entrySet()){
            System.out.println("Key: " + e.getKey() + "= Value: " + e.getValue());
        }
        map.remove("three");
        System.out.println("--------------------------------");
        for(Map.Entry<String,Integer> e : map.entrySet()){
            System.out.println("Key: " + e.getKey() + "= Value: " + e.getValue());
        }

    }
}
