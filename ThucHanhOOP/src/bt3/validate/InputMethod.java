package bt3.validate;

import java.util.Scanner;

public class InputMethod {
    public static String inputString(Scanner sc , String title, String error){
        System.out.println(title);
        while(true){
            String input = sc.nextLine();
            if(!input.isBlank()){
                return input;
            }
            System.out.println(error);
        }
    }
    public static int inputInt(Scanner sc, String error){
        do{
            if(!sc.hasNextInt()){
                System.err.println(error);
                sc.nextLine();
                continue;
            }
            return Integer.parseInt(sc.nextLine());
        }while(true);
    }
    public static float inputFloat(Scanner sc, String error){
        do{
            if(!sc.hasNextFloat()){
                System.err.println(error);
                sc.nextLine();
                continue;
            }
            return Float.parseFloat(sc.nextLine());
        }while(true);
    }

    public static boolean inputBoolean (Scanner sc, String title,String error ){
        System.out.println(title);
        while(true){
            String input = sc.nextLine();
            if(input.equals("true") || input.equals("false") ) return input.equals("true");
            System.err.println(error);
        }
    }
}
