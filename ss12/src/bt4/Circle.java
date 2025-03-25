package bt4;

public class Circle extends Shape{
    double radius;
    Circle(double radius) {
        this.radius = radius;
    }
    @Override
    double area() {
        return (int) (Math.PI * Math.pow(radius, 2));
    }
}
