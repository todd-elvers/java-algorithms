package te.interview.prep.integers;

/**
 * @see <a href="https://leetcode.com/problems/power-of-four/">Problem on leetcode</a>
 */
public class PowerOfFourDeterminer {

    public boolean isPowerOfFour(int n) {
        return isPowerOf(n, 4);
    }

    /**
     *  For `x` to be a power of `base` there must exist some whole number `y`
     *  that we can use to satisfy (base^y = x).  To derive `y` we can use
     *  (log[base]x = y) since it is equivalent.  Once we have derived `y`
     *  we simply check that it is a whole number and, if it is, then `x`
     *  is a power of `base`.
     *
     *  Java provides log[10] so we use the following formula to convert to log[base]:
     *
     *                  log[a]x
     *      log[b]x = ---------
     *                  log[a]b
     *
     * @return whether x is a power of base
     */
    private boolean isPowerOf(int x, int base) {
        return (Math.log10(x) / Math.log10(base)) % 1 == 0;
    }

}
