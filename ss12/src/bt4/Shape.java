package bt4;

public class Shape {
    double area(){
        return 0;
    }
    double area(double radius){
        return Math.PI * Math.pow(radius, 2);
    }
    double area(double length, double width){
        return length * width;
    }
}
