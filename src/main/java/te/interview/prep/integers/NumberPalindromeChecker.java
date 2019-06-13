package te.interview.prep.integers;

/**
 * @see <a href="https://leetcode.com/problems/palindrome-number/">Problem on leetcode</a>
 */
public class NumberPalindromeChecker {

    public boolean check(int x) {
        // Cannot be a palindrome if it's negative or divisible by 10
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;

        int original = x, rev = 0;
        while (x > 0) {
            // Move `rev` ahead a tens-place and add the next digit from `x` it it
            rev = (rev * 10) + (x % 10);

            // Decrease `x` by a factor of 10
            x = x / 10;
        }

        return original == rev;
    }

}
