package abstraction;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExecutionAbstractionTest {

    private static Runnable task;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @BeforeAll
    static void setUp() {
        task = () -> System.out.println("hello world");
    }

    @Test
    @DisplayName("직접 실행")
    void testDirect() throws InterruptedException {
        Thread thread = new Thread(task);
        thread.start();
        thread.join();

        Assertions.assertThat(outContent.toString())
            .as("출력 확인")
            .hasToString("hello world");
    }

    @Test
    @DisplayName("실행 추상화")
    void testExecutionAbstraction() {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(task);

        Assertions.assertThat(outContent.toString())
            .as("출력 확인")
            .hasToString("hello world");
    }
}
