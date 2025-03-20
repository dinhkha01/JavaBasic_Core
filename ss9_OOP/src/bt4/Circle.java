package bt4;

public class Circle {
    double radius;
    double cv,dt,pi=3.14;
    public Circle(){
        this.radius =1;
    };
    public Circle(double radius){
        this.radius = radius;
    }
    public void getArea(){
        dt= Math.pow(radius,2) * pi;
        System.out.println("dien tich hinh tron la: "+ dt);
    }
    public void getCircumference(){
        cv = 2 * radius * pi;
        System.out.println("chu vi hinh tron la: "+ cv);
    }
    public void display(){
        System.out.println("ban kinh: " + radius + " dien tich: " + dt +" chu vi: "+cv );
    }

}
