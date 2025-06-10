package purushotham.practice.strings;

import java.util.List;

public class CountVowelsAndConsonants {
    public static void main(String[] args) {
        int vowelsCount = 0, consonantsCount = 0;

        String str = "purushotham";

//        str = str.toLowerCase();
//        for (char ch : str.toCharArray()) {
//            if (Character.isLetter(ch)) {
//                if ("aeiou".indexOf(ch) != -1) {
//                    vowelsCount++;
//                } else {
//                    consonantsCount++;
//                }
//            }
//        }
//
//        System.out.println("Vowels count : " + vowelsCount);
//        System.out.println("Consonants count : " + consonantsCount);

        vowelsAndConsonants(str);

    }

    private static void vowelsAndConsonants(String string) {
        char[] charArray = string.toCharArray();
        int vowelsCount = 0;
        int consonantsCount = 0;

        for (char ch : charArray) {
            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1) {
                    vowelsCount++;
                } else {
                    consonantsCount++;
                }
            }
        }

        System.out.println("Vowels count : " + vowelsCount);
        System.out.println("Consonants count : " + consonantsCount);
    }
}
