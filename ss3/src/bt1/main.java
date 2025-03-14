package bt1;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.printf("nhap vao so n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n%2==0){
            System.out.printf("%d so la so chan",n);
        }else {
            System.out.printf("%d la so le", n);
        }
    }
}
