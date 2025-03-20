package bt4;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.getArea();
        c1.getCircumference();
        c1.display();
        System.out.print("nhap ban kinh cua hinh tron de");
        Scanner sc = new Scanner(System.in);
        double bk = sc.nextDouble();
        Circle c2 = new Circle(bk);
        c2.getArea();
        c2.getCircumference();
        c2.display();

    }

}
