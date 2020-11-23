package ch12;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@DisplayName("Temporal 클래스의 속성 변경")
@ExtendWith(SoftAssertionsExtension.class)
class TemporalAttributeTest {

    @Test
    @DisplayName("LocalDate 는 Immutable 이며 withAttribute 를 사용하면 Object 를 복사한다")
    void testWithAttribute() {
        LocalDate localDate1 = LocalDate.of(2017, 9, 21);
        LocalDate localDate2 = localDate1.withYear(2020);

        Assertions.assertThat(localDate1)
            .as("check reference %s %s", localDate1.hashCode(), localDate2.hashCode())
            .isNotSameAs(localDate2);
    }

    @Test
    @DisplayName("LocalDate 의 속성 바꾸는 방법들")
    void testWithAttributeMethods() {
        LocalDate localDate1 = LocalDate.of(2020, 1, 1);
        LocalDate localDate2 = localDate1.withYear(2030);
        LocalDate localDate3 = localDate1.with(ChronoField.YEAR, 2030);

        Assertions.assertThat(localDate2)
            .as("check equality %s %s", localDate2, localDate3)
            .isEqualTo(localDate3);
    }

    @Test
    @DisplayName("LocalDate 의 상대적인 방식으로 속성 바꾸는 방법들")
    void testChangeAttributeMethods(SoftAssertions softly) {
        LocalDate date1 = LocalDate.of(2020, 1, 1);

        LocalDate date2 = date1.plusWeeks(1L);
        LocalDate date3 = date1.plus(7L, ChronoUnit.DAYS);

        softly.assertThat(date2)
            .as("check equality %s %s", date2, date3)
            .isEqualTo(date3);

        LocalDate date4 = date1.minusYears(1L);
        LocalDate date5 = date1.minus(365L, ChronoUnit.DAYS);

        softly.assertThat(date4)
            .as("check equality %s %s", date4, date5)
            .isEqualTo(date5);
    }
}
