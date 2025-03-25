package bt6;

public class FullTimeEmployee extends  Employee {
    private int thuong;

    public FullTimeEmployee(String name, int age, double salary, int thuong) {
        super(name, age, salary);
        this.thuong = thuong;
    }

    public double getThuong() {
        return thuong;
    }

    public void setThuong(int thuong) {
        this.thuong = thuong;
    }

    @Override
    double calculateSalary() {
        return getSalary() + thuong;
    }
    @Override
    String showInfo() {
        return "Full " + super.showInfo() + ", thuong la: " + thuong;
    }
}
