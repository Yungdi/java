package chapter12;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class WithAttributeEx {

    public static void main(String[] args) {
        LocalDate localDate1 = LocalDate.of(2017, 9, 21);
        LocalDate localDate2 = localDate1.withYear(2020);

    }
}
