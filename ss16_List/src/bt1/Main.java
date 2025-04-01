package bt1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> arr = new ArrayList<Student>();
        Scanner sc = new Scanner(System.in);

        for (int i=0; i < 3; i++ ){
            Student stu = new Student();
            stu.inputData(sc);
            arr.add(stu);
        }
        for( int i =0; i < arr.size(); i++){
           arr.get(i).displayInfor();
        }

    }
}
