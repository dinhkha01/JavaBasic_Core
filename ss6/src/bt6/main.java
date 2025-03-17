package bt6;

import java.util.Scanner;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap mat khau cua m di: ");
        String pass = sc.nextLine();
        validatePass(pass);
    }
    public static void validatePass(String pass){
        if(pass.length() < 6){
            System.out.print("mat khau phai  hon 6 ki tu");
            return;
        }
        if(!Pattern.compile("[A-Z]").matcher(pass).find()){
            System.out.print("mk phai chua ki tu in hoa");
            return;
        };
        if(!Pattern.compile("[a-z]").matcher(pass).find()){
            System.out.print("mk phai chua ki tu thuong");
            return;
        };
       if(!Pattern.compile("[0-9]").matcher(pass).find()){
           System.out.print("mk phai chua so");
           return;
       };
       if(!Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]").matcher(pass).find()){
           System.out.print("mk phai chua ki tu dac biet");
           return;

       };
       System.out.println("mat khau hop le");
       return;
    }
}
