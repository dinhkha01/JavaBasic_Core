package bt6;

public class MoveablePoint extends Point {
    private double xSpeed, ySpeed;

    public MoveablePoint(double x, double y, double xSpeed, double ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public double getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }

    public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void move(){
        setX(getX() + xSpeed);
        setY(getY() + ySpeed);
    }

    @Override
    public void toStringg() {
        System.out.println("Point: (" + getX() + ", " + getY() + ")"+ " with Speed: " +"("+ xSpeed + ","+ ySpeed +")");
    }
}
