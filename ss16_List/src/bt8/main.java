package bt8;
import java.util.ArrayList;
import java.util.List;
public class main {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("banana");
        strings.add("cherry");
        strings.add("date");
        strings.add("fig");
        strings.add("grape");
        strings.add("kiwi");

        System.out.println("Danh sách ban đầu: " + strings);

        // Sắp xếp bằng lambda và Comparator.comparing
        strings.sort((s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length();
            } else {
                return s1.compareTo(s2);
            }
        });

        System.out.println("Danh sách sau khi sắp xếp: " + strings);
    }
}
