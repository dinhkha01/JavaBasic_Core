package bt4;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        boolean a,b,c,condition1,condition2,condition3;
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap gia tri true or false cho ca 3 bien a,b,c : ");
        a= sc.nextBoolean();
        b= sc.nextBoolean();
        c= sc.nextBoolean();
        condition1 = a && b ;
        condition2 = a || b;
        condition3 = !c;
        System.out.println(condition1 ? "a va b dung":"a hoac b sai");
        System.out.println(condition2 ? "trong a va b co 1 gia tri dung":"a va b sai");
        System.out.println(condition3 ? "phu dinh cua c dung":"phu dinh cua c sai");
    }
}
