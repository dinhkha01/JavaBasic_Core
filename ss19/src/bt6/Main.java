package bt6;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("hello", "world", "java", "programming");
        StringProcessor processor = str -> str.toUpperCase()  + " - TECHNICAL";

        List<String> processedStrings = strings.stream()
                .map(processor::processString)
                .collect(Collectors.toList());


        processor.printList(processedStrings);


    }
}
