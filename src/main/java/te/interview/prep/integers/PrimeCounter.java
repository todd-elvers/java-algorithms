package te.interview.prep.integers;

/**
 * @see <a href="https://leetcode.com/problems/count-primes/">Problem on leetcode</a>
 */
//TODO: Review this & ensure this algorithm is memorized
public class PrimeCounter {

    /**
     * Instead of using the Sieve of Eratosthenes to find/include all prime numbers
     * we instead hunt for all odd numbers that are not primes and ignore/exclude them.
     */
    // Time: O(log log n), Space: O(n)
    public int countPrimesUpTo(int n) {
        if (n <= 2) return 0;

        // Half of the values up to n are even, so we can rule them out as primes immediately
        int primeCount = n / 2;

        // For every odd number i up to sqr(n)
        boolean[] isComposite = new boolean[n];
        for (int i = 3; i * i < n; i += 2) {
            if (isComposite[i]) continue;

            // Walk up from i^2 up to n by odd numbers looking for composite numbers
            for (int j = i * i; j < n; j += 2 * i) {
                if (!isComposite[j]) {
                    primeCount--;
                    isComposite[j] = true;
                }
            }
        }

        return primeCount;
    }

}
