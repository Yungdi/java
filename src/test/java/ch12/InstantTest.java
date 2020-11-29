package ch12;

import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.UnsupportedTemporalTypeException;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("기계의 날짜와 시간")
class InstantTest {

    @Test
    @DisplayName("Instant 는 사람이 읽을 수 있는 시간 정보를 제공하지 않는다")
    void testInstantGetException() {
        Instant instant = Instant.ofEpochSecond(10);
        ThrowingCallable throwingCallable = () -> instant.get(ChronoField.YEAR);
        Assertions.assertThatThrownBy(throwingCallable)
            .isInstanceOf(UnsupportedTemporalTypeException.class);
    }

    @Test
    @DisplayName("1970년 1월 1일 0시 0분 0초를 기준으로 얼마의 시간이 지났는 지 표현")
    void testCreateInstant() {
        Instant instant = Instant.ofEpochSecond(10);
        Assertions.assertThat(instant)
            .as("Instant 날짜 표현식")
            .isIn("1970-01-01T00:00:10Z");
    }
}
