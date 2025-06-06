package purushotham.practice;

public class CountVowelsAndConsonants {
    public static void main(String[] args) {
        int vowelsCount = 0, consonantsCount = 0;

        String str = "purushotham";

        str = str.toLowerCase();
        for (char ch : str.toCharArray()) {
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
