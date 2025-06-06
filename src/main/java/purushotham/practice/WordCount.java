package purushotham.practice;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        String input = "hello world hello i am good";
        String[] words = input.split(" ");

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word.trim(), wordCount.getOrDefault(word.trim(), 0) + 1);
        }

        System.out.println(wordCount);
        System.out.println("Count of word hello is " + wordCount.get("hello"));

    }
}
