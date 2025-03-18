package ss6;

public class main {
    private static final int ITERATIONS = 1_000_000;
    private static final String INITIAL_STRING = "Hello";
    private static final String APPEND_STRING = " World";

    public static void main(String[] args) {
        System.out.println("Bắt đầu so sánh hiệu suất nối chuỗi với " +
                ITERATIONS + " lần lặp:");
        System.out.println("-----------------------------------------------------");

        // Thực hiện với String
        long startTimeString = System.currentTimeMillis();
        String resultString = concatenateWithString();
        long endTimeString = System.currentTimeMillis();
        long durationString = endTimeString - startTimeString;

        // Thực hiện với StringBuilder
        long startTimeBuilder = System.currentTimeMillis();
        String resultBuilder = concatenateWithStringBuilder();
        long endTimeBuilder = System.currentTimeMillis();
        long durationBuilder = endTimeBuilder - startTimeBuilder;

        // Thực hiện với StringBuffer
        long startTimeBuffer = System.currentTimeMillis();
        String resultBuffer = concatenateWithStringBuffer();
        long endTimeBuffer = System.currentTimeMillis();
        long durationBuffer = endTimeBuffer - startTimeBuffer;

        // In kết quả
        System.out.println("Kết quả:");
        System.out.println("-----------------------------------------------------");
        System.out.println("String: " + durationString + " ms");
        System.out.println("StringBuilder: " + durationBuilder + " ms");
        System.out.println("StringBuffer: " + durationBuffer + " ms");
        System.out.println("-----------------------------------------------------");

        // So sánh hiệu suất
        System.out.println("\nSo sánh hiệu suất:");
        System.out.println("-----------------------------------------------------");

        // Tính toán tỉ lệ tăng tốc so với String
        double stringBuilderSpeedup = (double) durationString / durationBuilder;
        double stringBufferSpeedup = (double) durationString / durationBuffer;

        System.out.printf("StringBuilder nhanh hơn String khoảng %.2f lần\n", stringBuilderSpeedup);
        System.out.printf("StringBuffer nhanh hơn String khoảng %.2f lần\n", stringBufferSpeedup);

        if (durationBuilder < durationBuffer) {
            double builderVsBufferSpeedup = (double) durationBuffer / durationBuilder;
            System.out.printf("StringBuilder nhanh hơn StringBuffer khoảng %.2f lần\n", builderVsBufferSpeedup);
        } else if (durationBuffer < durationBuilder) {
            double bufferVsBuilderSpeedup = (double) durationBuilder / durationBuffer;
            System.out.printf("StringBuffer nhanh hơn StringBuilder khoảng %.2f lần\n", bufferVsBuilderSpeedup);
        } else {
            System.out.println("StringBuilder và StringBuffer có hiệu suất tương đương");
        }

        System.out.println("-----------------------------------------------------");

        // Kết luận và khuyến nghị
        System.out.println("\nNhận xét về hiệu suất và trường hợp sử dụng:");
        System.out.println("-----------------------------------------------------");
        System.out.println("String: ");
        System.out.println("  - Hiệu suất: Thấp nhất khi nối chuỗi nhiều lần");
        System.out.println("  - Phù hợp: Khi chuỗi không thay đổi hoặc thay đổi ít");
        System.out.println("  - Ưu điểm: Bất biến (immutable), an toàn");
        System.out.println();

        System.out.println("StringBuilder: ");
        System.out.println("  - Hiệu suất: Tốt nhất cho ứng dụng đơn luồng");
        System.out.println("  - Phù hợp: Khi cần nối chuỗi nhiều lần trong một luồng");
        System.out.println("  - Ưu điểm: Nhanh nhất, tiết kiệm bộ nhớ");
        System.out.println();

        System.out.println("StringBuffer: ");
        System.out.println("  - Hiệu suất: Tốt nhưng chậm hơn StringBuilder");
        System.out.println("  - Phù hợp: Khi cần nối chuỗi trong môi trường đa luồng");
        System.out.println("  - Ưu điểm: Thread-safe, an toàn cho đa luồng");
        System.out.println("-----------------------------------------------------");

        // Kiểm tra độ dài chuỗi để xác minh kết quả
        System.out.println("\nĐộ dài chuỗi kết quả (để xác minh):");
        System.out.println("String: " + resultString.length() + " ký tự");
        System.out.println("StringBuilder: " + resultBuilder.length() + " ký tự");
        System.out.println("StringBuffer: " + resultBuffer.length() + " ký tự");
    }

    // Phương thức nối chuỗi với String
    private static String concatenateWithString() {
        String result = INITIAL_STRING;
        for (int i = 0; i < ITERATIONS; i++) {
            result += APPEND_STRING;
        }
        return result;
    }

    // Phương thức nối chuỗi với StringBuilder
    private static String concatenateWithStringBuilder() {
        StringBuilder builder = new StringBuilder(INITIAL_STRING);
        for (int i = 0; i < ITERATIONS; i++) {
            builder.append(APPEND_STRING);
        }
        return builder.toString();
    }

    // Phương thức nối chuỗi với StringBuffer
    private static String concatenateWithStringBuffer() {
        StringBuffer buffer = new StringBuffer(INITIAL_STRING);
        for (int i = 0; i < ITERATIONS; i++) {
            buffer.append(APPEND_STRING);
        }
        return buffer.toString();
    }
}
