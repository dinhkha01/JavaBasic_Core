package bt2;

import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap vao f(x): ");
        int x = Integer.parseInt(sc.nextLine());
        System.out.println("gia tri f(" + x + ") la");
        Function<Integer,Integer> calculate =  i -> i*i + i*3 + 2;
        System.out.println(calculate.apply(x));
    }

}
