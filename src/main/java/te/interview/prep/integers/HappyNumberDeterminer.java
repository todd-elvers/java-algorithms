package te.interview.prep.integers;

import java.util.HashSet;

/**
 * @see <a href="https://leetcode.com/problems/happy-number/">Problem on leetcode</a>
 */
public class HappyNumberDeterminer {

    public boolean isHappy(int n) {
        return isHappy(n, new HashSet<>());
    }

    private boolean isHappy(int n, HashSet<Integer> results) {
        int sum = sumOfSquareOfEachDigit(n);

        if(results.contains(sum)) {
            return false;
        }

        results.add(sum);

        return (sum == 1) || isHappy(sum, results);
    }

    private int sumOfSquareOfEachDigit(int n) {
        int sum = 0;

        while(n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }

        return sum;
    }
}
