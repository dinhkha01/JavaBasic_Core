package bt5;

public class Rectangle implements  Colorable{
    private String color;
    private int width;
    public Rectangle(int width){
        this.width = width;
        this.color = "chua co mau";
    }

    @Override
    public void setColor(String color) {
        this.color = color;
        System.out.println("Rectangle mau:  "+ color);
    }
}
