package purushotham.practice.arrays;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {
    public static void main(String[] args) {

        int[] arr = {5, 6, 2, 4, 15, 85, 4, 5, 2, 5};
        String[] str = {"abc", "def", "abc", "uey"};


        System.out.println(findDuplicates(arr));
        System.out.println(findDuplicates(str));
    }

    private static Set<Integer> findDuplicates(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (int num : arr) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        System.out.println("Duplicates: " + duplicates);
        return duplicates;
    }

    private static Set<String> findDuplicates(String[] arr) {
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (String s : arr) {
            if (!seen.add(s)) {
                duplicates.add(s);
            }
        }
        System.out.println("Duplicates: " + duplicates);
        return duplicates;
    }
}
