package purushotham.practice.collections;

import java.util.HashMap;
import java.util.Map;

public class CharFrequency {
    public static void main(String[] args) {
        String str = "purushotham";

        char[] arr = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : arr) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        System.out.println(map);
    }
}
