package assertion;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@DisplayName("하나의 단위 테스트에서 여러개의 assertion 실행하는 방법")
@ExtendWith(SoftAssertionsExtension.class)
class AssertionTest {

    static int operand1;
    static int operand2;
    static int additionResult;
    static int subtractionResult;

    @BeforeAll
    static void setUpSource() {
        operand1 = 3;
        operand2 = 2;
        additionResult = 4; // fail
        subtractionResult = 2; // fail
    }

    @Test
    @DisplayName("실패한 assertion 이 있어면 그 즉시 테스트를 종료하는 방법")
    void testIfFailedStoppingTest() {
        Assertions.assertSame(operand1 + operand2, additionResult, "더하기");
        Assertions.assertSame(operand1 - operand2, subtractionResult, "빼기");
    }

    @Test
    @DisplayName("JUnit5 의 실패한 assertion 이 있어도 계속 진행하는 방법")
    void testIfFailedKeepingTestingByJUnit() {
        Assertions.assertAll(
            () -> Assertions.assertSame(operand1 + operand2, additionResult, "더하기"),
            () -> Assertions.assertSame(operand1 - operand2, subtractionResult, "빼기")
        );
    }

    @Test
    @DisplayName("AssertJ 의 실패한 assertion 이 있어도 계속 진행하는 방법")
    void testIfFailedKeepingTestingByAssertJ(SoftAssertions softly) {
        softly.assertThat(additionResult)
            .as("덧셈")
            .isEqualTo(operand1 + operand2);
        softly.assertThat(subtractionResult)
            .as("뺄셈")
            .isEqualTo(operand1 - operand2);
    }
}
