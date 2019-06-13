package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/diagonal-traverse/">Problem on leetcode</a>
 */
public class DiagonalMatrixTraverser {

    public int[] traverse(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int row = 0, col = 0, direction = 1;
        int rowCount = matrix.length, columnCount = matrix[0].length;
        int[] result = new int[rowCount * columnCount];

        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[row][col];
            row -= direction;
            col += direction;

            // Bottom border boundary
            if (row > rowCount - 1) {
                row = rowCount - 1;
                col += 2;
                direction = -direction;
            }

            // Right border boundary
            if (col > columnCount - 1) {
                col = columnCount - 1;
                row += 2;
                direction = -direction;
            }

            // Top border boundary
            if (row < 0) {
                row = 0;
                direction = -direction;
            }

            // Left border boundary
            if (col < 0) {
                col = 0;
                direction = -direction;
            }
        }

        return result;
    }
}
