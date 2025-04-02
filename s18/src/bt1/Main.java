package bt1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> students = new HashMap<>();
        students.put("a",1);
        students.put("b",1);
        students.put("v",6);
        students.put("c",2);
        students.put("n",3);
        System.out.println(students);
        System.out.println(students.get("a"));


    }
}
