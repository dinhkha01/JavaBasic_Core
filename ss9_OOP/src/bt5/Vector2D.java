package bt5;

public class Vector2D {
    // Thuộc tính
    private double x;
    private double y;


    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Phương thức calculateMagnitude(): Tính độ dài của vector
    public double calculateMagnitude() {
        return Math.sqrt(x * x + y * y);
    }

    // Phương thức add(Vector2D v): Trả về vector tổng của vector hiện tại và v
    public Vector2D add(Vector2D v) {
        return new Vector2D(this.x + v.x, this.y + v.y);
    }

    // Phương thức subtract(Vector2D v): Trả về vector hiệu giữa vector hiện tại và v
    public Vector2D subtract(Vector2D v) {
        return new Vector2D(this.x - v.x, this.y - v.y);
    }

    // Phương thức dotProduct(Vector2D v): Tính tích vô hướng giữa vector hiện tại và v
    public double dotProduct(Vector2D v) {
        return this.x * v.x + this.y * v.y;
    }

    // Phương thức displayVector(): Hiển thị tọa độ của vector dưới dạng (x, y)
    public void displayVector() {
        System.out.println("(" + x + ", " + y + ")");
    }

}