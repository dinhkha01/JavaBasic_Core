package bt7;
import java.util.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        String text = "Hello world hello Java. Java is great, isn't it? World loves Java!";
        String[] wordsArray = text.split("\\W+");
        List<String> allWords = new ArrayList<>();
        Set<String> uniqueWords = new HashSet<>();

        for (String word : wordsArray) {
            String lowerWord = word.toLowerCase();
            allWords.add(lowerWord);
            uniqueWords.add(lowerWord);
        }

        // 2. Sắp xếp các từ theo thứ tự bảng chữ cái
        List<String> sortedWords = new ArrayList<>(uniqueWords);
        Collections.sort(sortedWords);

        // 3. Đếm số lần xuất hiện của mỗi từ
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : allWords) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
        System.out.println("Các từ duy nhất (không trùng lặp):");
        System.out.println(uniqueWords);

        System.out.println("\nCác từ đã sắp xếp theo bảng chữ cái:");
        System.out.println(sortedWords);

        System.out.println("\nTần suất xuất hiện của mỗi từ:");
        for (String word : sortedWords) {
            System.out.println(word + ": " + wordCounts.get(word));
        }
    }
}
