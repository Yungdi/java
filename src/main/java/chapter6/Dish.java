package chapter6;

import java.util.StringJoiner;

public class Dish {

    private int calories;
    private String name;

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Dish.class.getSimpleName() + "[", "]")
            .add("calories=" + calories)
            .add("name='" + name + "'")
            .toString();
    }
}
