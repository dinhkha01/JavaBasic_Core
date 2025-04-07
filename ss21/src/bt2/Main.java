package bt2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr ={1,2,3};
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao vi tri muon lay ");
        int n = sc.nextInt();
        try{
            System.out.println(arr[n]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());

        }
    }
}
