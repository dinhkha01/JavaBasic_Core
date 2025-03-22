package bt3;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car("car", 132876);
        Vehicle bike = new Bike("bike", 123456);
        car.start();
        car.displayInfo();
        bike.start();
        bike.displayInfo();
    }
}
