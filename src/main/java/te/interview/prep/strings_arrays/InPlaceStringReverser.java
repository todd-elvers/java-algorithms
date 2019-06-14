package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/reverse-string/">Problem on leetcode</a>
 */
public class InPlaceStringReverser {

    public void reverse(char[] chars) {
        if (chars == null || chars.length <= 1) return;

        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            swap(chars, i , j);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
