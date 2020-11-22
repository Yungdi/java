package chapter12;

import java.time.LocalTime;

public class LocalTimeEx {

    public static void main(String[] args) {
        LocalTime parse1 = LocalTime.parse("13:45:20");
        System.out.println(parse1);
    }
}
