package bt1;

public class Main {
    public static void main(String[] args) {
        int firtsNumber=5;
        int secondNumber  = 5;
        int calculationResult = calculateSpecialSum(firtsNumber,secondNumber);
        System.out.println("Result: "+ calculationResult );
    }
    public static int calculateSpecialSum(int firtsNumber, int secondNumber){
     return firtsNumber * secondNumber + (firtsNumber+ secondNumber);
    }
}
