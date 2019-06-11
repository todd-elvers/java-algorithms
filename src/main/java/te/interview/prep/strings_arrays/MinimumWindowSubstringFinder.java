package te.interview.prep.strings_arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/minimum-window-substring/">Problem on leetcode</a>
 */
public class MinimumWindowSubstringFinder {
    private static final String NO_VALID_WINDOW_EXISTS = "";

    public String find(String str, String substr) {
        if (str.isEmpty() || substr.isEmpty()) return NO_VALID_WINDOW_EXISTS;

        Map<Character, Integer> windowCharCounts = new HashMap<>();
        Map<Character, Integer> substrChars = new HashMap<>();
        for (int i = 0; i < substr.length(); i++) {
            char c = substr.charAt(i);
            substrChars.put(c, substrChars.getOrDefault(c, 0) + 1);
        }

        int front = 0, back = 0;
        int minWindowFront = -1, minWindowBack = -1;
        while (front <= str.length() - 1) {
            char c = str.charAt(front);
            windowCharCounts.put(c, windowCharCounts.getOrDefault(c, 0) + 1);

            // If window contains all characters in substr
            if (windowContainsSubstr(substrChars, windowCharCounts)) {
                do {
                    c = str.charAt(back++);
                    windowCharCounts.put(c, windowCharCounts.get(c) - 1);
                } while (windowContainsSubstr(substrChars, windowCharCounts));

                // At which point (back-1,front) is the smallest valid string
                boolean isNewWindowSmaller = (minWindowFront - minWindowBack) > (front - (back - 1));
                if (minWindowFront == -1 || isNewWindowSmaller) {
                    minWindowFront = front;
                    minWindowBack = back - 1;
                }
            }

            front++;
        }

        return (minWindowFront == -1)
                ? NO_VALID_WINDOW_EXISTS
                : str.substring(minWindowBack, minWindowFront + 1);
    }

    private boolean windowContainsSubstr(Map<Character, Integer> substrChars, Map<Character, Integer> windowChars) {
        if (windowChars.size() < substrChars.size()) return false;

        for (Map.Entry<Character, Integer> entry : substrChars.entrySet()) {
            if (windowChars.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }

        return true;
    }

}
