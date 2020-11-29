package ch12;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

@DisplayName("LocalDate 만들고 값 읽기")
@ExtendWith(SoftAssertionsExtension.class)
class LocalDateTest {

    @Tag("exception")
    @DisplayName("LocalDate 년월일 범위 제약 조건 위반")
    @ParameterizedTest
    @CsvSource({"2020,13,1", "2020,2,30", "1000000000,1,1"})
    void testException(int year, int monthValue, int dayOfMonth) {
        ThrowingCallable throwingCallable = () -> LocalDate.of(year, monthValue, dayOfMonth);
        Assertions.assertThatThrownBy(throwingCallable, "check thrown range exceed exception of LocalDate")
            .isInstanceOf(DateTimeException.class);
    }

    @Tag("exception")
    @DisplayName("LocalDate parse 값 형식 위반")
    @Test
    void testFormatViolation() {
        String format = "2020:01:01";
        ThrowingCallable throwingCallable = () -> LocalDate.parse(format);
        Assertions.assertThatThrownBy(throwingCallable, "check thrown range exceed exception of LocalDate")
            .isInstanceOf(DateTimeParseException.class);
    }

    @Test
    @DisplayName("LocalDate 만드는 여러가지 방식")
    void testCreationLocalDate(SoftAssertions softly) {
        // source
        int year = 2020;
        int monthValue = 1;
        Month month = Month.JANUARY;
        int dayOfMonth = 1;
        String dateExpression = "2020-01-01";

        // actual
        LocalDate actualLocalDate = LocalDate.of(year, month, dayOfMonth);
        LocalDate actualLocalDateFromParsing = LocalDate.parse(dateExpression);

        // expected
        LocalDate expectedLocalDate = LocalDate.of(year, monthValue, dayOfMonth);

        // assertion
        softly.assertThat(actualLocalDate)
            .as("check LocalDate")
            .isEqualTo(expectedLocalDate);
        softly.assertThat(actualLocalDateFromParsing)
            .as("check LocalDate")
            .isEqualTo(expectedLocalDate);
    }

    @Test
    @DisplayName("LocalDate 만들기,읽기")
    void testLocalDate(SoftAssertions softly) {
        // source
        int year = 2020;
        int month = 11;
        int dayOfMonth = 29;

        // actual
        LocalDate localDate = LocalDate.of(year, month, dayOfMonth);
        int actualYear = localDate.getYear();
        Month actualMonth = localDate.getMonth();
        int actualMonthValue = localDate.getMonthValue();
        int actualDayOfMonth = localDate.getDayOfMonth();
        DayOfWeek actualDayOfWeek = localDate.getDayOfWeek();

        // expected
        int expectedYear = 2020;
        Month expectedMonth = Month.NOVEMBER;
        int expectedMonthValue = 11;
        int expectedDayOfMonth = 29;
        DayOfWeek expectedDayOfWeek = DayOfWeek.SUNDAY;

        softly.assertThat(actualYear)
            .as("check year")
            .isEqualTo(expectedYear);
        softly.assertThat(actualMonth)
            .as("check month")
            .isEqualTo(expectedMonth);
        softly.assertThat(actualMonthValue)
            .as("check month value")
            .isEqualTo(expectedMonthValue);
        softly.assertThat(actualDayOfMonth)
            .as("check day of month")
            .isEqualTo(expectedDayOfMonth);
        softly.assertThat(actualDayOfWeek)
            .as("check day of week")
            .isEqualTo(expectedDayOfWeek);
    }

    @DisplayName("TemporalField 로 날짜의 값 가져오기")
    @ParameterizedTest
    @EnumSource(value = ChronoField.class, names = {"YEAR"})
    void testGetLocalDate(ChronoField chronoField) {
        int year = 2020;
        int monthValue = 11;
        int dayOfMonth = 11;
        LocalDate localDate = LocalDate.of(year, monthValue, dayOfMonth);

        int value = localDate.get(chronoField);

        Assertions.assertThat(value)
            .as("check %s value", chronoField.name())
            .isEqualTo(year);
    }
}
