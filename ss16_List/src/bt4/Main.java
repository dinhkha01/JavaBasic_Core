package bt4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int n=-1;
        int sum=0;
        do{
            System.out.print("Enter a number (0 to stop): ");
            n = sc.nextInt();
            if(n!=0) {
                sum +=n;
                arr.add(n);
            }


        }while(n!= 0);
        System.out.println("Cac so da nhap la");
        for(int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }
        System.out.println("Tong cac so da nhap la: " + sum);

    }

}
