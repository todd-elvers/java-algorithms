package te.interview.prep.strings_arrays.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/palindrome-partitioning/">Problem on leetcode</a>
 */
public class PalindromePartitioner {

    public List<List<String>> partition(String str) {
        return backtrack(new ArrayList<>(), new ArrayList<>(), str, 0);
    }

    private List<List<String>> backtrack(List<List<String>> results, List<String> temp, String str, int start) {
        if (start == str.length()) {
            results.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < str.length(); i++) {
                if (!isPalindrome(str, start, i)) continue;

                temp.add(str.substring(start, i + 1));
                backtrack(results, temp, str, i + 1);
                temp.remove(temp.size() - 1);
            }
        }

        return results;
    }

    protected boolean isPalindrome(String s, int start, int end) {
        if (s == null) return false;

        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;
    }
}
