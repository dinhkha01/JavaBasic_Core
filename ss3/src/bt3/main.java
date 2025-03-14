package bt3;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.printf("nhap vao diem so: ");
    float n = sc.nextFloat();
    if(n > 10){
        System.out.printf( "%f diem so khong hop le", n );

    } else if (n >= 9) {
        System.out.printf("Gioi" );
        
    } else if (n>=7.5) {
        System.out.printf("kha");
        
    } else if (n>=5.8) {
        System.out.printf("trau bo");
        
    } else {
        System.out.printf("ngu");
        
    }

    }
}
