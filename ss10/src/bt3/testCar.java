package bt3;

public class testCar {
    public static void main(String[] args) {
        Car car1= new Car("Honda","coyote",2020);
        System.out.println("Thông tin xe ban đầu:");
        System.out.println(car1.getMake()+ " " + car1.getModel() + " "+ car1.getYear());
        car1.setYear(2025);
        System.out.println("Thông tin xe sau khi thay đoi năm: " + car1.getMake() + " " + car1.getModel() + " " + car1.getYear());
        car1.setYear(2026);
    }
}
