package bt6;

public class Intern extends Employee{

    public Intern(String name, int age, double salary) {
        super(name, age, salary);
    }
    @Override
    double calculateSalary() {
        return getSalary();
    }
    @Override
    String showInfo() {
        return "Intern " + super.showInfo();
    }
}
