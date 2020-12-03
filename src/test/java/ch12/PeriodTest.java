package ch12;

import java.time.LocalDate;
import java.time.Period;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

@DisplayName("두 날짜 객체 사이의 지속 시간")
class PeriodTest {

    @Test
    @DisplayName("Period 만들기")
    void testCreatePeriod(TestReporter testReporter) {
        LocalDate date1 = LocalDate.of(2020, 11, 11);
        LocalDate date2 = LocalDate.of(2020, 11, 30);
        Period period = Period.between(date1, date2);

        Period expected = Period.ofDays(19);

        Assertions.assertThat(period)
            .as("Period 일치 확")
            .isEqualTo(expected);

        testReporter.publishEntry(period.toString());
    }
}
