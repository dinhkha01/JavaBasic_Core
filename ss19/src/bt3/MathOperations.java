package bt3;

public class MathOperations {
    public static int add(int a, int b) {
        return a + b;
    }
    public static int subtract(int a, int b) {
        return a - b;
    }
    public static int multiply(int a, int b) {
        return a * b;
    }
    public static double divide(int a, int b) {
        if(a>b){
            return a / b;
        }else return b/a;
    }
}
