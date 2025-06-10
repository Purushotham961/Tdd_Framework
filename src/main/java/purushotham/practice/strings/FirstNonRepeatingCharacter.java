package purushotham.practice.strings;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String s = "uujhygtfrfrftgy";
        System.out.println(getNonRepeatingCharacter(s));

        firstNonRepeatingCharacter(s);
        
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

    private static void firstNonRepeatingCharacter(String string) {
        char[] charArray = string.replaceAll("\\s", "").toLowerCase().toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : charArray) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        System.out.println(map);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey() + " is first non repeating character");
                break;
            }
        }
    }
}
