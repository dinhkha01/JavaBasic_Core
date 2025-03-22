package bt3;

public class Bike extends Vehicle{
    public Bike(String name, int speed){
        super(name, speed);
    }

    @Override
    void displayInfo() {
        System.out.println("Name: " + super.getName() + " Speed: " + super.getSpeed());
    }
}
