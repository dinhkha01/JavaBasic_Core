package b7;

public class PartTimeEmployee extends Employee {
    int workingHours;
    public PartTimeEmployee(String name, int paymentPerHour, int workingHours) {
        super(name, paymentPerHour);
        this.workingHours = workingHours;
    }


    @Override
    public int calculateSalary() {
        return getPaymentPerHour() * workingHours;
    }

}
