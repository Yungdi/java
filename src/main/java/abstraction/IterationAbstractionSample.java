package abstraction;

import java.util.Arrays;
import java.util.List;

public class IterationAbstractionSample {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f");

        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("---------------------------");
        // abstraction iteration version
        list.parallelStream().forEach(System.out::println);
    }
}
