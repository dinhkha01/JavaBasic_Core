package bt1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        File file = new File("src/bt1/out.txt");
        if(!file.exists()){
            file.createNewFile();
        } else {
            System.out.println("tep da ton tai");
        }
        try{
            Files.write(Paths.get("src/bt1/out.txt"), Arrays.asList(str));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        try{
            List<String> lines = Files.readAllLines(Paths.get("src/bt1/out.txt"));
            for (String line: lines){
                System.out.println(line);

            }        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
