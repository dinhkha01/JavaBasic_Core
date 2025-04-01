package bt6;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(3,3,3,3));
        System.out.println("Danh sách ban đầu: " + arr);
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        for(int i=0; i<arr.size(); i++){
            if(!arr2.contains(arr.get(i))){
                arr2.add(arr.get(i));
            }
        }
        System.out.println("Danh sách sau khi loại bo các phần tử trùng: " + arr2);
    }
}
