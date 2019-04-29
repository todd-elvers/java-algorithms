package te.interview.prep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/diagonal-traverse/">Problem on leetcode</a>
 */
public class DiagonalMatrixOrderFinder {

    public int[] findDiagonalOrder(int[][] input) {
        if(input == null || input.length == 0) return new int[0];

        List<Integer> results = new ArrayList<>();

        int row = 0, column = 0;
        boolean wasSupposedToTraverseDown = false;
        while (row <= input.length - 1) {
            List<Integer> values = getValuesDiagonallyUp(new ArrayList<>(), input, row++, column);
            if (wasSupposedToTraverseDown) Collections.reverse(values);
            wasSupposedToTraverseDown = !wasSupposedToTraverseDown;
            results.addAll(values);
        }

        row--;      // Row is currently out-of-bounds since the above loop terminated, so we must correct that
        column++;   // Column was 0 in all previous calls, so we must start it at one to prevent duplicate counts

        while (column <= input[row].length - 1) {
            List<Integer> values = getValuesDiagonallyUp(new ArrayList<>(), input, row, column++);
            if (wasSupposedToTraverseDown) Collections.reverse(values);
            wasSupposedToTraverseDown = !wasSupposedToTraverseDown;
            results.addAll(values);
        }

        return results.stream().mapToInt(i -> i).toArray();
    }

    private List<Integer> getValuesDiagonallyUp(List<Integer> values, int[][] input, int row, int column) {
        if (row < 0 || row > input.length - 1) return values;            // Base case: row is out-of-bounds
        if (column < 0 || column > input[row].length - 1) return values; // Base case: column is out-of-bounds

        values.add(input[row][column]);

        return getValuesDiagonallyUp(values, input, row - 1, column + 1);
    }

}
