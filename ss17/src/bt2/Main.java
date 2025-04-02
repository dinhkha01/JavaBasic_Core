package bt2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("He");
        set.add("Wo");
        set.add("Kha");
        set.add("Iddddd");
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        if(set.contains(n)){
            System.out.println("co chua ");
        }else {
            System.out.println("khong chua");
        }

    }
}
