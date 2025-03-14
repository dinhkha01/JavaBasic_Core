package bt1;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n ;
        System.out.print("nhap so nguyen duong n: ");
        n=sc.nextInt();
        while(n<=0){
            System.out.print("nhap lai so nguyen duong n: ");
            n = sc.nextInt();
        }
        int sum=0;
        for (int i=1 ; i <= n ; i++) {
            sum += i;
        }
        System.out.println("tong tu 1 den N la "+ sum);

    }
}
