package purushotham.practice;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome2(36));
    }

    private static boolean isPalindrome(int num) {
        int temp = num, rev = 0;

        while (num != 0) {
            rev = rev * 10 + num % 10;
            num = num / 10;
        }

        return rev == temp;
    }

    private static boolean isPalindrome2(int num) {
        return new StringBuilder(String.valueOf(num))
                .reverse().toString().equalsIgnoreCase(String.valueOf(num));
    }
}
