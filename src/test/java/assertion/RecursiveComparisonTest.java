package assertion;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RecursiveComparisonTest {

    @Test
    void testFieldByFieldRecursiveComparison() {
        Student student1 = new Student("jin", 182);
        Student student2 = new Student("jin", 182);

        Assertions.assertThat(student1)
            .usingRecursiveComparison()
            .as("학생 속성 비교")
            .isEqualTo(student2);
    }
}
