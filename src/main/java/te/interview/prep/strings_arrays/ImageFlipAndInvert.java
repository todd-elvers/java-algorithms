package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/flipping-an-image/">Problem on leetcode</a>
 */
public class ImageFlipAndInvert {

    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            flipAndInvertRow(row);
        }

        return image;
    }

    private void flipAndInvertRow(int[] row) {
        for (int i = 0, j = row.length - 1; i <= j; i++, j--) {
            // Edge case: only valid operation on the middle element is inversion
            if(i == j) {
                invertValue(row, i);
            } else {
                flipValues(row, i, j);
                invertValue(row, i);
                invertValue(row, j);
            }
        }
    }

    private void flipValues(int[] row, int i, int j) {
        if (i == j) return;
        int temp = row[i];
        row[i] = row[j];
        row[j] = temp;
    }

    private void invertValue(int[] row, int x) {
        row[x] = (row[x] == 0) ? 1 : 0;
    }

}
