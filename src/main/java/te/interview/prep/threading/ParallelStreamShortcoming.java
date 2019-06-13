package te.interview.prep.threading;

import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * The default {@link Collection#parallelStream()} function has a hidden shortcoming: all tasks that
 * are parallelized with it will be run inside a fork-join thread pool that is SHARED. This means
 * you may parallelize a bunch of fast tasks and then somewhere else in your code a slow task is
 * parallelized, and now all of your fast tasks are bound by the speed of the slow task.
 *
 * While this example doesn't use the {@link Collection#parallelStream()} directly it mimics the
 * behavior of it so there's no functional difference.
 */
public class ParallelStreamShortcoming {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();

        // Pretend a bunch of tasks were started from different threads
        // that execute without any delay
        es.execute(() -> runTask(0));
        es.execute(() -> runTask(0));
        es.execute(() -> runTask(0));
        es.execute(() -> runTask(0));
        es.execute(() -> runTask(0));

        // Then a single thread somewhere tries to run a parallel task that executes
        // with a 1 millisecond delay between every calculation, 1 million times.
        // Comment this line out to prove it's the culprit of our slow performance.
        es.execute(() -> runTask(1));

        es.shutdown();
        es.awaitTermination(60, TimeUnit.SECONDS);
    }

    private static void runTask(int artificialDelay) {
        IntStream.range(1, 1_000_000)
                .parallel()
                .filter(ParallelStreamShortcoming::isPrime)
                .peek(i -> sleep(artificialDelay))
                .max()
                .ifPresent(max ->
                        System.out.println(Thread.currentThread() + " completed finding " + max + " primes.")
                );
    }

    private static void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ignored) {
        }
    }

    private static boolean isPrime(long n) {
        if (n <= 1) return false;

        return IntStream
                .rangeClosed(2, (int) Math.sqrt(n))
                .noneMatch(divisor -> n % divisor == 0);
    }
}
