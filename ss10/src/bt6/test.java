package bt6;

public class test {
    public static void main(String[] args) {

        MoveablePoint m1 = new MoveablePoint(5,4,6,8);
        m1.toStringg();
        m1.move();
        System.out.print("sau khi di chuyen\n");;
        m1.toStringg();
        m1.setX(8);
        m1.toStringg();

    }
}
