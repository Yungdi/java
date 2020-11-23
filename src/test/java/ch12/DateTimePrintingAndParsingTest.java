package ch12;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("날짜와 시간 객체 출력과 파싱")
class DateTimePrintingAndParsingTest {

    @ParameterizedTest
    @DisplayName("DateTimeFormatter 의 BASIC_ISO_DATE 구현체로 출력하기")
    @CsvSource({"2020,1,1,20200101", "1987,2,7,19870207", "2000,1,9,20000109"})
    void testBasicIsoDateFormat(int year, int month, int day, String format) {
        LocalDate date = LocalDate.of(year, month, day);
        String basicIsoFormat = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        Assertions.assertThat(basicIsoFormat)
            .as("check values %s %s", basicIsoFormat, format)
            .isEqualTo(format);
    }

    @ParameterizedTest
    @DisplayName("DateTimeFormatter 의 ISO_LOCAL_DATE 구현체로 출력하기")
    @CsvSource({"2020,1,1,2020-01-01", "1987,2,7,1987-02-07", "1999,1,9,1999-01-09"})
    void testIsoLocalDateFormat(int year, int month, int day, String format) {
        LocalDate date = LocalDate.of(year, month, day);
        String isoLocalFormat = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        Assertions.assertThat(isoLocalFormat)
            .as("check values %s %s", isoLocalFormat, format)
            .isEqualTo(format);
    }

    @ParameterizedTest
    @DisplayName("DateTimeFormatter 의 ISO_LOCAL_DATE 구현체로 출력하기, 파싱된 LocalDate 비교하기")
    @CsvSource({"2020,1,1,01/01/2020", "1987,2,7,07/02/1987", "1999,1,9,09/01/1999"})
    void testCustomDateTimeFormatter(int year, int month, int day, String format, SoftAssertions softly) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.of(year, month, day);
        String customFormat = date.format(formatter);
        softly.assertThat(customFormat)
            .as("check values %s %s", customFormat, format)
            .isEqualTo(format);

        LocalDate parsedDate = LocalDate.parse(customFormat, formatter);
        softly.assertThat(parsedDate)
            .as("check values %s %s", parsedDate, date)
            .isEqualTo(date);
    }

    @Test
    @DisplayName("지역화된 DateTimeFormatter 만들기")
    void testLocalizedDateTimeFormatter(SoftAssertions softly) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        LocalDate date = LocalDate.of(2014, 3, 18);
        String localizedFormat = date.format(formatter);
        String expectedFormat = "18. marzo 2014";

        softly.assertThat(localizedFormat)
            .as("check values %s %s", localizedFormat, expectedFormat)
            .isEqualTo(expectedFormat);

        LocalDate parsedDate = LocalDate.parse(localizedFormat, formatter);
        softly.assertThat(parsedDate)
            .as("check values %s %s", parsedDate, date)
            .isEqualTo(date);
    }
}
