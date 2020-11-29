package ch12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("날짜와 시간 조합")
class LocalDateTimeTest {

    @Test
    @DisplayName("LocalDate 와 LocalTime 을 조합하여 LocalDateTime 만들기")
    void testCreateLocalDateTimeByDateAndTime() {
        LocalDate localDate = LocalDate.of(2020, 11, 30);
        LocalTime localTime = LocalTime.of(13, 0, 0);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

        Assertions.assertThat(localDateTime)
            .as("날짜와 시간")
            .isIn("2020-11-30T13:00");
    }

    @Test
    @DisplayName("LocalDateTime 직접 만들기")
    void testCreateLocalDateTimeDirectly() {
        LocalDateTime localDateTime = LocalDateTime.of(2020, 11, 30, 13, 0, 0);

        Assertions.assertThat(localDateTime)
            .as("날짜와 시간")
            .isIn("2020-11-30T13:00");
    }
}
