package ch12;

import java.time.LocalTime;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LocalTime 만들고 값 읽기")
class LocalTimeTest {

    @Test
    @DisplayName("LocalTime 만들기,읽기")
    void testLocalTime(SoftAssertions softly) {
        // source
        int hour = 10;
        int minute = 0;
        int second = 0;
        int nanoSecond = 0;

        // actual
        LocalTime localTime = LocalTime.of(10, 0, 0, 0);
        int actualHour = localTime.getHour();
        int actualMinute = localTime.getMinute();
        int actualSecond = localTime.getSecond();
        int actualNano = localTime.getNano();

        // assertion
        softly.assertThat(actualHour)
            .as("check hour")
            .isEqualTo(hour);
        softly.assertThat(actualMinute)
            .as("check minute")
            .isEqualTo(minute);
        softly.assertThat(actualSecond)
            .as("check second")
            .isEqualTo(second);
        softly.assertThat(actualNano)
            .as("check nano")
            .isEqualTo(nanoSecond);
    }

}
