package bt5;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 100);
        map.put("banana", 200);
        map.put("orange", 500);
        map.put("du du", 900);
        map.put("la du du", 1600);
        Map<String, Integer> filterMap = new HashMap<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() >=500 && entry.getValue() <=1500){
                filterMap.put(entry.getKey(), entry.getValue());
            }
        }
        Map<String, Integer> sortedMap = new TreeMap<>((a,b)-> filterMap.get(a)- filterMap.get(b));
        sortedMap.putAll(filterMap);

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println("Tên sản phẩm: " + entry.getKey() + " - Giá: " + entry.getValue() + "");
        }



    }
}
