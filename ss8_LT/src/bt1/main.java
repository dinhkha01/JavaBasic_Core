package bt1;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap do dai cua mang");
        int n = sc.nextInt();
        while(n<0){
            System.out.print("do dai mang khong hop le, nhap lai de: ");
            n = sc.nextInt();
        }
        int[] arr = new int[n];
        int min = arr[0];
        int max = arr[0];
        for(int i =0 ; i < n; i++){
            System.out.printf("nhap phan tu thu %d cua mang",i+1 );
            arr[i] = sc.nextInt();
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.printf("gia tri lon nhat va nho nhat cua mang la: %d va %d " ,max, min);
    }
}
