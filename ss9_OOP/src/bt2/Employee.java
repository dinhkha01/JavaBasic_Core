package bt2;

public class Employee{
    int id;
    String name;
    String department;
    double salary;
    public Employee(int id, String name, String department, double salary){
        this.id =id;
        this.name = name;
        this.department =department;
        this.salary=salary;
    }
    public  void displayInfo(){
        System.out.printf("Ma: %d || ten: %s || phong ban: %s \n",id,name, department);
    }
    public double getter(){
        return salary;
    }
    public void setter(double salary){
        this.salary = salary;
    }
    public void increaseSalary(double parcentage){
        double persenSalary = salary * parcentage;
        salary += persenSalary;
        System.out.print("luong sau khi tang la: " + salary);
    }


}
