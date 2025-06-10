package purushotham.practice.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 8, 6, 5, 4, 7, 8, 5, 4, 2, 1, 85, 9);

        List<Integer> removedDuplicates = new ArrayList<>(new LinkedHashSet<>(list));
        System.out.println(removedDuplicates);


        System.out.println(removeDuplicates());
    }


    private static List<String> removeDuplicates() {
        List<String> str = Arrays.asList("abc", "bcd", "abc", "uyd");
        return new ArrayList<>(new LinkedHashSet<>(str));
    }
}
