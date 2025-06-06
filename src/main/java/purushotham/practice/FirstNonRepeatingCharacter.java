package purushotham.practice;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String s = "uujhygtfrfrftgy";
        System.out.println(getNonRepeatingCharacter(s));
    }

    private static Character getNonRepeatingCharacter(String s) {
        char[] characters = s.replaceAll("\\s", "").toLowerCase().toCharArray();

        Map<Character, Integer> charCount = new HashMap<>();
        for (char ch : characters) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        System.out.println(charCount);

        for (Map.Entry<Character, Integer> map : charCount.entrySet()) {
            if (map.getValue() == 1) {
                return map.getKey();
            }
        }
        return '_';
    }
}
