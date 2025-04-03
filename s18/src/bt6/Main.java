package bt6;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> students = new LinkedHashMap<>();
        students.put("Chris", 8);
        students.put("Anna", 4);
        students.put("Jenny", 5);
        students.put("David", 3);
        students.put("Sarah", 9);
        students.put("Emma", 6);
        students.put("Michael", 2);
        students.put("Olivia", 10);
        students.put("Sophia", 1);
        students.put("William", 7);
        for (Map.Entry<String,Integer> entry : students.entrySet()){
            System.out.println(entry.getKey()+ " = " + entry.getValue());
        }
        int sum=0 ;
        for (Map.Entry<String, Integer> entry : students.entrySet()){
            sum+= entry.getValue();
        }
        System.out.println(" diem tb cac sv la: "+ sum/students.size());


        Iterator<Map.Entry<String, Integer>> iterator = students.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() < 5) {
                iterator.remove();
            }
        }


        System.out.println("\nDanh sách sau khi xóa sv điểm <5:");
        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }






    }
}
