public class bt6 {
    public static void main(String[] args) {
        System.out.println("JDK, JRE và JVM trong hệ sinh thái Java\n" +
                "Phân biệt ba khái niệm và mối quan hệ\n" +
                "1. JVM (Java Virtual Machine):\n" +
                "\n" +
                "Vai trò: Là máy ảo Java, thực thi bytecode Java (.class) và tạo môi trường độc lập với nền tảng\n" +
                "Chức năng chính: Chuyển đổi bytecode thành mã máy, quản lý bộ nhớ và garbage collection\n" +
                "Đặc điểm: Là thành phần cốt lõi nhất, không thể tương tác trực tiếp\n" +
                "\n" +
                "2. JRE (Java Runtime Environment):\n" +
                "\n" +
                "Vai trò: Cung cấp môi trường để chạy ứng dụng Java\n" +
                "Chứa: JVM và các thư viện chuẩn Java (Java API)\n" +
                "Đối tượng sử dụng: Người dùng cuối chỉ muốn chạy ứng dụng Java\n" +
                "\n" +
                "3. JDK (Java Development Kit):\n" +
                "\n" +
                "Vai trò: Bộ công cụ phát triển Java toàn diện\n" +
                "Chứa: JRE (bao gồm JVM) + Compiler (javac) + các công cụ phát triển (debugger, JavaDoc)\n" +
                "Đối tượng sử dụng: Lập trình viên Java\n" +
                "\n" +
                "Mối quan hệ: JDK > JRE > JVM (JDK chứa JRE, JRE chứa JVM)\n" +
                "\"Write once, run anywhere\" trong Java\n" +
                "Khái niệm và cơ chế\n" +
                "Khái niệm:\n" +
                "\"Write once, run anywhere\" (viết một lần, chạy mọi nơi) là triết lý cốt lõi của Java, cho phép chương trình Java được viết một lần nhưng có thể chạy trên bất kỳ nền tảng nào có JVM.\n" +
                "Cơ chế thực hiện:\n" +
                "\n" +
                "Biên dịch hai giai đoạn:\n" +
                "\n" +
                "Mã nguồn Java (.java) được biên dịch thành bytecode (.class) bởi compiler (javac)\n" +
                "Bytecode là định dạng trung gian, không phụ thuộc vào nền tảng\n" +
                "\n" +
                "\n" +
                "Vai trò của JVM:\n" +
                "\n" +
                "Mỗi hệ điều hành có phiên bản JVM riêng, được thiết kế đặc biệt cho nền tảng đó\n" +
                "JVM đọc và dịch bytecode thành mã máy phù hợp với hệ điều hành và phần cứng\n" +
                "JVM đảm bảo cùng một bytecode sẽ chạy giống nhau trên mọi nền tảng\n" +
                "\n" +
                "\n" +
                "Lớp trừu tượng:\n" +
                "\n" +
                "JVM tạo lớp trừu tượng giữa chương trình và hệ điều hành, ẩn đi sự khác biệt giữa các nền tảng");
    }
}
