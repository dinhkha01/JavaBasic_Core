package bt2;

public class IncomeTax implements ITaxCalculator{


    @Override
    public double calculateTax(double amount) {
        return amount * 0.1;
    }
}
