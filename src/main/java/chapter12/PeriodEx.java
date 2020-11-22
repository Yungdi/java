package chapter12;

import java.time.LocalDate;
import java.time.Period;

public class PeriodEx {

    public static void main(String[] args) {
        Period period = Period.between(
            LocalDate.of(2020, 1, 1),
            LocalDate.of(2021, 2, 2)
        );
        System.out.println(period);
        Period period1 = Period.ofDays(2);
        System.out.println(period1);
        Period period2 = Period.of(1, 2, 3);
        System.out.println(period2);
    }
}
