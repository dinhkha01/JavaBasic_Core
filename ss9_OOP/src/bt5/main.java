package bt5;

public class main {
    public static void main(String[] args) {
        Vector2D vector1 = new Vector2D(3.0, 4.0);
        Vector2D vector2 = new Vector2D(1.0, 2.0);
        System.out.println("Vector 1:");
        vector1.displayVector();
        System.out.println("Vector 2:");
        vector2.displayVector();
        System.out.println("\nĐộ dài của Vector 1: " + vector1.calculateMagnitude());
        System.out.println("Độ dài của Vector 2: " + vector2.calculateMagnitude());
        Vector2D sum = vector1.add(vector2);
        System.out.println("\nVector tổng (Vector 1 + Vector 2):");
        sum.displayVector();
        // Tính và hiển thị vector hiệu
        Vector2D difference = vector1.subtract(vector2);
        System.out.println("\nVector hiệu (Vector 1 - Vector 2):");
        difference.displayVector();
        // Tính và hiển thị tích vô hướng
        double dotProduct = vector1.dotProduct(vector2);
        System.out.println("\nTích vô hướng của Vector 1 và Vector 2: " + dotProduct);
    }
}
