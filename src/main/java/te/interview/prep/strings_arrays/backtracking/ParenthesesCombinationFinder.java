package te.interview.prep.strings_arrays.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/generate-parentheses/">Problem on leetcode</a>
 */
public class ParenthesesCombinationFinder {

    List<String> findCombinations(int n) {
        ArrayList<String> results = new ArrayList<>();
        backtrack(results, "", 0, 0, n);
        return results;
    }

    private void backtrack(List<String> results, String result, int openCount, int closedCount, int n) {
        if (result.length() == 2*n) {
            results.add(result);
        } else {
            // Don't let more than n characters of our result be ( characters, otherwise it'll be invalid
            if(openCount < n) {
                backtrack(results, result + "(", openCount + 1, closedCount, n);
            }

            // Simply close the parentheses when open parentheses exist
            if(closedCount < openCount) {
                backtrack(results, result + ")", openCount, closedCount + 1, n);
            }
        }
    }

}
