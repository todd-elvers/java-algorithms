package te.interview.prep.strings_arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/sentence-similarity/">Problem on leetcode</a>
 */
// NOTE: this is a bad problem b/c the solution assumes we only need to check word similarity
// at the same position, but the problem description does not state that at all.
public class SentenceSimilarityDeterminer {
    private static final String PAIR_SEPARATOR = " ";

    // Time : O(n+p), where n = max word length in either sentence and p = # of pairs
    // Space: O(p)
    public boolean determine(String[] sentence1, String[] sentence2, List<List<String>> pairs) {
        if (sentence1.length != sentence2.length) return false;

        Set<String> pairSet = new HashSet<>();
        for (List<String> pair : pairs) {
            pairSet.add(toPairString(pair.get(0), pair.get(1)));
        }

        for (int i = 0; i < sentence1.length; ++i) {
            if (sentence1[i].equals(sentence2[i])) continue;
            if (setDoesNotContainPair(pairSet, sentence1[i], sentence2[i])) return false;
        }

        return true;
    }

    private boolean setDoesNotContainPair(Set<String> pairSet, String x, String y) {
        return !pairSet.contains(toPairString(x, y)) && !pairSet.contains(toPairString(y, x));
    }

    private String toPairString(String a, String b) {
        return a + PAIR_SEPARATOR + b;
    }

}
