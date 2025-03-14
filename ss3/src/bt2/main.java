package bt2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("nhap gia tri cua 3 so a,b,c: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if(a>b && a>c){
            System.out.printf("so lon nhat trong ba so la a: %d ", a);
        } else if (b>a && b>c) {
            System.out.printf("so lon nhat trong ba so la b: %d ", b);
        } else {
            System.out.printf("so lon nhat trong ba so la c: %d ", c);
        }
    }
}
