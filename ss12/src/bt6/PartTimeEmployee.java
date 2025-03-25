package bt6;

public class PartTimeEmployee extends  Employee {
    private int time;
    public PartTimeEmployee(String name, int age, double salary, int time) {
        super(name, age, salary);
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    @Override
    double calculateSalary() {
        return getSalary() * time;
    }
    @Override
    String showInfo() {
        return "Part "+  super.showInfo() + "\nTime: " + time;
    }
}
