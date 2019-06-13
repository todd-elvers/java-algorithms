package te.interview.prep.threading;

import java.util.Collection;
import java.util.concurrent.ForkJoinPool;
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
@SuppressWarnings("Duplicates")
public class ParallelStreamShortcoming {

    public static void main(String[] args) throws InterruptedException {
        exampleOfProblem();
        exampleOfSolution();
    }

    private static void exampleOfProblem() throws InterruptedException {
        System.out.println("\nStarting problem scenario.");
        ForkJoinPool commonPool = new ForkJoinPool(8);

        // Pretend a bunch of tasks were started from different threads that
        // execute without any delay
        commonPool.execute(() -> runTask(0));
        commonPool.execute(() -> runTask(0));
        commonPool.execute(() -> runTask(0));
        commonPool.execute(() -> runTask(0));
        commonPool.execute(() -> runTask(0));

        // Then a piece of code somewhere tries to run a parallel task that executes
        // with a 1 millisecond delay between every calculation, 1 million times.
        // Comment this line out to prove it's the culprit of our slow performance.
        commonPool.execute(() -> runTask(1));

        commonPool.shutdown();
        commonPool.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("All threads in `commonPool` have completed.");
    }

    // This shows how always using your own thread pool guarantees we don't run into the problem
    private static void exampleOfSolution() throws InterruptedException {
        System.out.println("\nStarting solution scenario.");

        ForkJoinPool slowPool = new ForkJoinPool(8);
        slowPool.execute(() -> runTask(1));

        ForkJoinPool fastPool = new ForkJoinPool(8);
        fastPool.execute(() -> runTask(0));
        fastPool.execute(() -> runTask(0));
        fastPool.execute(() -> runTask(0));
        fastPool.execute(() -> runTask(0));
        fastPool.execute(() -> runTask(0));

        fastPool.shutdown();
        fastPool.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("All threads in `fastPool` have completed.");

        slowPool.shutdown();
        slowPool.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("All threads in `slowPool` have completed.");
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
