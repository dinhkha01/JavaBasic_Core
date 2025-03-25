package bt5;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[6];
        shapes[0] = new Circle( 3.0);
        shapes[1] = new Rectangle( 5.0, 2.0);
        shapes[2] = new Square( 4.0);
        shapes[3] = new Circle( 1.0);
        shapes[4] = new Rectangle( 7.0, 3.0);
        shapes[5] = new Square( 6.0);
        double sum = 0;
        for (Shape shape : shapes) {
            System.out.println("dien tich: " + shape.area());
            sum += shape.area();
        }
        System.out.println("tong dien tich: " + sum);


    }
}
