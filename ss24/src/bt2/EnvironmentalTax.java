package bt2;

public class EnvironmentalTax implements ITaxCalculator{
    @Override
    public double calculateTax(double amount) {
        return amount * 0.05;
    }
}
