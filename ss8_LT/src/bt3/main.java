package bt3;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String email,password;
        String regexEmail = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        String regexPass= "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!#%*?&]{6,20}$";
        System.out.print("nhap email: ");
        do{
             email = sc.nextLine();
            if(email.matches(regexEmail)){
                System.out.println("Email hop le");
                break;
            } else{
                System.out.print("emai khong hop le nhap lai di: ");

            }
        }while(!email.matches(regexEmail));
        System.out.print("nhap pass: ");
        do{
            password = sc.nextLine();
            if(password.matches(regexPass)){
                System.out.println("password hop le");
                break;
            }else{
                System.out.print("password khong hop le nhap lai di: ");
            }
        }while(!password.matches(regexPass));

        System.out.printf("emai: %s\n password: %s \n hop le!! ", email,password);
    }
}
