package te.interview.prep.integers;

/**
 * @see <a href="https://leetcode.com/problems/power-of-three/">Problem on leetcode</a>
 */
public class PowerOfThreeDeterminer {

    public boolean isPowerOfThree(int n) {
        return isPowerOf(n, 3);
    }

    /**
     *  Since our input is integers, (base^y = x) will only be possible when `y`
     *  is a whole number. This, along with the fact that (log[b]x = y) and (b^y = x)
     *  are equivalent, means checking whether `x` is a power of `base` reduces to
     *  checking whether (log[base]x) results in a whole number.
     *
     *  Formula for converting log[10]x to log[base]x:
     *
     *                  log[a]x
     *      log[b]x = ---------
     *                 log[a]b
     *
     * @return whether x is a power of base
     */
    private boolean isPowerOf(int x, int base) {
        return (Math.log10(x) / Math.log10(base)) % 1 == 0;
    }

}
