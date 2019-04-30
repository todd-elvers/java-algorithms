package te.interview.prep.strings_arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/spiral-matrix/">Problem on leetcode</a>
 */
public class SpiralMatrixTraverser {

    public List<Integer> traverse(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return Collections.emptyList();

        List<Integer> results = new ArrayList<>();
        traverseMatrix(results, matrix, new boolean[matrix.length][matrix[0].length], 0, 0);
        return results;
    }

    /**
     * Algorithm, in order:
     *      - Go right as far as possible
     *      - Go down as far as possible
     *      - Go left as far as possible
     *      - Go up as far as possible (edge case: don't go right before you've gone all the way up)
     */
    private void traverseMatrix(List<Integer> results, int[][] matrix, boolean[][] visited, int row, int column) {
        if (row < 0 || row > matrix.length - 1 || column < 0 || column > matrix[row].length - 1 || visited[row][column]) {
            return;
        }

        visited[row][column] = true;

        results.add(matrix[row][column]);

        // Edge case: only go right if we're on the first row or the row above is already visited
        if (row == 0 || visited[row - 1][column]) {
            traverseMatrix(results, matrix, visited, row, column + 1);
        }

        traverseMatrix(results, matrix, visited, row + 1, column);
        traverseMatrix(results, matrix, visited, row, column - 1);
        traverseMatrix(results, matrix, visited, row - 1, column);
    }
}
