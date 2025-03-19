package bt2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap email vao");
        String email = sc.nextLine();
        String regex = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,}$";

        if(email.matches(regex)){
            System.out.print("email hop le");
        } else{
            System.out.print("email khong hop le");
        }


    }
}
