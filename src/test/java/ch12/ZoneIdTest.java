package ch12;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("java.util.TimeZone 을 대체할 수 있는 java.time.ZoneId"
    + "서머타임 DST(Daylight SavingTime) 같은 복잡한 사항이 자동으로 처리됨")
class ZoneIdTest {

    @Test
    @DisplayName("'지역/도시' 형식으로 만드는 ZoneId")
    void testOfZoneId() {
        String zoneId = "Europe/Rome";
        ZoneId romeZone = ZoneId.of(zoneId);
        Assertions.assertThat(romeZone)
            .as("zoneId: %s", zoneId)
            .hasToString(zoneId);
    }

    @Test
    @DisplayName("TimeZone 을 ZoneId 로 변환")
    void testConvertingTimeZoneToZoneId() {
        TimeZone timeZone = TimeZone.getDefault();
        ZoneId zoneId = timeZone.toZoneId();

        Assertions.assertThat(zoneId)
            .as("TimeZone: %s", timeZone)
            .isNotNull();
    }

    @ParameterizedTest
    @DisplayName("LocalDate 에 ZoneId 적용")
    @CsvSource({"2020,1,1,Europe/Rome"})
    void testApplyZoneIdToLocalDate(int year, int month, int day, String zoneId) {
        LocalDate date = LocalDate.of(year, month, day);
        ZoneId zone = ZoneId.of(zoneId);
        ZonedDateTime zonedDateTime = date.atStartOfDay(zone);

        Assertions.assertThat(zonedDateTime)
            .as("ZoneId: %s, LocalDate: %s", zone, date)
            .isNotNull();
    }
}
