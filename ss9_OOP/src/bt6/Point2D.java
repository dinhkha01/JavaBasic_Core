package bt6;

public class Point2D {

    private double x;
    private double y;


    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }


    public void setX(double x) {
        this.x = x;
    }


    public void setY(double y) {
        this.y = y;
    }

    // Phương thức distanceTo: Tính khoảng cách Euclid giữa điểm hiện tại và một điểm khác p
    public double distanceTo(Point2D p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }

    // Phương thức displayPoint(): Hiển thị tọa độ của điểm dưới dạng (x, y)
    public void displayPoint() {
        System.out.println("(" + x + ", " + y + ")");
    }
}