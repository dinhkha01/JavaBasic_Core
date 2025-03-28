package hackthon.validate;

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


}
