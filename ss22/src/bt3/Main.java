package bt3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str ;
        List<String> list = new ArrayList<>();
        while (true) {
            System.out.println("nhap tung dong (nhap 0 de dung)");
            str = sc.nextLine();
            if (str.equals("0")) {
                break;
            }
            list.add(str);
        }

        File file = new File("src/bt3/in.txt");
        File fileCoppy = new File("src/bt3/coppy.txt");
        if(!file.exists()){
             file.createNewFile();
             fileCoppy.createNewFile();
        }else {
            System.out.println("ok");
        }

        Files.write(Paths.get("src/bt3/in.txt"),list);
        try {
            String content = Files.readString(Paths.get("src/bt3/in.txt"));
            Files.writeString(Paths.get("src/bt3/coppy.txt"),content);
            String contentCoppy = Files.readString(Paths.get("src/bt3/coppy.txt"));
            System.out.println("da coppy: \n "+ contentCoppy);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }



    }
}
