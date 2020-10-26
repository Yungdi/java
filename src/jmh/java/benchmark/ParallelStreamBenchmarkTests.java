package benchmark;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"})
public class ParallelStreamBenchmarkTests {
    private final static long N = 10_000_000L;

    public long conventionalForSequentialSumTest() {
        long sum = 0;
        for (long i = 0; i < N; i++) {
            sum += i;
        }
        return sum;
    }

    @Benchmark
    public long boxingSequentialSumTest() {
        return Stream.iterate(1L, i -> i + 1)
            .limit(N)
            .reduce(0L, Long::sum);
    }

    @Benchmark
    public long unBoxingSequentialSumTest() {
        return LongStream.rangeClosed(1L, N)
            .reduce(0L, Long::sum);
    }

    @Benchmark
    public long unBoxingParallelSumTest() {
        return LongStream.rangeClosed(1L, N)
            .parallel()
            .reduce(0L, Long::sum);
    }

    @TearDown(Level.Invocation)
    public void tearDown() {
        System.gc();
    }
}