package purushotham.practice.strings;

public class ReverseString {
    public static void main(String[] args) {
        String str = "purushotham";

        String s = new StringBuilder(str).reverse().toString();
        System.out.println(s);
    }
}
