package bt3;

public class Rectangle {
    double length;
    double width;
    double Cv;
    double Dt;
    public Rectangle(){
        this.length =1;
        this.width = 1;
    }
    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }
    public void getArea() {
        Cv = (length + width)*2;
        System.out.println("Chu vi hinh chu nhat la: " + Cv);
    }
    public void getParameter(){
        Dt = length * width;
        System.out.println("Dien tich hinh chu nhat la: " + Dt);
    }
    public void display(){
        System.out.print("chieu dai: " + length + " chieu rong: " + width + " chu vi: "+ Cv +" dien tich: "+ Dt);
    }
}