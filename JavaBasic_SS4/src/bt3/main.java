package bt3;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.printf("nhap so nguyen duong");
        n = sc.nextInt();
        while(n <= 0){
            System.out.printf("nhap lai so nguyen duong: ");
            n = sc.nextInt();
        }
        for(int i =1; i <= 10; i++){
            System.out.printf(" %d X %d = %d \n",n,i, n*i);
        }
    }
}
