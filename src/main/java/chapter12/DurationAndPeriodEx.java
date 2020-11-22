package chapter12;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DurationAndPeriodEx {

    public static void main(String[] args) {
        // Temporal 인터페이스: 특정 시간을 모델링하는 객체의 값을 어떻게 읽고 조작할 지 정의
        // 초와 나노초로 시간 단위를 표현하므로 Temporal 구현체 중 LocalDate 는 사용할 수 없다.
        LocalTime time1 = LocalTime.of(12, 0, 0);
        LocalTime time2 = LocalTime.of(13, 0, 0);
        Duration duration1 = Duration.between(time1, time2);
        System.out.println(duration1);

        LocalDateTime date1 = LocalDateTime.of(2020, 1, 1, 12, 1, 1);
        LocalDateTime date2 = LocalDateTime.of(2021, 1, 1, 11, 11, 11);
        Duration duration2 = Duration.between(date1, date2);
        System.out.println(duration2);

        Instant instant1 = Instant.ofEpochSecond(1L);
        Instant instant2 = Instant.ofEpochSecond(2L);
        Duration duration3 = Duration.between(instant1, instant2);
        System.out.println(duration3);
    }
}
