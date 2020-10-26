package chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ToListCollectorExample {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("h", "e", "l", "l", "o");
        List<String> collect = list.stream()
            .sorted(Comparator.reverseOrder())
            .collect(new ToListCollector<>());
        for (String s : collect) {
            System.out.println(s);
        }

        List<String> collect1 = list.stream()
            .sorted(Comparator.reverseOrder())
            .collect(ArrayList::new, List::add, List::addAll);
        for (String s : collect1) {
            System.out.println(s);
        }

    }
}