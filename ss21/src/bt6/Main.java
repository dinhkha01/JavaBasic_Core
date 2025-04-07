package bt6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] arrString = {"1","2","helo","3","a"};
        int[] arrInt = new int[arrString.length];
        int count = 0;
        for( int i = 0 ; i < arrString.length; i ++){
            try {
                arrInt[count] = Integer.parseInt(arrString[i]);
                count++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input at index " + i + ": " + arrString[i]);
            }
        }
        arrInt= Arrays.copyOf(arrInt,count);
        for( int i = 0 ; i < arrInt.length; i ++){
            System.out.print(arrInt[i] + " ");
        }

    }
}
