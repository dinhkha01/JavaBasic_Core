package bt6;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("nhap vao so n: ");
        int n = sc.nextInt();
        int sum=0;
        while(n>0){
            int temp= n%10;
            sum+= temp;
            n= n/10;
        }
        System.out.printf("tong la : %d ",sum);

    }
}
