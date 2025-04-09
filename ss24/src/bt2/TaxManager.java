package bt2;

import java.util.ArrayList;
import java.util.List;

public class TaxManager {
    private List<ITaxCalculator> taxCalculators;

    public TaxManager() {
        this.taxCalculators = new ArrayList<>();
    }

    public void addTaxCalculator(ITaxCalculator calculator) {
        taxCalculators.add(calculator);
    }

    public double calculateTotalTax(double amount) {
        double totalTax = 0;
        for (ITaxCalculator calculator : taxCalculators) {
            totalTax += calculator.calculateTax(amount);
        }
        return totalTax;
    }
}
