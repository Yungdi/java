package ch12;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("UTC(UniversalTimeCoordinated 협정세계시)/GMT(GreenwichMeanTime 그리니치평균시) 기준 고정 오프셋")
class ZoneOffsetTest {

    @ParameterizedTest
    @DisplayName("ZoneOffset 생성")
    @CsvSource({"-06:00,US/Central", "+09:00,Asia/Seoul"})
    void testZoneOffset(String offsetId, String zoneId) {
        LocalDateTime dateTime = LocalDateTime.of(2021, Month.JANUARY, 1, 19, 0, 0);
        ZoneOffset zoneOffset = ZoneOffset.of(offsetId);
        ZoneId zone = ZoneId.of(zoneId);

        ZonedDateTime actual = ZonedDateTime.of(dateTime, zoneOffset);
        ZonedDateTime expected = ZonedDateTime.of(dateTime, zone);
        Assertions.assertThat(actual)
            .as("actual: %s, expected: %s", actual, expected)
            .isEqualTo(expected);
    }
}
