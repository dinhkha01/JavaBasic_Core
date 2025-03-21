package bt5;

public class test {
    public static void main(String[] args) {
        Circle c1= new Circle(3.5);
        Cylinder cy1 = new Cylinder(3.7,4.6);
        System.out.print("dien tich hinh tron: "+ c1.getArea()+ "\n the tich hinh tru: "+ cy1.getVolume());

        c1.setRadius(2.5);
        cy1.setRadius(6);
        System.out.print("\nSau khi thay doi\n");
        System.out.print("dien tich hinh tron: "+ c1.getArea()+ "\n the tich hinh tru: "+ cy1.getVolume());

    }
}
