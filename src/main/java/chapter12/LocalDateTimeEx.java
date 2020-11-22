package chapter12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeEx {

    public static void main(String[] args) {
        // 12.1.2 날짜와 시간 조합
        // LocalDateTime 은 LocalDate 와 LocalTime 을 쌍으로 갖는 복합 클래스다.
        LocalDateTime of = LocalDateTime.of(2017, Month.SEPTEMBER, 21, 13, 45, 20);
        System.out.println(of);
        LocalDate of1 = LocalDate.of(2021, 1, 1);
        LocalTime of2 = LocalTime.of(10, 0, 1);
        LocalDateTime of3 = LocalDateTime.of(of1, of2);
        System.out.println(of3);
        // LocalDateTime to LocalDate
        LocalDate toLocalDate = of3.toLocalDate();
        System.out.println(toLocalDate);
        // LocalDate to LocalDateTime
        LocalDateTime localDateTime1 = toLocalDate.atTime(LocalTime.now());
        System.out.println(localDateTime1);

        // LocalDateTime to LocalTime
        LocalTime localTime = of3.toLocalTime();
        System.out.println(localTime);
        // LocalTime to LocalDateTime
        LocalDateTime localDateTime = localTime.atDate(LocalDate.now());
        System.out.println(localDateTime);
    }
}
