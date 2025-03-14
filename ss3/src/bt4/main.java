package bt4;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int n;
        do{
            System.out.printf("nhap vao 1 so ");
            Scanner sc = new Scanner(System.in);
             n = sc.nextInt();
             switch (n){
                 case 1:
                     System.out.println("chu nhat ");
                     break;
                 case 2:
                     System.out.println("thu hai ");
                     break;
                 case 3:
                     System.out.println("chu ba ");
                     break;
                 case 4:
                     System.out.println("thu tu ");
                     break;
                 case 5:
                     System.out.println("chu nam ");
                     break;
                 case 6:
                     System.out.println("thu sau ");
                     break;
                 case 7:
                     System.out.println("chu bay ");
                     break;
                 default:
                     System.out.println("ket thuc roi");

             }
        }while(n<8 && n>0);
    }

}
