package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/first-unique-character-in-a-string/">Problem on leetcode</a>
 */
//TODO: Review and find out why this is so fast
public class FirstUniqueCharacterFinder {
    private static final int NO_UNIQUE_CHARS_FOUND = -1;

    // Time: O(?), Space: O(1)
    public int firstUniqChar(String str) {
        if (str == null || str.isEmpty()) return NO_UNIQUE_CHARS_FOUND;

        int firstIndexOfUniqueChar = Integer.MAX_VALUE;
        for (char i = 'a'; i <= 'z'; i++) {
            int firstIndex = str.indexOf(i);

            // Update our minimum index if the char we're on exists only once in `str`
            if (firstIndex != -1 && firstIndex == str.lastIndexOf(i)) {
                firstIndexOfUniqueChar = Math.min(firstIndex, firstIndexOfUniqueChar);
            }
        }

        return firstIndexOfUniqueChar < Integer.MAX_VALUE
                ? firstIndexOfUniqueChar
                : NO_UNIQUE_CHARS_FOUND;
    }

}
