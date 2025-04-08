package bt2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        File file = new File("src/bt2/"+name+".txt");
        if(!file.exists()){
            file.createNewFile();
            System.out.println("da tao tep");
        }else {
            System.out.println("da co tep : "+ name + ".txt" );

        }

    }
}
