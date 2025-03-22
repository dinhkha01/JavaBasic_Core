package bt5;

public class Square implements Colorable {
    private String color;
    private int height;
    public Square(int height){
        this.height = height;
        this.color = "chua co mau";
    }

    @Override
    public void setColor(String color) {
        this.color = color;
        System.out.println("Square mau:  "+ color);
    }
}
