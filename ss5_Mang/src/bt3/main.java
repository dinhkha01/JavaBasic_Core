package bt3;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("nhap do dai cua mang");
    int n = sc.nextInt();
    int[] arr= new int[n];
    System.out.println("nhap phan tu cho mang  ");
    int count =0;
    for(int i=0; i< n;i++){
        System.out.printf("nhap phan tu thu %d cua mang:  ", i+1);
        arr[i]= sc.nextInt();
        if(arr[i] % 2 == 0){
            count++;
        }
    }
    System.out.println("so phan tu chan trong mang la: " + count);
    }
}