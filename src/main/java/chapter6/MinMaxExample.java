package chapter6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class MinMaxExample {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(new Dish());

        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));

        IntSummaryStatistics collect = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        menu.stream().map(Dish::getName).collect(Collectors.joining());

        Integer collect1 = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));

    }
}