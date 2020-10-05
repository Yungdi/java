package chapter6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReducingExample {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c");

        Long count1 = strings.stream().collect(Collectors.counting());
        long count2 = strings.stream().count();
    }
}