package abstraction;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExecutionAbstractionTest {

    private static Runnable task;

    @BeforeAll
    static void setUp() {
        task = () -> System.out.println("hello world");
    }

    @Disabled
    @Test
    @DisplayName("직접 실행")
    void testDirect() throws InterruptedException {
        Thread thread = new Thread(task);
        thread.start();
        thread.join();
    }

    @Disabled
    @Test
    @DisplayName("실행 추상화")
    void testExecutionAbstraction() {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(task);
    }
}
