package bt5;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("nhap do dai cua mang");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n ; i++){
            System.out.printf("phan tu thu %d", i+1);
            arr[i] = sc.nextInt();
        }
        int max= -1;
        int min = Integer.MAX_VALUE;
        boolean check = false;
        for(int i =0 ; i<n ; i++){
            if(arr[i] > 0 && arr[i] % 2 !=0){
                check = true;
                if(arr[i] > max){
                    max = arr[i];
                }
                if(arr[i] < min){
                    min = arr[i];
                }
            }

        }
        if(check){
            System.out.println("Gia tri nho nhat la: " + min);
            System.out.println("Gia tri lon nhat la: " + max);
        } else {
            System.out.println("Mang chua co phan tu le nao.");
        }
    }
}
