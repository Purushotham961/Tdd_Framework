package purushotham.practice.collections;

import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByValue {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 56);
        map.put("b", 5);
        map.put("c", 45);

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);


    }
}
