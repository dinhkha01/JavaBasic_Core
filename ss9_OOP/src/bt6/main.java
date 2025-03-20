package bt6;

public class main {
    public static void main(String[] args) {

        Point2D point1 = new Point2D(3.0, 4.0);
        Point2D point2 = new Point2D(7.0, 1.0);


        System.out.println("Tọa độ điểm 1:");
        point1.displayPoint();

        System.out.println("Tọa độ điểm 2:");
        point2.displayPoint();

        // Tính khoảng cách giữa hai điểm và hiển thị kết quả
        double distance = point1.distanceTo(point2);
        System.out.println("Khoảng cách giữa hai điểm: " + distance);

        // Cập nhật tọa độ của một điểm và hiển thị lại tọa độ mới
        System.out.println("\nCập nhật tọa độ điểm 1 thành (5.0, 6.0)");
        point1.setX(5.0);
        point1.setY(6.0);

        System.out.println("Tọa độ mới của điểm 1:");
        point1.displayPoint();

        // Tính lại khoảng cách sau khi cập nhật tọa độ
        distance = point1.distanceTo(point2);
        System.out.println("Khoảng cách mới giữa hai điểm: " + distance);
    }
}
