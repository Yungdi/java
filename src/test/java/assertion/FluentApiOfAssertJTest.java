package assertion;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("AssertJ 의 Fluent API ")
class FluentApiOfAssertJTest {

    @Test
    void testAssertionOfString() {
        String given = "hello world";
        Assertions.assertThat(given)
            .as("문자열 단정문")
            .startsWith("hello")
            .endsWith("world")
            .hasSize(11);
    }
}
