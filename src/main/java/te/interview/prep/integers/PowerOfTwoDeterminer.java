package te.interview.prep.integers;

/**
 * @see <a href="https://leetcode.com/problems/power-of-two/">Problem on leetcode</a>
 */
public class PowerOfTwoDeterminer {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }

}
