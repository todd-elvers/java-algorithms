package te.interview.prep.integers;

/**
 * @see <a href="https://leetcode.com/problems/perfect-squares/">Problem on leetcode</a>
 */
public class PerfectSquareCounter {

    // Time: O(n^1.5) = ~O(n), Space: O(n)
    static class UsingDynamicProgramming {
        public int countPerfectSquaresUpTo(int n) {
            if (n == 0) return 0;

            int[] squares = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j * j <= i; j++) {
                    squares[i] = minimumOf(squares[i], squares[i - (j * j)] + 1);
                }
            }

            return squares[n];
        }

        private int minimumOf(int value1, int value2) {
            return (value1 == 0) ? value2 : Math.min(value1, value2);
        }
    }

    // Time: O(sqrt(n)), Space: O(1)
    static class UsingFourSquareTheorem {

        /**
         * Lagrange's Four-Square Theorem states that any integer can be
         * represented as the sum of at most 4 integers.
         *
         * Values of the form n^2 are the sum of a single integer.
         * Values of the form 4^n(8k+7) are a sum of 4 integers.
         * Values that are the sum of two squares are the sum of 2 integers.
         * All other values are the sum of 3 integers.
         *
         * Complexity:
         * Time: O(sqrt(n)), Space: O(1)
         */
        public int countPerfectSquaresUpTo(int n) {
            if (n == 0) return 0;
            if (isSquare(n)) return 1;
            if (isSumOfFourIntegers(n)) return 4;
            if (isSumOfSquares(n)) return 2;
            return 3;
        }

        private boolean isSquare(int n) {
            int squareRoot = squareRoot(n);
            return squareRoot * squareRoot == n;
        }

        private int squareRoot(int n) {
            return (int) Math.sqrt(n);
        }

        // Values form 4^n(8k+7) cannot be decomposed/reduced past the sum of 4 integers.
        private boolean isSumOfFourIntegers(int n) {
            while (n % 4 == 0) n /= 4;
            return n % 8 == 7;
        }

        // O(log n)
        private boolean isSumOfSquares(int n) {
            for (int i = 1; i <= squareRoot(n); i++) {
                if (isSquare(n - (i * i))) return true;
            }

            return false;
        }
    }
}
