package bt4;

public class main {
    public static void main(String[] args) {
        // Tạo chuỗi ban đầu có độ dài 1 triệu ký tự
        String initialString = "abcdefghij".repeat(100000);

        // Thực hiện và đo thời gian với StringBuilder
        System.out.println("StringBuilder Performance:");
        performStringBuilderOperations(initialString);

        // Thực hiện và đo thời gian với StringBuffer
        System.out.println("\nStringBuffer Performance:");
        performStringBufferOperations(initialString);
    }

    public static void performStringBuilderOperations(String initialString) {
        // Khởi tạo StringBuilder với chuỗi ban đầu
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(initialString);

        // 1. Đảo ngược chuỗi
        long reverseStartTime = System.currentTimeMillis();
        sb.reverse();
        long reverseEndTime = System.currentTimeMillis();
        System.out.println("Đảo ngược chuỗi: " + (reverseEndTime - reverseStartTime) + " ms");

        // 2. Chèn một chuỗi con vào vị trí bất kỳ
        long insertStartTime = System.currentTimeMillis();
        sb.insert(500000, "INSERTED_TEXT");
        long insertEndTime = System.currentTimeMillis();
        System.out.println("Chèn chuỗi con: " + (insertEndTime - insertStartTime) + " ms");

        // 3. Xóa một đoạn trong chuỗi
        long deleteStartTime = System.currentTimeMillis();
        sb.delete(200000, 300000);
        long deleteEndTime = System.currentTimeMillis();
        System.out.println("Xóa đoạn trong chuỗi: " + (deleteEndTime - deleteStartTime) + " ms");

        // 4. Thay thế một đoạn trong chuỗi
        long replaceStartTime = System.currentTimeMillis();
        sb.replace(400000, 450000, "REPLACED_TEXT");
        long replaceEndTime = System.currentTimeMillis();
        System.out.println("Thay thế đoạn trong chuỗi: " + (replaceEndTime - replaceStartTime) + " ms");

        long endTime = System.currentTimeMillis();
        System.out.println("Tổng thời gian: " + (endTime - startTime) + " ms");
    }

    public static void performStringBufferOperations(String initialString) {
        // Khởi tạo StringBuffer với chuỗi ban đầu
        long startTime = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer(initialString);

        // 1. Đảo ngược chuỗi
        long reverseStartTime = System.currentTimeMillis();
        sb.reverse();
        long reverseEndTime = System.currentTimeMillis();
        System.out.println("Đảo ngược chuỗi: " + (reverseEndTime - reverseStartTime) + " ms");

        // 2. Chèn một chuỗi con vào vị trí bất kỳ
        long insertStartTime = System.currentTimeMillis();
        sb.insert(500000, "INSERTED_TEXT");
        long insertEndTime = System.currentTimeMillis();
        System.out.println("Chèn chuỗi con: " + (insertEndTime - insertStartTime) + " ms");

        // 3. Xóa một đoạn trong chuỗi
        long deleteStartTime = System.currentTimeMillis();
        sb.delete(200000, 300000);
        long deleteEndTime = System.currentTimeMillis();
        System.out.println("Xóa đoạn trong chuỗi: " + (deleteEndTime - deleteStartTime) + " ms");

        // 4. Thay thế một đoạn trong chuỗi
        long replaceStartTime = System.currentTimeMillis();
        sb.replace(400000, 450000, "REPLACED_TEXT");
        long replaceEndTime = System.currentTimeMillis();
        System.out.println("Thay thế đoạn trong chuỗi: " + (replaceEndTime - replaceStartTime) + " ms");

        long endTime = System.currentTimeMillis();
        System.out.println("Tổng thời gian: " + (endTime - startTime) + " ms");
    }
}
