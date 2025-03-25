package bt4;

public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng hình tròn với bán kính 5
        Circle circle = new Circle(5);

        // Tạo đối tượng hình chữ nhật với chiều rộng 4 và chiều cao 6
        Rectangle rectangle = new Rectangle(4, 6);

        // Tạo đối tượng Shape
        Shape shape = new Shape();

        // Kiểm tra phương thức được ghi đè (Overriding)
        System.out.println("===== KIỂM TRA OVERRIDING =====");
        System.out.println("Diện tích Shape mặc định: " + shape.area());
        System.out.println("Diện tích Circle (r=5): " + circle.area());
        System.out.println("Diện tích Rectangle (w=4, h=6): " + rectangle.area());

        // Kiểm tra phương thức được nạp chồng (Overloading)
        System.out.println("\n===== KIỂM TRA OVERLOADING =====");
        System.out.println("Diện tích hình tròn (r=3) từ Shape: " + shape.area(3));
        System.out.println("Diện tích hình chữ nhật (w=5, h=8) từ Shape: " + shape.area(5, 8));

        // Minh họa đa hình (Polymorphism)
        System.out.println("\n===== MINH HỌA ĐA HÌNH =====");
        Shape shapeCircle = new Circle(7);
        Shape shapeRectangle = new Rectangle(3, 9);

        System.out.println("Diện tích Circle thông qua biến Shape (r=7): " + shapeCircle.area());
        System.out.println("Diện tích Rectangle thông qua biến Shape (w=3, h=9): " + shapeRectangle.area());
    }
}
