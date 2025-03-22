package bt5;

public class Circle implements Colorable {
    private String color;
    private int radius;
    public Circle(int radius){
        this.radius = radius;
        this.color = "chua co mau";
    }

    public String getColor() {
        return color;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
        System.out.println("Circle mau:  "+ color);
    }
}
