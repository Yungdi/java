package ch12;

import chapter12.NextWorkingDay;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAmount;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Temporal 클래스의 복잡한 날짜 조정")
@ExtendWith(SoftAssertionsExtension.class)
class TemporalAdjustersTest {

    @Test
    @DisplayName("미리 정의된 TemporalAdjusters 사용하기")
    void testDefaultTemporalAdjusters(SoftAssertions softly) {
        LocalDate date1 = LocalDate.of(2020, 11, 25);

        LocalDate date2 = date1.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        LocalDate date3 = date2.with(TemporalAdjusters.lastDayOfMonth());
        softly.assertThat(date2)
            .as("check values %s %s", date2, date3)
            .isEqualTo(date3);

        LocalDate date4 = date1.with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY));
        softly.assertThat(date1)
            .as("check values %s %s", date1, date4)
            .isEqualTo(date4);
    }

    @ParameterizedTest
    @DisplayName("Custom TemporalAdjuster 사용하기 Working Day 구하기 다음날을 구하는데 토/일요일은 넘긴다.")
    @CsvSource({"2020,11,25,1", "2020,11,26,1", "2020,11,27,3", "2020,11,28,2", "2020,11,29,1", "2020,11,30,1"})
    void testCustomWorkingDayAdjuster(int year, int month, int day, int nextDay) {
        TemporalAdjuster nextWorkingDay = new NextWorkingDay();

        LocalDate date = LocalDate.of(year, month, day);
        LocalDate actual = date.with(nextWorkingDay);
        LocalDate expected = date.plus(Period.ofDays(nextDay));
        Assertions.assertThat(actual)
            .as("actual : %s expected: %s", actual, expected)
            .isEqualTo(expected);
    }
}
