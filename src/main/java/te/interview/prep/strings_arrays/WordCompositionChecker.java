package te.interview.prep.strings_arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/word-break/">Problem on leetcode</a>
 */
public class WordCompositionChecker {

    // Time: O(n^2)  Space: O(n)
    public boolean isComprisedOfWords(String input, List<String> wordDict) {
        return isCompoundWord(
                input, new HashSet<>(wordDict), new StringBuilder(), new Boolean[input.length()], 0
        );
    }

    private boolean isCompoundWord(String input, Set<String> dict, StringBuilder buffer, Boolean[] visitedLetters, int start) {
        // Base case: to completely process the input means it was entirely comprised of words from dict
        if (start > input.length() - 1) return true;

        // Memoization: only process letters we haven't already processed
        if (visitedLetters[start] != null) return visitedLetters[start];

        for (int i = start; i < input.length(); i++) {
            buffer.append(input.charAt(i));

            if (dict.contains(buffer.toString())) {
                visitedLetters[start] = isCompoundWord(
                        input, dict, new StringBuilder(), visitedLetters, i + 1
                );

                if(visitedLetters[start]) return true;
            }
        }

        return false;
    }
}
