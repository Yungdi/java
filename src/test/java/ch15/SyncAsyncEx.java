package ch15;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
        Long sum;
        LocalTime returnResultTime;
        try {
            sum = task.call();
        } finally {
            returnResultTime = LocalTime.now();
        }
        System.out.println("리턴/결과 시간: " + returnResultTime);
        System.out.println("연산 결과값:" + sum);
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
        Future<Long> future;
        LocalTime returnTime;
        LocalTime resultTime;
        Long sum;
        try {
            future = executorService.submit(task);
        } finally {
            returnTime = LocalTime.now();
        }
        try {
            sum = future.get();
        } finally {
            resultTime = LocalTime.now();
        }
        Duration duration = Duration.between(returnTime, resultTime);
        System.out.println("리턴 시간: " + returnTime);
        System.out.println("완료 시간: " + resultTime);
        System.out.println("시간 차이: " + duration);
        System.out.println("연산 결과값:" + sum);
    }
}
