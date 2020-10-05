package chapter6;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MyCollector implements Collector<String, List<String>, List<String>> {

    @Override
    public Supplier<List<String>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<String>, String> accumulator() {
        return List::add;
    }

    @Override
    public Function<List<String>, List<String>> finisher() {
        return Function.identity();
    }

    @Override
    public BinaryOperator<List<String>> combiner() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }
}
