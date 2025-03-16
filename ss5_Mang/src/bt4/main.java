package bt4;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap do dai cua mang");
        int n= sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i< n ;i++ ){
            System.out.printf("nhap phan tu thu %d cua mang ", i+1);
            arr[i]= sc.nextInt();

        }
        System.out.printf("mang dao nguoc la :");
        for(int i = n-1 ; i>=0 ; i--){
            System.out.print(arr[i]+" ");
        }
    }
}
