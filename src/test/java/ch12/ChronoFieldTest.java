package ch12;

import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("ChronoField 명세 확인")
class ChronoFieldTest {

    TestReporter testReporter;

    @BeforeEach
    void init(TestReporter testReporter) {
        this.testReporter = testReporter;
    }

    @ParameterizedTest
    @MethodSource("localeProvider")
    void testDisplayName(Locale locale, ChronoField chronoField, String expectedDisplayName) {
        String actualDisplayName = chronoField.getDisplayName(locale);

        Assertions.assertThat(actualDisplayName)
            .as("지역에 따른 필드 표기법 확")
            .isEqualTo(expectedDisplayName);
        testReporter.publishEntry(actualDisplayName);
    }

    private static Stream<Arguments> localeProvider() {
        return Stream.of(
            Arguments.of(Locale.CHINA, ChronoField.YEAR, "年"),
            Arguments.of(Locale.KOREA, ChronoField.YEAR, "년")
        );
    }
}
