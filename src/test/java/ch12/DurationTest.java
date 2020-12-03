package ch12;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("두 시간 객체 사이의 지속 시간")
class DurationTest {

    @Test
    @DisplayName("Duration 만들기")
    void testDuration() {
        LocalTime beforeTime = LocalTime.of(10, 0);
        LocalTime afterTime = LocalTime.of(11, 0);
        Duration actual = Duration.between(beforeTime, afterTime);

        Duration expected = Duration.of(1L, ChronoUnit.HOURS);

        Assertions.assertThat(actual)
            .as("check duration")
            .isEqualTo(expected);
    }
}
