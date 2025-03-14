package bt7;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("nhập thời gian bắt đầu (giờ -> phút -> giây) ");
        int startHour= sc.nextInt();
        int startMinus= sc.nextInt();
        int startSecond= sc.nextInt();
        System.out.printf("nhập thời gian thêm vào như trên");
        int addHour= sc.nextInt();
        int addMinus= sc.nextInt();
        int addSecond= sc.nextInt();

        int sumTime = startHour*3600+ startMinus*60 + startSecond + addHour*3600 + addMinus*60 + addSecond;

        int hour= sumTime / 3600;
        int minus= sumTime % 3600 / 60;
        int second= sumTime % 60;


        System.out.printf(hour+ "h" + minus + "p" + second+ "s");
    }
}
