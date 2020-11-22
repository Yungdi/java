package chapter12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class LocalDateEx {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2017, 9, 21);
        System.out.println(localDate);
        int year = localDate.getYear();
        Month month = localDate.getMonth();
        int monthValue = localDate.getMonthValue();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int i = localDate.lengthOfMonth();
        boolean leapYear = localDate.isLeapYear();
        // TemporalField, ChronoField
        int year1 = localDate.get(ChronoField.YEAR);
        int month1 = localDate.get(ChronoField.MONTH_OF_YEAR);
        int dayOfWeek1 = localDate.get(ChronoField.DAY_OF_WEEK);

        LocalDate parse = LocalDate.parse("2017-09-21");
        System.out.println(parse);
    }
}
