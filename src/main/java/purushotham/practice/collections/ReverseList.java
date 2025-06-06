package purushotham.practice.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(8, 5, 4, 7, 5, 2, 19, 25, 7, 85);
        Collections.reverse(list);
        System.out.println(list);
    }
}
