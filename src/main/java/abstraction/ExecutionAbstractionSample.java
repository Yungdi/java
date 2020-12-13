package abstraction;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutionAbstractionSample {

    public static void main(String[] args) {
        Runnable task = () -> System.out.println("hello world");

        new Thread(task).start();

        // abstraction execution version
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(task);
    }
}
