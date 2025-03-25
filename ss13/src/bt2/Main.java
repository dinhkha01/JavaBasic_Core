package bt2;

public class Main {
    public static void main(String[] args) {
    double[] marks = {7.5,8,6.5};
        if (check(avg(marks))) {
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }

    }
    public static double avg(double[] marks){
        double avg=0;
        for(int i=0; i<marks.length; i++){
            avg += marks[i];
        }
        avg /= marks.length;
        return avg;
    }
    public static boolean check(double avg){
        if(avg >= 5){
            return true;
        }else
            return false;
    }
}
