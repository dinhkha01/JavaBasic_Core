package bt2;

public class Main {
    public static void main(String[] args) {
        // Tạo các đối tượng tính thuế
        ITaxCalculator incomeTax = new IncomeTax();
        ITaxCalculator environmentalTax = new EnvironmentalTax();

        // Tạo TaxManager và thêm các loại thuế
        TaxManager taxManager = new TaxManager();
        taxManager.addTaxCalculator(incomeTax);
        taxManager.addTaxCalculator(environmentalTax);

        // Tính thuế với số tiền 10,000,000
        double amount = 10_000_000;
        double totalTax = taxManager.calculateTotalTax(amount);

        // In kết quả
        System.out.println("Tổng số tiền: " + amount);
        System.out.println("Thuế thu nhập (10%): " + incomeTax.calculateTax(amount));
        System.out.println("Thuế môi trường (5%): " + environmentalTax.calculateTax(amount));
        System.out.println("Tổng thuế phải nộp: " + totalTax);
        System.out.println("Tổng cộng sau thuế: " + (amount - totalTax));
    }
}
