package bt1.validate;

import java.util.Scanner;

public class InputMethod {

    public static String inputString(Scanner sc, String title, String error){
        while (true){
            System.out.println(title);
            String input = sc.nextLine();
            if( !input.isBlank()){
                return input;
            }
            System.err.println(error);
        }
    };

  public static float inputFloat(Scanner sc, String error){
      do {
          if(!sc.hasNextFloat()){
              System.err.println(error);
              sc.nextLine();
              continue;
          }
          return Float.parseFloat(sc.nextLine());
      } while (true);



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
}
