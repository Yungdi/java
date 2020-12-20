package abstraction;

import java.util.List;
import java.util.function.Consumer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IterationAbstractionTest {

    private static List<Integer> numbers;

    @BeforeAll
    static void setUp() {
//        numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @Test
    void test() {
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }

    @Test
    @DisplayName("반복문 추상화")
    void testAbstraction() {
        Consumer<Integer> action = System.out::println;
        // 반복문은 구현 내부에...
        numbers.stream()
            .parallel()
            .forEach(action);
    }
}
