package bt4;

public class Circle implements Shape{
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
     return Math.PI * Math.pow(radius, 2);
    }
}
