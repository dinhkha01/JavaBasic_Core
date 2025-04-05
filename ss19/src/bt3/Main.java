package bt3;

import java.util.Scanner;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap a,b");
        int a = sc.nextInt();
        int b = sc.nextInt();
        BiFunction<Integer,Integer,Integer> tong = MathOperations::add;
        BiFunction<Integer,Integer,Integer> h = MathOperations::subtract;
        BiFunction<Integer,Integer,Integer> tich = MathOperations::multiply;
        BiFunction<Integer,Integer,Double> thuong = MathOperations::divide;
        System.out.println("tong: " + tong.apply(a,b));
        System.out.println("tong: " + h.apply(a,b));
        System.out.println("tong: " + tich.apply(a,b));
        System.out.println("tong: " + thuong.apply(a,b));
    }
}
