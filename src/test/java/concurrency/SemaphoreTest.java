package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

class SemaphoreTest {

    public static final int N_THREADS = 2;

    @Test
    void testSemaphore() {
        Semaphore semaphore = new Semaphore(1);
        ExecutorService executorService = Executors.newFixedThreadPool(N_THREADS);

        executorService.submit(() -> {
            try {
                semaphore.acquire();
                System.out.println("1 acquire lock");
                Thread.sleep(1000L);
                semaphore.acquire();
                System.out.println("2 acquire lock");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        });
        try {
            executorService.awaitTermination(100L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
