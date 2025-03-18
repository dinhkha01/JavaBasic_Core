package bt4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap chuoi bat ki");
        String str = sc.nextLine();


        StringBuilder sb = new StringBuilder(str.toLowerCase());
        String str2 = sb.reverse().toString();
       if(str.toLowerCase().equals(str2)){
           System.out.println("la chuoi doi xung ");
       }else {
           System.out.println("khong phai la chuoi doi xung ");
       }
    }
}
