package bt4.validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputMehod {
    public static String inputString (Scanner sc , String title, String error) {
        while (true) {
            System.out.println(title);
            String input = sc.nextLine();
            if (!input.isBlank()) {
                return input;
            }
            System.out.println(error);
        }
    }
    public static float inputFloat (Scanner sc , String title, String error) {
        do {
            System.out.println(title);
            if(!sc.hasNextFloat()){
                System.out.println(error);
                sc.nextLine();
                continue;
            }
            return  Float.parseFloat(sc.nextLine());
        }while (true);
    }
    public static int inputInt (Scanner sc , String title, String error) {
        do {
            System.out.println(title);
            if(!sc.hasNextInt()){
                System.out.println(error);
                sc.nextLine();
                continue;
            }
            return  Integer.parseInt(sc.nextLine());
        }while (true);
    }
    public static boolean inputBoolean (Scanner sc , String title, String error) {
        while(true){
            System.out.println(title);
            String input = sc. nextLine();
            if(input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")){
                    return input.equalsIgnoreCase("true");
            }
            System.out.println(error);

        }
    }
    public static Date inputDate(Scanner sc, String title, String error) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); // Không chấp nhận ngày không hợp lệ (ví dụ: 31/02/2023)

        while (true) {
            System.out.println(title);
            String input = sc.nextLine();

            try {
                Date date = dateFormat.parse(input);
                return date;
            } catch (ParseException e) {
                System.out.println(error);
            }
        }
    }


}
