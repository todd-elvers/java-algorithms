package te.interview.prep.strings_arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/diagonal-traverse/">Problem on leetcode</a>
 */
public class DiagonalMatrixOrderFinder {

    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new int[0];

        List<Integer> results = new ArrayList<>();

        int row = 0, column = 0;
        boolean wasSupposedToTraverseDown = false;
        while (row <= matrix.length - 1) {
            List<Integer> values = getValuesDiagonallyUp(new ArrayList<>(), matrix, row++, column);
            if (wasSupposedToTraverseDown) Collections.reverse(values);
            wasSupposedToTraverseDown = !wasSupposedToTraverseDown;
            results.addAll(values);
        }

        row--;      // Row is currently out-of-bounds since the above loop terminated, so we must correct that
        column++;   // Column was 0 in all previous calls, so we must start it at one to prevent duplicate counts

        while (column <= matrix[row].length - 1) {
            List<Integer> values = getValuesDiagonallyUp(new ArrayList<>(), matrix, row, column++);
            if (wasSupposedToTraverseDown) Collections.reverse(values);
            wasSupposedToTraverseDown = !wasSupposedToTraverseDown;
            results.addAll(values);
        }

        return results.stream().mapToInt(i -> i).toArray();
    }

    private List<Integer> getValuesDiagonallyUp(List<Integer> values, int[][] matrix, int row, int column) {
        if (row < 0 || row > matrix.length - 1) return values;            // Base case: row is out-of-bounds
        if (column < 0 || column > matrix[row].length - 1) return values; // Base case: column is out-of-bounds

        values.add(matrix[row][column]);

        return getValuesDiagonallyUp(values, matrix, row - 1, column + 1);
    }

}
