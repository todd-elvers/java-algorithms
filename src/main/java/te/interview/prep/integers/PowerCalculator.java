package te.interview.prep.integers;

/**
 * @see <a href="https://leetcode.com/problems/powx-n/">Problem on leetcode</a>
 */
// TODO: Review later and try to remember both required formulas
public class PowerCalculator {

    /*
        Time: O(log n)
            Each time we apply our (x^n)^2 = x^2n formula we reduce n by half
        Space: O(log n)
            Each time we apply the above formula we store the result of x^n/2 in the stack
     */
    public double calculate(double x, int exponent) {
        long n = exponent;

        // When exponent is negative calculate 1/x^n since it is equivalent to x^-n
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return calculateFastPower(x, n);
    }

    /**
     * Takes advantage of the rule (x^n)^2 = x^2n to only calculate half of the values of x^n.
     *
     * If (x^n)^2 = x^2n then x^n/2 * x^n/2 = x^n. Edge case: if n is odd then
     * x^n/2 * x^n/2 = x^n-1 so we must multiply x one more time.
     */
    private double calculateFastPower(double x, long n) {
        if (n == 0) return 1.0;

        double half = calculateFastPower(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

}
