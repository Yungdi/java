package ch15;

import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("동기화 연산 예제")
class SyncAsyncEx {

    @Disabled
    @Test
    void testSyncMethod() throws Exception {
        Callable<Long> task = () -> {
            long sum = 0L;
            long start = 1L;
            long end = 4_000_000_000L;
            for (long i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        };

        Long sum = task.call();
        System.out.println("리턴 시간: " + LocalTime.now());
        System.out.println("연산 결과값:" + sum + ", 연산 완료 시간: " + LocalTime.now());
    }

    @Disabled
    @Test
    @DisplayName("비동기 연산")
    void testAsyncMethod() throws Exception {
        Callable<Long> task = () -> {
            long sum = 0L;
            long start = 1L;
            long end = 4_000_000_000L;
            for (long i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Long> future = executorService.submit(task);
        System.out.println("리턴 시간: " + LocalTime.now());
        System.out.println("연산 결과값:" + future.get() + ", 연산 완료 시간: " + LocalTime.now());
    }
}
