package te.interview.prep;

import java.util.HashSet;

public class HappyNumberDeterminer {

    public boolean isHappy(int n) {
        return isHappy(n, new HashSet<>());
    }

    private boolean isHappy(int n, HashSet<Integer> results) {
        int sum = 0;
        while(n != 0) {
            int nextDigit = n % 10;
            sum += (nextDigit * nextDigit);
            n = n / 10;
        }

        if(results.contains(sum)) {
            return false;
        }

        results.add(sum);

        return (sum == 1) || isHappy(sum, results);
    }

}
