package bt2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap vao do dai cua mang");
        int n = sc.nextInt();
        while(n < 0){
            System.out.print("do dai sai roi nhap lai de");
            n = sc.nextInt();
        }
        int[] arr = new int[n];
        boolean check = false;
        int sum = 0;
        for (int i = 0 ; i< n; i++){
            System.out.printf("nhap phan tu thu %d cua mang: ",i+1);
            arr[i]= sc.nextInt();
            if(arr[i] % 3 == 0){
                check = true;
                sum+= arr[i];
            }
        }
        if(check){
            System.out.printf("tong cac so chia het cho 3 la: %d", sum);
        }else{
            System.out.print("khong co so nao chia het cho 3");
        }

    }
}
