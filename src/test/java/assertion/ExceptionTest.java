package assertion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowableOfType;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Exception 관련 Assertions")
class ExceptionTest {

    @Test
    void test() {
        ThrowingCallable throwingCallable = () -> {
            throw new IndexOutOfBoundsException();
        };
        assertThat(catchThrowableOfType(throwingCallable, RuntimeException.class))
            .as("exception test")
            .isNotNull();
    }

    @Test
    void test1() {
        String format = "2020:01:01";
        ThrowingCallable throwingCallable = () -> LocalDate.parse(format);
        assertThatThrownBy(throwingCallable, "check thrown range exceed exception of LocalDate")
            .isInstanceOf(DateTimeParseException.class);
    }

    @Test
    void exception_assertion_example() {
        Assertions.assertThatExceptionOfType(IOException.class)
            .isThrownBy(() -> {
                throw new IOException("boom!");
            })
            .withMessage("%s!", "boom")
            .withMessageContaining("boom")
            .withNoCause();
    }

    @Test
    void testNoException1() {
        Assertions.assertThatCode(() -> System.out.println("OK")).doesNotThrowAnyException();
    }
}
