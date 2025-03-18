package bt5;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap chuoi bat ki");
        String str = sc.nextLine();
        str = str.trim();
        String[] words = str.split(" ");
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < words.length; i++){
            StringBuffer b = new StringBuffer(words[i]);
            b.reverse();
            result.append(b);
            result.append(" ");

        }
        System.out.println(result);
    }

}
