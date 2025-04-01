package bt3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int n=-1;
        do{
            System.out.print("Enter a number (0 to stop): ");
             n = sc.nextInt();
             if(n!=0) arr.add(n);

        }while(n!= 0);
        int min = arr.getFirst();
        int max = arr.getFirst();
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i)< min){
                min = arr.get(i);
            }
            if(arr.get(i)> max){
                max = arr.get(i);
            }
        }
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }

}
