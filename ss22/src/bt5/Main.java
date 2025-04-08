package bt5;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Tạo file input.txt với nội dung các cầu thủ
        createInputFile();

        // Đọc file và tìm tên dài nhất
        findLongestName();
    }

    private static void createInputFile() {
        try (PrintWriter writer = new PrintWriter("input.txt")) {
            writer.println("Văn Lâm");
            writer.println("Tiến Lĩnh");
            writer.println("Xuân Sơn");
            writer.println("Hoàng Đức");
            writer.println("Văn Hậu");
            System.out.println("Đã tạo file input.txt thành công");
        } catch (FileNotFoundException e) {
            System.err.println("Lỗi khi tạo file: " + e.getMessage());
        }
    }

    private static void findLongestName() {
        List<String> players = new ArrayList<>();

        // Đọc nội dung từ file
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    players.add(line.trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
            return;
        }

        // Tìm tên dài nhất
        if (players.isEmpty()) {
            System.out.println("File không có nội dung");
            return;
        }

        String longestName = players.get(0);
        for (String name : players) {
            if (name.length() > longestName.length()) {
                longestName = name;
            }
        }

        // Hiển thị kết quả
        System.out.println("Tên cầu thủ dài nhất: " + longestName);
        System.out.println("Độ dài của tên: " + longestName.length());
    }
}