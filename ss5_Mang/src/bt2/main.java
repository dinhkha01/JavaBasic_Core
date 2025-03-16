package bt2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap do dai cua mang");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("nhap cac phan tu cua mang");
        for(int i = 0 ; i<n; i++){
            System.out.printf("nhap phan tu thu %d cua mang", i+1);
            arr[i]= sc.nextInt();
        }
        int sum =0;
        for(int i =0; i < arr.length; i++){
            sum += arr[i];

        }
        System.out.printf("tong cac phan tu trong mang la: %d " , sum);
    }
}
