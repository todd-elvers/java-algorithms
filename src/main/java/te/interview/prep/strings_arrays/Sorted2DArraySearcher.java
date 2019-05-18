package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/search-a-2d-matrix-ii/">Problem on leetcode</a>
 */
public class Sorted2DArraySearcher {

    // Time: O(n + m), Space: O(1)
    public boolean search(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = matrix.length - 1, column = 0;
        while (row >= 0 && column <= matrix[0].length - 1) {
            if (matrix[row][column] < k) {
                column++;
            } else if (matrix[row][column] > k) {
                row--;
            } else {
                return true;
            }
        }

        return false;
    }

}
