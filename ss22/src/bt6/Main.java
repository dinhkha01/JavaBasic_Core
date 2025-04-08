package bt6;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. Tạo file input.txt với nội dung có sẵn
        createInputFile();

        // 2. Đọc file input.txt và đảo ngược nội dung
        String reversedContent = readAndReverseFile("input.txt");

        // 3. Ghi nội dung đảo ngược vào file copy.txt
        writeToFile("copy.txt", reversedContent);

        // 4. Đọc và hiển thị nội dung file copy.txt để kiểm tra
        System.out.println("Nội dung file copy.txt:");
        readAndDisplayFile("copy.txt");
    }

    // Phương thức tạo file input.txt với nội dung mẫu
    private static void createInputFile() {
        try (PrintWriter writer = new PrintWriter("input.txt")) {
            writer.println("Chào mừng đến với lập trình Java");
            writer.println("Đây là bài tập thao tác với file");
            writer.println("Chúng ta sẽ đảo ngược nội dung file");
            System.out.println("Đã tạo file input.txt thành công");
        } catch (FileNotFoundException e) {
            System.err.println("Lỗi khi tạo file: " + e.getMessage());
        }
    }

    // Phương thức đọc file và đảo ngược nội dung
    private static String readAndReverseFile(String filename) {
        StringBuilder content = new StringBuilder();
        StringBuilder reversedContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            // Đảo ngược toàn bộ nội dung
            reversedContent.append(new StringBuilder(content.toString()).reverse());
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }

        return reversedContent.toString();
    }

    // Phương thức ghi nội dung vào file
    private static void writeToFile(String filename, String content) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.print(content);
            System.out.println("Đã ghi nội dung đảo ngược vào file " + filename);
        } catch (FileNotFoundException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    // Phương thức đọc và hiển thị nội dung file
    private static void readAndDisplayFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}